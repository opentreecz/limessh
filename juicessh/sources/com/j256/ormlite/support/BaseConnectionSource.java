package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.p001db.DatabaseType;
import java.sql.SQLException;

/* loaded from: classes.dex */
public abstract class BaseConnectionSource implements ConnectionSource {
    private ThreadLocal<NestedConnection> specialConnection = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public static class NestedConnection {
        public final DatabaseConnection connection;
        private int nestedC = 1;

        public NestedConnection(DatabaseConnection databaseConnection) {
            this.connection = databaseConnection;
        }

        public int decrementAndGet() {
            int i = this.nestedC - 1;
            this.nestedC = i;
            return i;
        }

        public void increment() {
            this.nestedC++;
        }
    }

    public boolean clearSpecial(DatabaseConnection databaseConnection, Logger logger) {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (databaseConnection != null) {
            if (nestedConnection == null) {
                logger.error("no connection has been saved when clear() called");
            } else {
                DatabaseConnection databaseConnection2 = nestedConnection.connection;
                if (databaseConnection2 == databaseConnection) {
                    if (nestedConnection.decrementAndGet() == 0) {
                        this.specialConnection.set(null);
                    }
                    return true;
                }
                logger.error("connection saved {} is not the one being cleared {}", databaseConnection2, databaseConnection);
            }
        }
        return false;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void clearSpecialConnection(DatabaseConnection databaseConnection);

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void close() throws SQLException;

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void closeQuietly();

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ DatabaseType getDatabaseType();

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ DatabaseConnection getReadOnlyConnection() throws SQLException;

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ DatabaseConnection getReadWriteConnection() throws SQLException;

    public DatabaseConnection getSavedConnection() {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public DatabaseConnection getSpecialConnection() {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            return null;
        }
        return nestedConnection.connection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ boolean isOpen();

    public boolean isSavedConnection(DatabaseConnection databaseConnection) {
        NestedConnection nestedConnection = this.specialConnection.get();
        return nestedConnection != null && nestedConnection.connection == databaseConnection;
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ void releaseConnection(DatabaseConnection databaseConnection) throws SQLException;

    public boolean saveSpecial(DatabaseConnection databaseConnection) throws SQLException {
        NestedConnection nestedConnection = this.specialConnection.get();
        if (nestedConnection == null) {
            this.specialConnection.set(new NestedConnection(databaseConnection));
            return true;
        }
        if (nestedConnection.connection == databaseConnection) {
            nestedConnection.increment();
            return false;
        }
        throw new SQLException("trying to save connection " + databaseConnection + " but already have saved connection " + nestedConnection.connection);
    }

    @Override // com.j256.ormlite.support.ConnectionSource
    public abstract /* synthetic */ boolean saveSpecialConnection(DatabaseConnection databaseConnection) throws SQLException;
}
