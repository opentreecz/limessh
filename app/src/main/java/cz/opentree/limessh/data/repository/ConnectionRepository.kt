package cz.opentree.limessh.data.repository

import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.*
import cz.opentree.limessh.domain.model.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

class ConnectionRepository(private val db: AppDatabase) {

    // --- Connections ---
    fun observeConnections(): Flow<List<Connection>> =
        db.connectionDao().observeAll().map { list -> list.map { it.toDomain() } }

    suspend fun getConnection(id: UUID): Connection? =
        db.connectionDao().getById(id.toString())?.toDomain()

    suspend fun saveConnection(conn: Connection) {
        db.connectionDao().upsert(conn.toEntity())
    }

    suspend fun deleteConnection(conn: Connection) {
        db.connectionDao().delete(conn.toEntity())
    }

    // --- Identities ---
    fun observeIdentities(): Flow<List<Identity>> =
        db.identityDao().observeAll().map { list -> list.map { it.toDomain() } }

    suspend fun getIdentity(id: UUID): Identity? =
        db.identityDao().getById(id.toString())?.toDomain()

    suspend fun saveIdentity(identity: Identity) {
        db.identityDao().upsert(identity.toEntity())
    }

    suspend fun deleteIdentity(identity: Identity) {
        db.identityDao().delete(identity.toEntity())
    }

    // --- Groups ---
    fun observeGroups(): Flow<List<ConnectionGroup>> =
        db.groupDao().observeAll().map { list -> list.map { ConnectionGroup(UUID.fromString(it.id), it.name) } }

    suspend fun saveGroup(group: ConnectionGroup) {
        db.groupDao().upsert(ConnectionGroupEntity(group.id.toString(), group.name))
    }

    suspend fun deleteGroup(group: ConnectionGroup) {
        db.groupDao().delete(ConnectionGroupEntity(group.id.toString(), group.name))
    }

    // --- Snippets ---
    fun observeSnippets(): Flow<List<Snippet>> =
        db.snippetDao().observeAll().map { list -> list.map { it.toDomain() } }

    suspend fun getSnippet(id: UUID): Snippet? =
        db.snippetDao().getById(id.toString())?.toDomain()

    suspend fun saveSnippet(snippet: Snippet) {
        db.snippetDao().upsert(snippet.toEntity())
    }

    suspend fun deleteSnippet(snippet: Snippet) {
        db.snippetDao().delete(snippet.toEntity())
    }

    // --- Port Forwards ---
    fun observePortForwards(): Flow<List<PortForward>> =
        db.portForwardDao().observeAll().map { list -> list.map { it.toDomain() } }

    fun observePortForwardsForConnection(connectionId: UUID): Flow<List<PortForward>> =
        db.portForwardDao().observeByConnection(connectionId.toString())
            .map { list -> list.map { it.toDomain() } }

    suspend fun savePortForward(pf: PortForward) {
        db.portForwardDao().upsert(pf.toEntity())
    }

    suspend fun deletePortForward(pf: PortForward) {
        db.portForwardDao().delete(pf.toEntity())
    }

    // --- Known Hosts ---
    fun observeKnownHosts(): Flow<List<KnownHost>> =
        db.knownHostDao().observeAll().map { list ->
            list.map { KnownHost(it.hostname, it.port, it.keyType, it.publicKey) }
        }
}

// --- Mappers ---
private fun ConnectionEntity.toDomain() = Connection(
    id = UUID.fromString(id), name = name, address = address, port = port,
    nickname = nickname, type = ConnectionType.fromValue(type),
    identityId = identityId?.let { UUID.fromString(it) },
    groupId = groupId?.let { UUID.fromString(it) },
)

private fun Connection.toEntity() = ConnectionEntity(
    id = id.toString(), name = name, address = address, port = port,
    nickname = nickname, type = type.value,
    identityId = identityId?.toString(), groupId = groupId?.toString(),
)

private fun IdentityEntity.toDomain() = Identity(
    id = UUID.fromString(id), nickname = nickname, username = username,
    authMethod = AuthMethod.entries.getOrElse(authMethod) { AuthMethod.PASSWORD },
)

private fun Identity.toEntity() = IdentityEntity(
    id = id.toString(), nickname = nickname, username = username,
    authMethod = authMethod.ordinal,
)

private fun SnippetEntity.toDomain() = Snippet(
    id = UUID.fromString(id), name = name, content = content, runOnConnect = runOnConnect,
)

private fun Snippet.toEntity() = SnippetEntity(
    id = id.toString(), name = name, content = content, runOnConnect = runOnConnect,
)

private fun PortForwardEntity.toDomain() = PortForward(
    id = UUID.fromString(id), name = name, mode = ForwardMode.fromValue(mode),
    connectionId = connectionId?.let { UUID.fromString(it) },
    host = host, localPort = localPort, remotePort = remotePort, openInBrowser = openInBrowser,
)

private fun PortForward.toEntity() = PortForwardEntity(
    id = id.toString(), name = name, mode = mode.value,
    connectionId = connectionId?.toString(),
    host = host, localPort = localPort, remotePort = remotePort, openInBrowser = openInBrowser,
)
