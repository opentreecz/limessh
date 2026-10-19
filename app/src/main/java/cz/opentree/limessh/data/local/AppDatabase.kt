package cz.opentree.limessh.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cz.opentree.limessh.data.local.dao.ConnectionDao
import cz.opentree.limessh.data.local.dao.GroupDao
import cz.opentree.limessh.data.local.dao.IdentityDao
import cz.opentree.limessh.data.local.dao.KnownHostDao
import cz.opentree.limessh.data.local.dao.PortForwardDao
import cz.opentree.limessh.data.local.dao.SnippetDao
import cz.opentree.limessh.data.local.entity.ConnectionEntity
import cz.opentree.limessh.data.local.entity.ConnectionGroupEntity
import cz.opentree.limessh.data.local.entity.IdentityEntity
import cz.opentree.limessh.data.local.entity.KnownHostEntity
import cz.opentree.limessh.data.local.entity.PortForwardEntity
import cz.opentree.limessh.data.local.entity.SnippetEntity

@Database(
    entities = [
        ConnectionEntity::class,
        IdentityEntity::class,
        ConnectionGroupEntity::class,
        SnippetEntity::class,
        PortForwardEntity::class,
        KnownHostEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun connectionDao(): ConnectionDao
    abstract fun identityDao(): IdentityDao
    abstract fun groupDao(): GroupDao
    abstract fun snippetDao(): SnippetDao
    abstract fun portForwardDao(): PortForwardDao
    abstract fun knownHostDao(): KnownHostDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "limessh.db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
