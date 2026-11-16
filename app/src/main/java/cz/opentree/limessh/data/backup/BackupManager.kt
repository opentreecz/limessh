package cz.opentree.limessh.data.backup

import cz.opentree.limessh.data.local.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream
import java.io.OutputStream
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import androidx.room.withTransaction
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import java.io.DataInputStream

/**
 * Encrypted backup/restore manager for LimeSSH.
 *
 * Uses AES-256-GCM with PBKDF2-HMAC-SHA256 key derivation — a modern
 * replacement for the legacy AES-256-CBC/PBKDF2-SHA1/1000-iter scheme.
 *
 * Backup format:
 * - 4 bytes: magic "LIME"
 * - 2 bytes: format version (1)
 * - 32 bytes: salt
 * - 12 bytes: GCM IV
 * - rest: AES-256-GCM encrypted JSON payload
 */
class BackupManager(private val db: AppDatabase) {

    companion object {
        private val MAGIC = byteArrayOf('L'.code.toByte(), 'I'.code.toByte(), 'M'.code.toByte(), 'E'.code.toByte())
        private const val FORMAT_VERSION: Short = 1
        private const val SALT_LENGTH = 32
        private const val IV_LENGTH = 12
        private const val GCM_TAG_BITS = 128
        private const val KDF_ITERATIONS = 600_000 // Development default; calibrate on target devices.
        private const val KEY_LENGTH_BITS = 256
    }

    /**
     * Export all data as an encrypted backup.
     */
    suspend fun export(
        output: OutputStream,
        passphrase: String,
        includeCredentials: Boolean = false,
    ) = withContext(Dispatchers.IO) {
        require(passphrase.length >= 8) { "Use a backup passphrase of at least 8 characters" }
        require(!includeCredentials) { "Credential export is not supported; this backup contains configuration only" }
        val payload = db.withTransaction { buildExportPayload(includeCredentials) }
        val plaintext = payload.toString().toByteArray(Charsets.UTF_8)

        val random = SecureRandom()
        val salt = ByteArray(SALT_LENGTH).also { random.nextBytes(it) }
        val iv = ByteArray(IV_LENGTH).also { random.nextBytes(it) }

        val key = deriveKey(passphrase, salt)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, key, GCMParameterSpec(GCM_TAG_BITS, iv))
        val encrypted = cipher.doFinal(plaintext)

        output.write(MAGIC)
        output.write(byteArrayOf((FORMAT_VERSION.toInt() shr 8).toByte(), FORMAT_VERSION.toByte()))
        output.write(salt)
        output.write(iv)
        output.write(encrypted)
        output.flush()
    }

    /**
     * Import data from an encrypted backup.
     * Returns a report of what was imported.
     */
    suspend fun import(
        input: InputStream,
        passphrase: String,
    ): ImportReport = withContext(Dispatchers.IO) {
        val reader = DataInputStream(input)
        val header = ByteArray(4)
        reader.readFully(header)
        if (!header.contentEquals(MAGIC)) {
            return@withContext ImportReport(success = false, error = "Invalid backup file")
        }

        val versionBytes = ByteArray(2)
        reader.readFully(versionBytes)
        val version = ((versionBytes[0].toInt() and 0xFF) shl 8) or (versionBytes[1].toInt() and 0xFF)
        if (version != FORMAT_VERSION.toInt()) {
            return@withContext ImportReport(success = false, error = "Unsupported backup version: $version")
        }

        val salt = ByteArray(SALT_LENGTH)
        reader.readFully(salt)
        val iv = ByteArray(IV_LENGTH)
        reader.readFully(iv)
        val bytes = java.io.ByteArrayOutputStream()
        val buffer = ByteArray(8192)
        while (true) {
            val count = reader.read(buffer)
            if (count < 0) break
            require(bytes.size() + count <= 16 * 1024 * 1024) { "Backup exceeds 16 MiB" }
            bytes.write(buffer, 0, count)
        }
        val encrypted = bytes.toByteArray()

        val key = deriveKey(passphrase, salt)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, GCMParameterSpec(GCM_TAG_BITS, iv))
            val plaintext = cipher.doFinal(encrypted)
            val json = JSONObject(String(plaintext, Charsets.UTF_8))
            processImportPayload(json)
        } catch (e: Exception) {
            ImportReport(success = false, error = "Decryption failed — wrong passphrase or corrupted file")
        }
    }

    private suspend fun buildExportPayload(includeCredentials: Boolean): JSONObject {
        val json = JSONObject()
        json.put("version", FORMAT_VERSION)
        json.put("exported_at", System.currentTimeMillis())
        json.put("app", "LimeSSH")

        json.put("includes_credentials", false)
        tables.forEach { (section, table) ->
            val rows = JSONArray()
            db.openHelper.readableDatabase.query("SELECT * FROM $table").use { cursor ->
                while (cursor.moveToNext()) {
                    val row = JSONObject()
                    cursor.columnNames.forEachIndexed { index, name ->
                        row.put(name, when (cursor.getType(index)) {
                            Cursor.FIELD_TYPE_NULL -> JSONObject.NULL
                            Cursor.FIELD_TYPE_INTEGER -> cursor.getLong(index)
                            Cursor.FIELD_TYPE_STRING -> cursor.getString(index)
                            else -> error("Unsupported backup field $name")
                        })
                    }
                    rows.put(row)
                }
            }
            json.put(section, rows)
        }

        return json
    }

    private suspend fun processImportPayload(json: JSONObject): ImportReport {
        require(json.getString("app") == "LimeSSH" && json.getInt("version") == FORMAT_VERSION.toInt())
        // Validate all row shapes before entering the atomic import transaction.
        val staged = tables.mapValues { (section, table) ->
            val columns = db.openHelper.readableDatabase.query("SELECT * FROM $table LIMIT 0").use { it.columnNames.toSet() }
            val array = json.getJSONArray(section)
            require(array.length() <= 10000) { "Too many records" }
            (0 until array.length()).map { index ->
                val row = array.getJSONObject(index)
                require(row.keys().asSequence().toSet() == columns) { "Unsupported row format in $section" }
                ContentValues().apply {
                    columns.forEach { column ->
                        when (val value = row.get(column)) {
                            JSONObject.NULL -> putNull(column)
                            is String -> { require(value.length <= 1048576); put(column, value) }
                            is Number -> put(column, value.toLong())
                            else -> error("Invalid backup value")
                        }
                    }
                    if (containsKey("id")) java.util.UUID.fromString(getAsString("id"))
                    for (column in listOf("identityId", "groupId", "connectionId")) {
                        getAsString(column)?.let { java.util.UUID.fromString(it) }
                    }
                    for (column in listOf("port", "localPort", "remotePort")) {
                        if (containsKey(column)) require(getAsInteger(column) in 0..65535)
                    }
                }
            }
        }
        db.withTransaction {
            staged.forEach { (section, rows) ->
                rows.forEach { row ->
                    if (section == "known_hosts") {
                        // Merge by host/port instead of replacing an unrelated auto-generated row ID.
                        db.openHelper.writableDatabase.delete("known_hosts", "hostname = ? AND port = ?",
                            arrayOf(row.getAsString("hostname"), row.getAsInteger("port")))
                        row.remove("rowId")
                    }
                    db.openHelper.writableDatabase.insert(tables.getValue(section), SQLiteDatabase.CONFLICT_REPLACE, row)
                }
            }
        }
        db.invalidationTracker.refreshVersionsAsync()

        return ImportReport(
            success = true,
            connections = staged.getValue("connections").size,
            identities = staged.getValue("identities").size,
            snippets = staged.getValue("snippets").size,
            portForwards = staged.getValue("port_forwards").size,
            groups = staged.getValue("groups").size,
            knownHosts = staged.getValue("known_hosts").size,
        )
    }

    private fun deriveKey(passphrase: String, salt: ByteArray): SecretKeySpec {
        val spec = PBEKeySpec(passphrase.toCharArray(), salt, KDF_ITERATIONS, KEY_LENGTH_BITS)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256")
        return try {
            val keyBytes = factory.generateSecret(spec).encoded
            try { SecretKeySpec(keyBytes, "AES") } finally { keyBytes.fill(0) }
        } finally { spec.clearPassword() }
    }

    private val tables = linkedMapOf(
        "connections" to "connections", "identities" to "identities", "groups" to "connection_groups",
        "snippets" to "snippets", "port_forwards" to "port_forwards", "known_hosts" to "known_hosts",
    )
}

data class ImportReport(
    val success: Boolean,
    val error: String? = null,
    val connections: Int = 0,
    val identities: Int = 0,
    val snippets: Int = 0,
    val portForwards: Int = 0,
    val groups: Int = 0,
    val knownHosts: Int = 0,
    val skipped: Int = 0,
)
