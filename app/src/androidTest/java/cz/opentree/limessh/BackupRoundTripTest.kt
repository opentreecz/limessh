package cz.opentree.limessh

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import cz.opentree.limessh.data.backup.BackupManager
import cz.opentree.limessh.data.local.AppDatabase
import cz.opentree.limessh.data.local.entity.ConnectionEntity
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class BackupRoundTripTest {
    @Test fun configurationRestoresAndWrongPasswordDoesNotModifyDatabase() = runBlocking {
        val db = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), AppDatabase::class.java).build()
        try {
            val connection = ConnectionEntity(id = UUID.randomUUID().toString(), nickname = "test", address = "example.test")
            db.connectionDao().upsert(connection)
            val bytes = ByteArrayOutputStream().also { BackupManager(db).export(it, "correct passphrase") }.toByteArray()
            db.clearAllTables()
            val rejected = BackupManager(db).import(ByteArrayInputStream(bytes), "wrong passphrase")
            assertFalse(rejected.success)
            assertNull(db.connectionDao().getById(connection.id))
            val restored = BackupManager(db).import(ByteArrayInputStream(bytes), "correct passphrase")
            assertTrue(restored.success)
            assertEquals(1, restored.connections)
            assertEquals(connection, db.connectionDao().getById(connection.id))
            val corrupted = bytes.copyOf().also { it[it.lastIndex] = (it.last().toInt() xor 1).toByte() }
            assertFalse(BackupManager(db).import(ByteArrayInputStream(corrupted), "correct passphrase").success)
            assertEquals(connection, db.connectionDao().getById(connection.id))
        } finally { db.close() }
    }
}
