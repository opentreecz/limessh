package cz.opentree.limessh.data.backup

import cz.opentree.limessh.domain.model.Connection
import cz.opentree.limessh.domain.model.ConnectionType
import cz.opentree.limessh.domain.model.Identity

/** Portable connection metadata only. Private keys and passwords never leave the app. */
object OpenSshExporter {
    fun export(connections: List<Connection>, identities: List<Identity>): String = buildString {
        appendLine("# Exported by limessh. Credentials and forwards are not included.")
        connections.filter { it.type == ConnectionType.SSH }.forEach { connection ->
            val alias = connection.nickname.replace(Regex("[^A-Za-z0-9_.-]"), "-").trim('-').ifBlank { "server" }
            appendLine("\nHost $alias-${connection.id.toString().take(8)}")
            appendLine("    HostName ${quote(connection.address)}")
            require(connection.port in 1..65535)
            appendLine("    Port ${connection.port}")
            identities.firstOrNull { it.id == connection.identityId }?.let { identity ->
                appendLine("    User ${quote(identity.username)}")
            }
        }
    }

    private fun quote(value: String): String {
        require(value.none { it == '\n' || it == '\r' || it == '\u0000' }) { "Invalid OpenSSH field" }
        return "\"" + value.replace("\\", "\\\\").replace("\"", "\\\"") + "\""
    }
}
