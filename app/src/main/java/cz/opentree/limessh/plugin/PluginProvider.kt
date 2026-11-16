package cz.opentree.limessh.plugin

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.database.MatrixCursor
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import androidx.sqlite.db.SimpleSQLiteQuery
import cz.opentree.limessh.LimeApp
import cz.opentree.limessh.data.local.AppDatabase
import java.util.UUID

/** Namespaced, permission-checked v2 data API. Never exposes identities or credentials. */
class PluginProvider : ContentProvider() {
    private lateinit var db: AppDatabase

    private data class Resource(
        val table: String,
        val permission: String,
        val columns: Map<String, String>,
        val defaults: Map<String, Any?>,
    )

    private val resources = mapOf(
        "connections" to Resource("connections", "CONNECTIONS", linkedMapOf(
            "id" to "id", "modified" to "modifiedAt", "name" to "name", "address" to "address",
            "port" to "port", "nickname" to "nickname", "type" to "type"),
            mapOf("name" to "", "address" to "", "port" to 22, "nickname" to "", "type" to 0,
                "identityId" to null, "groupId" to null, "createdAt" to 0L)),
        "snippets" to Resource("snippets", "SNIPPETS", linkedMapOf(
            "id" to "id", "modified" to "modifiedAt", "name" to "name", "content" to "content"),
            mapOf("name" to "", "content" to "", "runOnConnect" to 0, "connectionId" to null)),
        "portforwards" to Resource("port_forwards", "PORT_FORWARDS", linkedMapOf(
            "id" to "id", "modified" to "modifiedAt", "name" to "name", "mode" to "mode",
            "connection_id" to "connectionId", "host" to "host", "localPort" to "localPort",
            "remotePort" to "remotePort", "openInBrowser" to "openInBrowser"),
            mapOf("name" to "", "mode" to 0, "connectionId" to null, "host" to "localhost",
                "localPort" to 0, "remotePort" to 0, "openInBrowser" to 0)),
        "connectiongroups" to Resource("connection_groups", "GROUPS", linkedMapOf(
            "id" to "id", "modified" to "modifiedAt", "name" to "name"), mapOf("name" to "")),
    )

    override fun onCreate(): Boolean {
        db = AppDatabase.getInstance(requireNotNull(context))
        return true
    }

    private fun checkPermission(suffix: String) {
        val app = requireNotNull(context).applicationContext as LimeApp
        check(!app.settings.checkLock()) { "limessh is locked" }
        requireNotNull(context).enforceCallingOrSelfPermission(
            "cz.opentree.limessh.permission.$suffix", "Plugin permission required: $suffix",
        )
    }

    private fun route(uri: Uri): String {
        require(uri.authority == PluginContract.AUTHORITY && uri.pathSegments.size in 1..2) { "Invalid plugin URI" }
        return uri.pathSegments.first()
    }

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?,
        selectionArgs: Array<out String>?, sortOrder: String?): Cursor {
        val name = route(uri)
        if (name == "pluginlog") {
            checkPermission("READ_PLUGIN_LOG")
            require(selection == null && selectionArgs.isNullOrEmpty() && sortOrder == null)
            val columns = projection ?: arrayOf("id", "modified", "packageName", "message")
            require(columns.all { it in setOf("id", "modified", "packageName", "message") })
            return MatrixCursor(columns).apply {
                val app = requireNotNull(context).applicationContext as LimeApp
                app.auditLog.getEntries().forEach { entry ->
                    val row = mapOf("id" to entry.id.toString(), "modified" to entry.timestamp,
                        "packageName" to entry.source, "message" to entry.action.label)
                    addRow(columns.map { row[it] })
                }
            }
        }
        if (name == "connectiongroupmemberships") {
            checkPermission("READ_GROUPS")
            checkPermission("READ_CONNECTIONS")
            require(selection == null && selectionArgs.isNullOrEmpty() && sortOrder == null)
            val allowed = setOf("id", "group_id", "connection_id")
            val columns = projection ?: allowed.toTypedArray()
            require(columns.all { it in allowed })
            return db.openHelper.readableDatabase.query(
                "SELECT ${columns.joinToString(",")} FROM (SELECT id, groupId AS group_id, id AS connection_id FROM connections WHERE groupId IS NOT NULL)")
        }
        val resource = requireNotNull(resources[name]) { "Unknown plugin resource" }
        checkPermission("READ_${resource.permission}")
        val columns = projection ?: resource.columns.keys.toTypedArray()
        require(columns.isNotEmpty() && columns.all { it in resource.columns }) { "Unsupported projection" }
        val (where, args) = filter(uri, resource.columns.keys, selection, selectionArgs)
        val sort = sortOrder ?: "id ASC"
        require(sort.matches(Regex("(id|name|nickname|modified)( COLLATE NOCASE)? (ASC|DESC)", RegexOption.IGNORE_CASE))) { "Unsupported sort order" }
        require(sort.substringBefore(' ') in resource.columns)
        val mapping = resource.columns.entries.joinToString(",") { "${it.value} AS ${it.key}" }
        return db.openHelper.readableDatabase.query(SimpleSQLiteQuery(
            "SELECT ${columns.joinToString(",")} FROM (SELECT $mapping FROM ${resource.table})$where ORDER BY $sort LIMIT 10000", args.toTypedArray(),
        ))
    }

    private fun filter(uri: Uri, columns: Set<String>, selection: String?, args: Array<out String>?): Pair<String, List<String>> {
        val clauses = mutableListOf<String>()
        val values = mutableListOf<String>()
        if (uri.pathSegments.size == 2) {
            UUID.fromString(uri.lastPathSegment)
            clauses += "id = ?"
            values += requireNotNull(uri.lastPathSegment)
        }
        if (!selection.isNullOrBlank()) {
            val column = requireNotNull(Regex("^\\s*([a-zA-Z_]+)\\s*=\\s*\\?\\s*$").matchEntire(selection)) { "Only column = ? filters are supported" }.groupValues[1]
            require(column in columns && args?.size == 1)
            clauses += "$column = ?"
            values += args!!.single()
        } else require(args.isNullOrEmpty())
        return (if (clauses.isEmpty()) "" else " WHERE " + clauses.joinToString(" AND ")) to values
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri {
        val resource = writable(uri)
        require(uri.pathSegments.size == 1)
        val data = convert(resource, requireNotNull(values), insert = true)
        val id = data.getAsString("id")
        db.openHelper.writableDatabase.insert(resource.table, SQLiteDatabase.CONFLICT_ABORT, data)
        db.invalidationTracker.refreshVersionsAsync()
        requireNotNull(context).contentResolver.notifyChange(uri, null)
        return uri.buildUpon().appendPath(id).build()
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        val resource = writable(uri)
        require(selection == null && selectionArgs.isNullOrEmpty() && uri.pathSegments.size == 2) { "Update requires an item URI" }
        val data = convert(resource, requireNotNull(values), insert = false)
        require(!data.containsKey("id")) { "IDs cannot be changed" }
        UUID.fromString(uri.lastPathSegment)
        val count = db.openHelper.writableDatabase.update(resource.table, SQLiteDatabase.CONFLICT_ABORT, data, "id = ?", arrayOf(uri.lastPathSegment))
        db.invalidationTracker.refreshVersionsAsync()
        requireNotNull(context).contentResolver.notifyChange(uri, null)
        return count
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        val resource = writable(uri)
        require(selection == null && selectionArgs.isNullOrEmpty() && uri.pathSegments.size == 2) { "Delete requires an item URI" }
        UUID.fromString(uri.lastPathSegment)
        val count = db.openHelper.writableDatabase.delete(resource.table, "id = ?", arrayOf(uri.lastPathSegment))
        db.invalidationTracker.refreshVersionsAsync()
        requireNotNull(context).contentResolver.notifyChange(uri, null)
        return count
    }

    private fun writable(uri: Uri): Resource {
        val resource = requireNotNull(resources[route(uri)]) { "Resource is read-only or unknown" }
        checkPermission("WRITE_${resource.permission}")
        return resource
    }

    private fun convert(resource: Resource, values: ContentValues, insert: Boolean): ContentValues {
        require(values.keySet().all { it in resource.columns && it != "modified" }) { "Unsupported write columns" }
        val data = ContentValues()
        if (insert) {
            resource.defaults.forEach { (key, value) -> putValue(data, key, value) }
            data.put("id", values.getAsString("id") ?: UUID.randomUUID().toString())
            if (resource.table == "connections") data.put("createdAt", System.currentTimeMillis())
        }
        values.valueSet().forEach { (key, value) -> putValue(data, resource.columns.getValue(key), value) }
        data.put("modifiedAt", System.currentTimeMillis())
        if (data.containsKey("id")) UUID.fromString(data.getAsString("id"))
        for (port in listOf("port", "localPort", "remotePort")) {
            if (data.containsKey(port)) require(data.getAsInteger(port) in 0..65535) { "Invalid port" }
        }
        if (data.containsKey("type")) require(data.getAsInteger("type") == 0) { "Only SSH is supported" }
        if (data.containsKey("mode")) require(data.getAsInteger("mode") in 0..2)
        return data
    }

    private fun putValue(data: ContentValues, key: String, value: Any?) {
        when (value) {
            null -> data.putNull(key)
            is String -> { require(value.length <= 65536); data.put(key, value) }
            is Number -> data.put(key, value.toLong())
            is Boolean -> data.put(key, if (value) 1 else 0)
            else -> error("Unsupported value type")
        }
    }

    override fun getType(uri: Uri): String =
        "vnd.android.cursor.${if (uri.pathSegments.size == 2) "item" else "dir"}/vnd.${PluginContract.AUTHORITY}.${route(uri)}"
}
