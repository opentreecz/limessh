package com.j256.ormlite.misc;

import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class TransactionManager {
    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TransactionManager.class);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager() {
    }

    public TransactionManager(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
        initialize();
    }

    public static <T> T callInTransaction(ConnectionSource connectionSource, Callable<T> callable) throws SQLException {
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return (T) callInTransaction(readWriteConnection, connectionSource.saveSpecialConnection(readWriteConnection), connectionSource.getDatabaseType(), callable);
        } finally {
            connectionSource.clearSpecialConnection(readWriteConnection);
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> T callInTransaction(DatabaseConnection databaseConnection, DatabaseType databaseType, Callable<T> callable) throws SQLException {
        return (T) callInTransaction(databaseConnection, false, databaseType, callable);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f A[Catch: all -> 0x006d, Exception -> 0x0071, SQLException -> 0x007e, TRY_LEAVE, TryCatch #4 {SQLException -> 0x007e, Exception -> 0x0071, blocks: (B:21:0x0059, B:23:0x005f), top: B:20:0x0059, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> T callInTransaction(com.j256.ormlite.support.DatabaseConnection r5, boolean r6, com.j256.ormlite.p001db.DatabaseType r7, java.util.concurrent.Callable<T> r8) throws java.sql.SQLException {
        /*
            r0 = 0
            java.lang.String r1 = "restored auto-commit to true"
            r2 = 1
            r3 = 0
            if (r6 != 0) goto L10
            boolean r6 = r7.isNestedSavePointsSupported()     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto Le
            goto L10
        Le:
            r6 = r3
            goto L59
        L10:
            boolean r6 = r5.isAutoCommitSupported()     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto L27
            boolean r6 = r5.isAutoCommit()     // Catch: java.lang.Throwable -> L85
            if (r6 == 0) goto L26
            r5.setAutoCommit(r3)     // Catch: java.lang.Throwable -> L6d
            com.j256.ormlite.logger.Logger r7 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L6d
            java.lang.String r0 = "had to set auto-commit to false"
            r7.debug(r0)     // Catch: java.lang.Throwable -> L6d
        L26:
            r3 = r6
        L27:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r6.<init>()     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = "ORMLITE"
            r6.append(r7)     // Catch: java.lang.Throwable -> L85
            java.util.concurrent.atomic.AtomicInteger r7 = com.j256.ormlite.misc.TransactionManager.savePointCounter     // Catch: java.lang.Throwable -> L85
            int r7 = r7.incrementAndGet()     // Catch: java.lang.Throwable -> L85
            r6.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L85
            java.sql.Savepoint r0 = r5.setSavePoint(r6)     // Catch: java.lang.Throwable -> L85
            if (r0 != 0) goto L4c
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = "started savePoint transaction"
            r6.debug(r7)     // Catch: java.lang.Throwable -> L85
            goto L57
        L4c:
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.misc.TransactionManager.logger     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = "started savePoint transaction {}"
            java.lang.String r4 = r0.getSavepointName()     // Catch: java.lang.Throwable -> L85
            r6.debug(r7, r4)     // Catch: java.lang.Throwable -> L85
        L57:
            r6 = r3
            r3 = r2
        L59:
            java.lang.Object r7 = r8.call()     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71 java.sql.SQLException -> L7e
            if (r3 == 0) goto L62
            commit(r5, r0)     // Catch: java.lang.Throwable -> L6d java.lang.Exception -> L71 java.sql.SQLException -> L7e
        L62:
            if (r6 == 0) goto L6c
            r5.setAutoCommit(r2)
            com.j256.ormlite.logger.Logger r5 = com.j256.ormlite.misc.TransactionManager.logger
            r5.debug(r1)
        L6c:
            return r7
        L6d:
            r7 = move-exception
            r3 = r6
            r6 = r7
            goto L86
        L71:
            r7 = move-exception
            if (r3 == 0) goto L77
            rollBack(r5, r0)     // Catch: java.lang.Throwable -> L6d
        L77:
            java.lang.String r8 = "Transaction callable threw non-SQL exception"
            java.sql.SQLException r7 = com.j256.ormlite.misc.SqlExceptionUtil.create(r8, r7)     // Catch: java.lang.Throwable -> L6d
            throw r7     // Catch: java.lang.Throwable -> L6d
        L7e:
            r7 = move-exception
            if (r3 == 0) goto L84
            rollBack(r5, r0)     // Catch: java.lang.Throwable -> L6d
        L84:
            throw r7     // Catch: java.lang.Throwable -> L6d
        L85:
            r6 = move-exception
        L86:
            if (r3 == 0) goto L90
            r5.setAutoCommit(r2)
            com.j256.ormlite.logger.Logger r5 = com.j256.ormlite.misc.TransactionManager.logger
            r5.debug(r1)
        L90:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.misc.TransactionManager.callInTransaction(com.j256.ormlite.support.DatabaseConnection, boolean, com.j256.ormlite.db.DatabaseType, java.util.concurrent.Callable):java.lang.Object");
    }

    private static void commit(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.commit(savepoint);
        if (savepointName == null) {
            logger.debug("committed savePoint transaction");
        } else {
            logger.debug("committed savePoint transaction {}", savepointName);
        }
    }

    private static void rollBack(DatabaseConnection databaseConnection, Savepoint savepoint) throws SQLException {
        String savepointName = savepoint == null ? null : savepoint.getSavepointName();
        databaseConnection.rollback(savepoint);
        if (savepointName == null) {
            logger.debug("rolled back savePoint transaction");
        } else {
            logger.debug("rolled back savePoint transaction {}", savepointName);
        }
    }

    public <T> T callInTransaction(Callable<T> callable) throws SQLException {
        return (T) callInTransaction(this.connectionSource, callable);
    }

    public void initialize() {
        if (this.connectionSource != null) {
            return;
        }
        throw new IllegalStateException("dataSource was not set on " + getClass().getSimpleName());
    }

    public void setConnectionSource(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }
}
