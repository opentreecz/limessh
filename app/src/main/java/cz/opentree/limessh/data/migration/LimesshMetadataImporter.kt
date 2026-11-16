package cz.opentree.limessh.data.migration

import android.content.Context
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.InputStream
import java.util.UUID
import androidx.room.withTransaction
import kotlinx.coroutines.CancellationException

/**
 * Imports explicitly supplied JSON connection metadata with UUID identifiers.
 * Encrypted backup envelopes, SQLite databases and credential recovery are not
 * implemented by this metadata importer.
 */
class LimesshMetadataImporter(
    private val context: Context,
    private val db: AppDatabase,
) {
    /**
     * Import connection metadata from the supported JSON sections.
     */
    suspend fun importFromJson(
        input: InputStream,
        passphrase: String? = null,
    ): MigrationReport = withContext(Dispatchers.IO) {
        try {
            require(passphrase == null) { "Encrypted legacy imports are not supported" }
            val bytes = java.io.ByteArrayOutputStream()
            val buffer = ByteArray(8192)
            while (true) {
                val count = input.read(buffer)
                if (count < 0) break
                require(bytes.size() + count <= 8 * 1024 * 1024) { "JSON export exceeds 8 MiB" }
                bytes.write(buffer, 0, count)
            }
            val content = bytes.toString("UTF-8")
            val json = JSONObject(content)
            require(listOf("connections", "identities", "groups", "connectionGroups", "snippets", "portForwards").any { json.has(it) }) { "No supported metadata sections found" }
            db.withTransaction { processMetadataJson(json, passphrase) }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            MigrationReport(success = false, error = "Failed to parse: ${e.message}")
        }
    }

    private suspend fun processMetadataJson(
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
                        id = idOf(obj),
                        name = obj.optString("nickname", obj.optString("address", "")),
                        address = obj.optString("address", ""),
                        port = obj.optInt("port", 22),
                        nickname = obj.optString("nickname", ""),
                        type = obj.optInt("type", 0),
                        identityId = reference(obj, "identityId"),
                        groupId = reference(obj, "groupId"),
                    )
                    require(entity.address.isNotBlank() && entity.port in 1..65535 && entity.type == 0) { "Only valid SSH connections can be imported" }
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
                        id = idOf(obj),
                        nickname = obj.optString("nickname", ""),
                        username = obj.optString("username", ""),
                        authMethod = obj.optInt("authMethod", 0),
                    )
                    db.identityDao().upsert(entity)
                    identities++

                    warnings.add("Identity '${entity.nickname}': metadata only; passwords/private keys were not imported")
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
                        id = idOf(obj),
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
                        id = idOf(obj),
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
                        id = idOf(obj),
                        name = obj.optString("name", ""),
                        mode = obj.optInt("mode", 0),
                        connectionId = reference(obj, "connectionId"),
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

    private fun idOf(json: JSONObject): String = UUID.fromString(json.optString("id", UUID.randomUUID().toString())).toString()

    private fun reference(json: JSONObject, key: String): String? =
        if (!json.has(key) || json.isNull(key)) null else UUID.fromString(json.getString(key)).toString()
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
