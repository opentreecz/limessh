package cz.opentree.limessh.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "connections")
data class ConnectionEntity(
    @PrimaryKey val id: String,
    val name: String = "",
    val address: String = "",
    val port: Int = 22,
    val nickname: String = "",
    val type: Int = 0,
    val identityId: String? = null,
    val groupId: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val modifiedAt: Long = System.currentTimeMillis(),
)

@Entity(tableName = "identities")
data class IdentityEntity(
    @PrimaryKey val id: String,
    val nickname: String = "",
    val username: String = "",
    val authMethod: Int = 0,
    val createdAt: Long = System.currentTimeMillis(),
    val modifiedAt: Long = System.currentTimeMillis(),
    val credentialRef: String? = null,
)

@Entity(tableName = "connection_groups")
data class ConnectionGroupEntity(
    @PrimaryKey val id: String,
    val name: String = "",
    val modifiedAt: Long = System.currentTimeMillis(),
)

@Entity(tableName = "snippets")
data class SnippetEntity(
    @PrimaryKey val id: String,
    val name: String = "",
    val content: String = "",
    val runOnConnect: Boolean = false,
    val modifiedAt: Long = System.currentTimeMillis(),
)

@Entity(tableName = "port_forwards")
data class PortForwardEntity(
    @PrimaryKey val id: String,
    val name: String = "",
    val mode: Int = 0,
    val connectionId: String? = null,
    val host: String = "localhost",
    val localPort: Int = 0,
    val remotePort: Int = 0,
    val openInBrowser: Boolean = false,
    val modifiedAt: Long = System.currentTimeMillis(),
)

@Entity(tableName = "known_hosts")
data class KnownHostEntity(
    @PrimaryKey(autoGenerate = true) val rowId: Long = 0,
    val hostname: String,
    val port: Int = 22,
    val keyType: String,
    val publicKey: String,
    val addedAt: Long = System.currentTimeMillis(),
)
