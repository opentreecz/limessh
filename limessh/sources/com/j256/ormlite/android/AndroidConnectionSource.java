package com.j256.ormlite.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.p001db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class AndroidConnectionSource extends BaseConnectionSource implements ConnectionSource {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) AndroidConnectionSource.class);
    private AndroidDatabaseConnection connection;
    private final DatabaseType databaseType;
    private final SQLiteOpenHelper helper;
    private volatile boolean isOpen;
    private final SQLiteDatabase sqliteDatabase;

    public AndroidConnectionSource(SQLiteDatabase sQLiteDatabase) {
        this.connection = null;
        this.isOpen = true;
        this.databaseType = new SqliteAndroidDatabaseType();
        this.helper = null;
        this.sqliteDatabase = sQLiteDatabase;
    }

    public AndroidConnectionSource(SQLiteOpenHelper sQLiteOpenHelper) {
        this.connection = null;
        this.isOpen = true;
        this.databaseType = new SqliteAndroidDatabaseType();
        this.helper = sQLiteOpenHelper;
        this.sqliteDatabase = null;
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public void clearSpecialConnection(DatabaseConnection databaseConnection) {
        clearSpecial(databaseConnection, logger);
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public void close() {
        this.isOpen = false;
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public void closeQuietly() {
        close();
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public DatabaseType getDatabaseType() {
        return this.databaseType;
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getReadOnlyConnection() throws SQLException {
        return getReadWriteConnection();
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getReadWriteConnection() throws SQLException {
        DatabaseConnection savedConnection = getSavedConnection();
        if (savedConnection != null) {
            return savedConnection;
        }
        AndroidDatabaseConnection androidDatabaseConnection = this.connection;
        if (androidDatabaseConnection == null) {
            SQLiteDatabase sQLiteDatabase = this.sqliteDatabase;
            if (sQLiteDatabase == null) {
                try {
                    sQLiteDatabase = this.helper.getWritableDatabase();
                } catch (android.database.SQLException e) {
                    throw SqlExceptionUtil.create("Getting a writable database from helper " + this.helper + " failed", e);
                }
            }
            AndroidDatabaseConnection androidDatabaseConnection2 = new AndroidDatabaseConnection(sQLiteDatabase, true);
            this.connection = androidDatabaseConnection2;
            logger.trace("created connection {} for db {}, helper {}", androidDatabaseConnection2, sQLiteDatabase, this.helper);
        } else {
            logger.trace("{}: returning read-write connection {}, helper {}", this, androidDatabaseConnection, this.helper);
        }
        return this.connection;
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public boolean isOpen() {
        return this.isOpen;
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public void releaseConnection(DatabaseConnection databaseConnection) {
    }

    @Override // com.j256.ormlite.support.BaseConnectionSource, com.j256.ormlite.support.ConnectionSource
    public boolean saveSpecialConnection(DatabaseConnection databaseConnection) throws SQLException {
        return saveSpecial(databaseConnection);
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }
}
