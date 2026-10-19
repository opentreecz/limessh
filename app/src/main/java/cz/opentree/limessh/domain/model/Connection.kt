package cz.opentree.limessh.domain.model

import java.util.UUID

/**
 * Domain model for an SSH connection target.
 * Mirrors the data contract from the original JuiceSSH plugin SDK
 * (connections, groups, port forwards, snippets) but as independent Kotlin types.
 */
data class Connection(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val address: String = "",
    val port: Int = 22,
    val nickname: String = "",
    val type: ConnectionType = ConnectionType.SSH,
    val identityId: UUID? = null,
    val groupId: UUID? = null,
)

enum class ConnectionType(val value: Int) {
    SSH(0),
    MOSH(1),
    LOCAL(2),
    TELNET(3);

    companion object {
        fun fromValue(v: Int) = entries.firstOrNull { it.value == v } ?: SSH
    }
}

data class Identity(
    val id: UUID = UUID.randomUUID(),
    val nickname: String = "",
    val username: String = "",
    val authMethod: AuthMethod = AuthMethod.PASSWORD,
)

enum class AuthMethod {
    PASSWORD,
    PUBLIC_KEY,
    KEYBOARD_INTERACTIVE,
}

data class ConnectionGroup(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
)

data class PortForward(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val mode: ForwardMode = ForwardMode.LOCAL,
    val connectionId: UUID? = null,
    val host: String = "localhost",
    val localPort: Int = 0,
    val remotePort: Int = 0,
    val openInBrowser: Boolean = false,
)

enum class ForwardMode(val value: Int) {
    LOCAL(0),
    REMOTE(1),
    SOCKS(2);

    companion object {
        fun fromValue(v: Int) = entries.firstOrNull { it.value == v } ?: LOCAL
    }
}

data class Snippet(
    val id: UUID = UUID.randomUUID(),
    val name: String = "",
    val content: String = "",
    val runOnConnect: Boolean = false,
)

data class KnownHost(
    val hostname: String,
    val port: Int = 22,
    val keyType: String,
    val publicKey: String,
)
