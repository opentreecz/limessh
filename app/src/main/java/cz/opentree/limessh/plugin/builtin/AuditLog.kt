package cz.opentree.limessh.plugin.builtin

import cz.opentree.limessh.data.local.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.UUID
import java.util.concurrent.ConcurrentLinkedQueue

/**
 * Built-in Audit Log — inspired by the Apache-2.0 licensed
 * JuiceSSH Audit Log plugin (github.com/Sonelli/juicessh-auditlog).
 *
 * Records plugin and session activity events for security auditing.
 * Events are stored in-memory with optional persistence to the database.
 */
class AuditLog {

    private val entries = ConcurrentLinkedQueue<AuditEntry>()
    private val maxEntries = 10_000

    private val _entriesFlow = MutableStateFlow<List<AuditEntry>>(emptyList())
    val entriesFlow = _entriesFlow.asStateFlow()

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun log(
        source: String,
        action: AuditAction,
        connectionId: UUID? = null,
        details: String = "",
    ) {
        val entry = AuditEntry(
            id = UUID.randomUUID(),
            timestamp = System.currentTimeMillis(),
            source = source,
            action = action,
            connectionId = connectionId,
            details = details,
        )
        entries.add(entry)
        while (entries.size > maxEntries) entries.poll()
        _entriesFlow.value = entries.toList()
    }

    fun getEntries(): List<AuditEntry> = entries.toList()

    fun getEntriesForConnection(connectionId: UUID): List<AuditEntry> =
        entries.filter { it.connectionId == connectionId }

    fun clear() {
        entries.clear()
        _entriesFlow.value = emptyList()
    }

    fun formatEntry(entry: AuditEntry): String {
        val time = dateFormat.format(Date(entry.timestamp))
        return "[$time] ${entry.source}: ${entry.action.label} ${entry.details}"
    }
}

data class AuditEntry(
    val id: UUID,
    val timestamp: Long,
    val source: String,      // Package name or "LimeSSH"
    val action: AuditAction,
    val connectionId: UUID? = null,
    val details: String = "",
)

enum class AuditAction(val label: String) {
    SESSION_STARTED("Session started"),
    SESSION_ENDED("Session ended"),
    SESSION_AUTH_FAILED("Auth failed"),
    HOST_KEY_ACCEPTED("Host key accepted"),
    HOST_KEY_REJECTED("Host key rejected"),
    HOST_KEY_CHANGED("Host key changed"),
    COMMAND_EXECUTED("Command executed"),
    SNIPPET_RUN("Snippet run"),
    PORT_FORWARD_STARTED("Forward started"),
    PORT_FORWARD_STOPPED("Forward stopped"),
    KNOCK_SEQUENCE("Knock sent"),
    PLUGIN_CONNECTED("Plugin connected"),
    PLUGIN_DISCONNECTED("Plugin disconnected"),
    EXPORT_CREATED("Export created"),
    IMPORT_COMPLETED("Import completed"),
    LOCK_ACTIVATED("Lock activated"),
    LOCK_RELEASED("Lock released"),
}
