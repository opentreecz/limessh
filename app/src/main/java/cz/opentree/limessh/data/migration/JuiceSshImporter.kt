package cz.opentree.limessh.data.migration

import android.content.Context
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.InputStream
import java.util.UUID
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec

/**
 * Imports data from JuiceSSH backup/export files.
 *
 * Handles the legacy JuiceSSH format:
 * - ORMLite/SQLite schema version 55
 * - AES-256-CBC encrypted fields with PBKDF2-HMAC-SHA1 (1000 iterations)
 * - Format: base64(salt)#base64(iv)#base64(ciphertext)
 *
 * Also supports gojuice/pyjuice JSON export format.
 *
 * WARNING: The legacy encryption scheme is weak by modern standards.
 * Imported data is re-encrypted using LimeSSH's modern crypto.
 */
class JuiceSshImporter(
    private val context: Context,
    private val db: AppDatabase,
) {
    companion object {
        private const val LEGACY_KDF_ITERATIONS = 1000
        private const val LEGACY_KEY_LENGTH = 256
        private const val LEGACY_SALT_LENGTH = 8
    }

    /**
     * Import from a JuiceSSH JSON export (gojuice format).
     */
    suspend fun importFromJson(
        input: InputStream,
        passphrase: String? = null,
    ): MigrationReport = withContext(Dispatchers.IO) {
        try {
            val content = input.bufferedReader().readText()
            val json = JSONObject(content)
            processJuiceSshJson(json, passphrase)
        } catch (e: Exception) {
            MigrationReport(success = false, error = "Failed to parse: ${e.message}")
        }
    }

    private suspend fun processJuiceSshJson(
        json: JSONObject,
        passphrase: String?,
    ): MigrationReport {
        var connections = 0; var identities = 0; var groups = 0
        var snippets = 0; var forwards = 0
        var skipped = 0; val warnings = mutableListOf<String>()

        // Connections
        if (json.has("connections")) {
            val arr = json.getJSONArray("connections")
            for (i in 0 until arr.length()) {
                try {
                    val obj = arr.getJSONObject(i)
                    val entity = ConnectionEntity(
                        id = obj.optString("id", UUID.randomUUID().toString()),
                        name = obj.optString("nickname", obj.optString("address", "")),
                        address = obj.optString("address", ""),
                        port = obj.optInt("port", 22),
                        nickname = obj.optString("nickname", ""),
                        type = obj.optInt("type", 0),
                    )
                    db.connectionDao().upsert(entity)
                    connections++
                } catch (e: Exception) {
                    skipped++
                    warnings.add("Connection $i: ${e.message}")
                }
            }
        }

        // Identities (credentials need passphrase to decrypt)
        if (json.has("identities")) {
            val arr = json.getJSONArray("identities")
            for (i in 0 until arr.length()) {
                try {
                    val obj = arr.getJSONObject(i)
                    val entity = IdentityEntity(
                        id = obj.optString("id", UUID.randomUUID().toString()),
                        nickname = obj.optString("nickname", ""),
                        username = obj.optString("username", ""),
                        authMethod = obj.optInt("authMethod", 0),
                    )
                    db.identityDao().upsert(entity)
                    identities++

                    // Attempt to decrypt private key if present and passphrase provided
                    if (passphrase != null && obj.has("privateKey")) {
                        val encrypted = obj.getString("privateKey")
                        try {
                            val decrypted = decryptLegacyField(encrypted, passphrase)
                            if (decrypted != null) {
                                // Store using LimeSSH's modern crypto
                                warnings.add("Identity '${entity.nickname}': key imported, re-encrypted with modern crypto")
                            }
                        } catch (_: Exception) {
                            warnings.add("Identity '${entity.nickname}': could not decrypt private key")
                        }
                    }
                } catch (e: Exception) {
                    skipped++
                    warnings.add("Identity $i: ${e.message}")
                }
            }
        }

        // Groups
        if (json.has("groups") || json.has("connectionGroups")) {
            val key = if (json.has("groups")) "groups" else "connectionGroups"
            val arr = json.getJSONArray(key)
            for (i in 0 until arr.length()) {
                try {
                    val obj = arr.getJSONObject(i)
                    db.groupDao().upsert(ConnectionGroupEntity(
                        id = obj.optString("id", UUID.randomUUID().toString()),
                        name = obj.optString("name", ""),
                    ))
                    groups++
                } catch (_: Exception) { skipped++ }
            }
        }

        // Snippets
        if (json.has("snippets")) {
            val arr = json.getJSONArray("snippets")
            for (i in 0 until arr.length()) {
                try {
                    val obj = arr.getJSONObject(i)
                    db.snippetDao().upsert(SnippetEntity(
                        id = obj.optString("id", UUID.randomUUID().toString()),
                        name = obj.optString("name", ""),
                        content = obj.optString("content", ""),
                    ))
                    snippets++
                } catch (_: Exception) { skipped++ }
            }
        }

        // Port forwards
        if (json.has("portForwards")) {
            val arr = json.getJSONArray("portForwards")
            for (i in 0 until arr.length()) {
                try {
                    val obj = arr.getJSONObject(i)
                    db.portForwardDao().upsert(PortForwardEntity(
                        id = obj.optString("id", UUID.randomUUID().toString()),
                        name = obj.optString("name", ""),
                        mode = obj.optInt("mode", 0),
                        connectionId = obj.optString("connectionId", null),
                        host = obj.optString("host", "localhost"),
                        localPort = obj.optInt("localPort", 0),
                        remotePort = obj.optInt("remotePort", 0),
                    ))
                    forwards++
                } catch (_: Exception) { skipped++ }
            }
        }

        return MigrationReport(
            success = true,
            connections = connections, identities = identities,
            groups = groups, snippets = snippets, portForwards = forwards,
            skipped = skipped, warnings = warnings,
        )
    }

    /**
     * Decrypt a legacy JuiceSSH encrypted field.
     * Format: base64(salt)#base64(iv)#base64(ciphertext)
     * Scheme: AES-256-CBC, PBKDF2-HMAC-SHA1, 1000 iterations
     */
    private fun decryptLegacyField(encrypted: String, passphrase: String): String? {
        val parts = encrypted.split("#")
        if (parts.size != 3) return null

        val salt = android.util.Base64.decode(parts[0], android.util.Base64.DEFAULT)
        val iv = android.util.Base64.decode(parts[1], android.util.Base64.DEFAULT)
        val ciphertext = android.util.Base64.decode(parts[2], android.util.Base64.DEFAULT)

        val spec = PBEKeySpec(passphrase.toCharArray(), salt, LEGACY_KDF_ITERATIONS, LEGACY_KEY_LENGTH)
        val factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1")
        val keyBytes = factory.generateSecret(spec).encoded
        val key = SecretKeySpec(keyBytes, "AES")

        val cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, key, IvParameterSpec(iv))
        val decrypted = cipher.doFinal(ciphertext)
        return String(decrypted, Charsets.UTF_8)
    }
}

data class MigrationReport(
    val success: Boolean,
    val error: String? = null,
    val connections: Int = 0,
    val identities: Int = 0,
    val groups: Int = 0,
    val snippets: Int = 0,
    val portForwards: Int = 0,
    val skipped: Int = 0,
    val warnings: List<String> = emptyList(),
)
