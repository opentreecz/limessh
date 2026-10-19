package cz.opentree.limessh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import cz.opentree.limessh.data.local.entity.ConnectionEntity
import cz.opentree.limessh.data.local.entity.ConnectionGroupEntity
import cz.opentree.limessh.data.local.entity.IdentityEntity
import cz.opentree.limessh.data.local.entity.KnownHostEntity
import cz.opentree.limessh.data.local.entity.PortForwardEntity
import cz.opentree.limessh.data.local.entity.SnippetEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ConnectionDao {
    @Query("SELECT * FROM connections ORDER BY nickname COLLATE NOCASE ASC")
    fun observeAll(): Flow<List<ConnectionEntity>>

    @Query("SELECT * FROM connections WHERE id = :id")
    suspend fun getById(id: String): ConnectionEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(connection: ConnectionEntity)

    @Delete
    suspend fun delete(connection: ConnectionEntity)
}

@Dao
interface IdentityDao {
    @Query("SELECT * FROM identities ORDER BY nickname COLLATE NOCASE ASC")
    fun observeAll(): Flow<List<IdentityEntity>>

    @Query("SELECT * FROM identities WHERE id = :id")
    suspend fun getById(id: String): IdentityEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(identity: IdentityEntity)

    @Delete
    suspend fun delete(identity: IdentityEntity)
}

@Dao
interface GroupDao {
    @Query("SELECT * FROM connection_groups ORDER BY name COLLATE NOCASE ASC")
    fun observeAll(): Flow<List<ConnectionGroupEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(group: ConnectionGroupEntity)

    @Delete
    suspend fun delete(group: ConnectionGroupEntity)
}

@Dao
interface SnippetDao {
    @Query("SELECT * FROM snippets ORDER BY name COLLATE NOCASE ASC")
    fun observeAll(): Flow<List<SnippetEntity>>

    @Query("SELECT * FROM snippets WHERE id = :id")
    suspend fun getById(id: String): SnippetEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(snippet: SnippetEntity)

    @Delete
    suspend fun delete(snippet: SnippetEntity)
}

@Dao
interface PortForwardDao {
    @Query("SELECT * FROM port_forwards ORDER BY name ASC")
    fun observeAll(): Flow<List<PortForwardEntity>>

    @Query("SELECT * FROM port_forwards WHERE connectionId = :connectionId")
    fun observeByConnection(connectionId: String): Flow<List<PortForwardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(forward: PortForwardEntity)

    @Delete
    suspend fun delete(forward: PortForwardEntity)
}

@Dao
interface KnownHostDao {
    @Query("SELECT * FROM known_hosts WHERE hostname = :hostname AND port = :port")
    suspend fun findByHostAndPort(hostname: String, port: Int): List<KnownHostEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(host: KnownHostEntity)

    @Query("DELETE FROM known_hosts WHERE hostname = :hostname AND port = :port")
    suspend fun deleteByHostAndPort(hostname: String, port: Int)

    @Query("SELECT * FROM known_hosts ORDER BY hostname ASC")
    fun observeAll(): Flow<List<KnownHostEntity>>
}
