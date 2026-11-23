package com.j256.ormlite.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.misc.VersionUtils;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import java.sql.SQLException;
import java.sql.Savepoint;

/* loaded from: classes.dex */
public class AndroidDatabaseConnection implements DatabaseConnection {
    private static final String ANDROID_VERSION = "VERSION__4.45-SNAPSHOT__";

    /* renamed from: db */
    private final SQLiteDatabase f1283db;
    private final boolean readWrite;
    private static Logger logger = LoggerFactory.getLogger((Class<?>) AndroidDatabaseConnection.class);
    private static final String[] NO_STRING_ARGS = new String[0];

    /* renamed from: com.j256.ormlite.android.AndroidDatabaseConnection$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C06691 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.STRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.CHAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BOOLEAN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SHORT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.INTEGER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.LONG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DOUBLE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BYTE_ARRAY.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.SERIALIZABLE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.DATE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BLOB.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.BIG_DECIMAL.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$j256$ormlite$field$SqlType[SqlType.UNKNOWN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class OurSavePoint implements Savepoint {
        private String name;

        public OurSavePoint(String str) {
            this.name = str;
        }

        @Override // java.sql.Savepoint
        public int getSavepointId() {
            return 0;
        }

        @Override // java.sql.Savepoint
        public String getSavepointName() {
            return this.name;
        }
    }

    static {
        VersionUtils.checkCoreVersusAndroidVersions(ANDROID_VERSION);
    }

    public AndroidDatabaseConnection(SQLiteDatabase sQLiteDatabase, boolean z) {
        this.f1283db = sQLiteDatabase;
        this.readWrite = z;
        logger.trace("{}: db {} opened, read-write = {}", this, sQLiteDatabase, Boolean.valueOf(z));
    }

    private void bindArgs(SQLiteStatement sQLiteStatement, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        if (objArr == null) {
            return;
        }
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                sQLiteStatement.bindNull(i + 1);
            } else {
                SqlType sqlType = fieldTypeArr[i].getSqlType();
                switch (C06691.$SwitchMap$com$j256$ormlite$field$SqlType[sqlType.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                        sQLiteStatement.bindString(i + 1, obj.toString());
                        break;
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                        sQLiteStatement.bindLong(i + 1, ((Number) obj).longValue());
                        break;
                    case 9:
                    case 10:
                        sQLiteStatement.bindDouble(i + 1, ((Number) obj).doubleValue());
                        break;
                    case 11:
                    case 12:
                        sQLiteStatement.bindBlob(i + 1, (byte[]) obj);
                        break;
                    case 13:
                    case 14:
                    case 15:
                        throw new SQLException("Invalid Android type: " + sqlType);
                    default:
                        throw new SQLException("Unknown sql argument type: " + sqlType);
                }
            }
        }
    }

    private String[] toStrings(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj == null) {
                strArr[i] = null;
            } else {
                strArr[i] = obj.toString();
            }
        }
        return strArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
    
        if (r0 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
    
        com.j256.ormlite.android.AndroidDatabaseConnection.logger.trace("{} statement is compiled and executed, changed {}: {}", r6, java.lang.Integer.valueOf(r4), r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
    
        if (r0 == null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int update(java.lang.String r3, java.lang.Object[] r4, com.j256.ormlite.field.FieldType[] r5, java.lang.String r6) throws java.sql.SQLException {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.f1283db     // Catch: java.lang.Throwable -> L44 android.database.SQLException -> L46
            android.database.sqlite.SQLiteStatement r1 = r1.compileStatement(r3)     // Catch: java.lang.Throwable -> L44 android.database.SQLException -> L46
            r2.bindArgs(r1, r4, r5)     // Catch: java.lang.Throwable -> L3e android.database.SQLException -> L41
            r1.execute()     // Catch: java.lang.Throwable -> L3e android.database.SQLException -> L41
            if (r1 == 0) goto L13
            r1.close()
            goto L14
        L13:
            r0 = r1
        L14:
            android.database.sqlite.SQLiteDatabase r4 = r2.f1283db     // Catch: java.lang.Throwable -> L27 android.database.SQLException -> L2e
            java.lang.String r5 = "SELECT CHANGES()"
            android.database.sqlite.SQLiteStatement r0 = r4.compileStatement(r5)     // Catch: java.lang.Throwable -> L27 android.database.SQLException -> L2e
            long r4 = r0.simpleQueryForLong()     // Catch: java.lang.Throwable -> L27 android.database.SQLException -> L2e
            int r4 = (int) r4
            if (r0 == 0) goto L32
        L23:
            r0.close()
            goto L32
        L27:
            r3 = move-exception
            if (r0 == 0) goto L2d
            r0.close()
        L2d:
            throw r3
        L2e:
            r4 = 1
            if (r0 == 0) goto L32
            goto L23
        L32:
            com.j256.ormlite.logger.Logger r5 = com.j256.ormlite.android.AndroidDatabaseConnection.logger
            java.lang.Integer r0 = java.lang.Integer.valueOf(r4)
            java.lang.String r1 = "{} statement is compiled and executed, changed {}: {}"
            r5.trace(r1, r6, r0, r3)
            return r4
        L3e:
            r3 = move-exception
            r0 = r1
            goto L5d
        L41:
            r4 = move-exception
            r0 = r1
            goto L47
        L44:
            r3 = move-exception
            goto L5d
        L46:
            r4 = move-exception
        L47:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L44
            r5.<init>()     // Catch: java.lang.Throwable -> L44
            java.lang.String r6 = "updating database failed: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L44
            r5.append(r3)     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L44
            java.sql.SQLException r3 = com.j256.ormlite.misc.SqlExceptionUtil.create(r3, r4)     // Catch: java.lang.Throwable -> L44
            throw r3     // Catch: java.lang.Throwable -> L44
        L5d:
            if (r0 == 0) goto L62
            r0.close()
        L62:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.update(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], java.lang.String):int");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void close() throws SQLException {
        try {
            this.f1283db.close();
            logger.trace("{}: db {} closed", this, this.f1283db);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems closing the database connection", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void closeQuietly() {
        try {
            close();
        } catch (SQLException unused) {
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void commit(Savepoint savepoint) throws SQLException {
        try {
            this.f1283db.setTransactionSuccessful();
            this.f1283db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is successfuly ended", this);
            } else {
                logger.trace("{}: transaction {} is successfuly ended", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems commiting transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr) {
        AndroidCompiledStatement androidCompiledStatement = new AndroidCompiledStatement(str, this.f1283db, statementType);
        logger.trace("{}: compiled statement got {}: {}", this, androidCompiledStatement, str);
        return androidCompiledStatement;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public CompiledStatement compileStatement(String str, StatementBuilder.StatementType statementType, FieldType[] fieldTypeArr, int i) {
        return compileStatement(str, statementType, fieldTypeArr);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int delete(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "deleted");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int executeStatement(String str, int i) throws SQLException {
        return AndroidCompiledStatement.execSql(this.f1283db, str, str, NO_STRING_ARGS);
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int insert(String str, Object[] objArr, FieldType[] fieldTypeArr, GeneratedKeyHolder generatedKeyHolder) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.f1283db.compileStatement(str);
                bindArgs(sQLiteStatement, objArr, fieldTypeArr);
                long executeInsert = sQLiteStatement.executeInsert();
                if (generatedKeyHolder != null) {
                    generatedKeyHolder.addKey(Long.valueOf(executeInsert));
                }
                logger.trace("{}: insert statement is compiled and executed, changed {}: {}", (Object) this, (Object) 1, (Object) str);
                return 1;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("inserting to database failed: " + str, e);
            }
        } finally {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommit() throws SQLException {
        try {
            boolean inTransaction = this.f1283db.inTransaction();
            logger.trace("{}: in transaction is {}", this, Boolean.valueOf(inTransaction));
            return !inTransaction;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems getting auto-commit from database", e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isAutoCommitSupported() {
        return true;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isClosed() throws SQLException {
        try {
            boolean isOpen = this.f1283db.isOpen();
            logger.trace("{}: db {} isOpen returned {}", this, this.f1283db, Boolean.valueOf(isOpen));
            return !isOpen;
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems detecting if the database is closed", e);
        }
    }

    public boolean isReadWrite() {
        return this.readWrite;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public boolean isTableExists(String str) {
        boolean z;
        Cursor rawQuery = this.f1283db.rawQuery("SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name = '" + str + "'", null);
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    z = true;
                    logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
                    rawQuery.close();
                    return z;
                }
            } catch (Throwable th) {
                rawQuery.close();
                throw th;
            }
        }
        z = false;
        logger.trace("{}: isTableExists '{}' returned {}", this, str, Boolean.valueOf(z));
        rawQuery.close();
        return z;
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public long queryForLong(String str) throws SQLException {
        SQLiteStatement sQLiteStatement = null;
        try {
            try {
                sQLiteStatement = this.f1283db.compileStatement(str);
                long simpleQueryForLong = sQLiteStatement.simpleQueryForLong();
                logger.trace("{}: query for long simple query returned {}: {}", this, Long.valueOf(simpleQueryForLong), str);
                return simpleQueryForLong;
            } catch (android.database.SQLException e) {
                throw SqlExceptionUtil.create("queryForLong from database failed: " + str, e);
            }
        } finally {
            if (sQLiteStatement != null) {
                sQLiteStatement.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    @Override // com.j256.ormlite.support.DatabaseConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long queryForLong(java.lang.String r6, java.lang.Object[] r7, com.j256.ormlite.field.FieldType[] r8) throws java.sql.SQLException {
        /*
            r5 = this;
            r8 = 0
            android.database.sqlite.SQLiteDatabase r0 = r5.f1283db     // Catch: java.lang.Throwable -> L31 android.database.SQLException -> L33
            java.lang.String[] r7 = r5.toStrings(r7)     // Catch: java.lang.Throwable -> L31 android.database.SQLException -> L33
            android.database.Cursor r7 = r0.rawQuery(r6, r7)     // Catch: java.lang.Throwable -> L31 android.database.SQLException -> L33
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            r0.<init>(r7, r8)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            boolean r8 = r0.first()     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            if (r8 == 0) goto L1c
            r8 = 0
            long r0 = r0.getLong(r8)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            goto L1e
        L1c:
            r0 = 0
        L1e:
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.android.AndroidDatabaseConnection.logger     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            java.lang.String r2 = "{}: query for long raw query returned {}: {}"
            java.lang.Long r3 = java.lang.Long.valueOf(r0)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            r8.trace(r2, r5, r3, r6)     // Catch: android.database.SQLException -> L2f java.lang.Throwable -> L4d
            if (r7 == 0) goto L2e
            r7.close()
        L2e:
            return r0
        L2f:
            r8 = move-exception
            goto L37
        L31:
            r6 = move-exception
            goto L4f
        L33:
            r7 = move-exception
            r4 = r8
            r8 = r7
            r7 = r4
        L37:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4d
            r0.<init>()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r1 = "queryForLong from database failed: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L4d
            r0.append(r6)     // Catch: java.lang.Throwable -> L4d
            java.lang.String r6 = r0.toString()     // Catch: java.lang.Throwable -> L4d
            java.sql.SQLException r6 = com.j256.ormlite.misc.SqlExceptionUtil.create(r6, r8)     // Catch: java.lang.Throwable -> L4d
            throw r6     // Catch: java.lang.Throwable -> L4d
        L4d:
            r6 = move-exception
            r8 = r7
        L4f:
            if (r8 == 0) goto L54
            r8.close()
        L54:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForLong(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[]):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005d  */
    @Override // com.j256.ormlite.support.DatabaseConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <T> java.lang.Object queryForOne(java.lang.String r4, java.lang.Object[] r5, com.j256.ormlite.field.FieldType[] r6, com.j256.ormlite.stmt.GenericRowMapper<T> r7, com.j256.ormlite.dao.ObjectCache r8) throws java.sql.SQLException {
        /*
            r3 = this;
            r6 = 0
            android.database.sqlite.SQLiteDatabase r0 = r3.f1283db     // Catch: java.lang.Throwable -> L3d android.database.SQLException -> L3f
            java.lang.String[] r5 = r3.toStrings(r5)     // Catch: java.lang.Throwable -> L3d android.database.SQLException -> L3f
            android.database.Cursor r5 = r0.rawQuery(r4, r5)     // Catch: java.lang.Throwable -> L3d android.database.SQLException -> L3f
            com.j256.ormlite.android.AndroidDatabaseResults r0 = new com.j256.ormlite.android.AndroidDatabaseResults     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            r0.<init>(r5, r8)     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            com.j256.ormlite.logger.Logger r8 = com.j256.ormlite.android.AndroidDatabaseConnection.logger     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            java.lang.String r1 = "{}: queried for one result: {}"
            r8.trace(r1, r3, r4)     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            boolean r8 = r0.first()     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            if (r8 != 0) goto L23
            if (r5 == 0) goto L22
            r5.close()
        L22:
            return r6
        L23:
            java.lang.Object r6 = r7.mapRow(r0)     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            boolean r7 = r0.next()     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            if (r7 == 0) goto L35
            java.lang.Object r4 = com.j256.ormlite.support.DatabaseConnection.MORE_THAN_ONE     // Catch: android.database.SQLException -> L3b java.lang.Throwable -> L59
            if (r5 == 0) goto L34
            r5.close()
        L34:
            return r4
        L35:
            if (r5 == 0) goto L3a
            r5.close()
        L3a:
            return r6
        L3b:
            r6 = move-exception
            goto L43
        L3d:
            r4 = move-exception
            goto L5b
        L3f:
            r5 = move-exception
            r2 = r6
            r6 = r5
            r5 = r2
        L43:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L59
            r7.<init>()     // Catch: java.lang.Throwable -> L59
            java.lang.String r8 = "queryForOne from database failed: "
            r7.append(r8)     // Catch: java.lang.Throwable -> L59
            r7.append(r4)     // Catch: java.lang.Throwable -> L59
            java.lang.String r4 = r7.toString()     // Catch: java.lang.Throwable -> L59
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r4, r6)     // Catch: java.lang.Throwable -> L59
            throw r4     // Catch: java.lang.Throwable -> L59
        L59:
            r4 = move-exception
            r6 = r5
        L5b:
            if (r6 == 0) goto L60
            r6.close()
        L60:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.android.AndroidDatabaseConnection.queryForOne(java.lang.String, java.lang.Object[], com.j256.ormlite.field.FieldType[], com.j256.ormlite.stmt.GenericRowMapper, com.j256.ormlite.dao.ObjectCache):java.lang.Object");
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void rollback(Savepoint savepoint) throws SQLException {
        try {
            this.f1283db.endTransaction();
            if (savepoint == null) {
                logger.trace("{}: transaction is ended, unsuccessfuly", this);
            } else {
                logger.trace("{}: transaction {} is ended, unsuccessfuly", this, savepoint.getSavepointName());
            }
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems rolling back transaction " + savepoint.getSavepointName(), e);
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public void setAutoCommit(boolean z) {
        if (!z) {
            if (this.f1283db.inTransaction()) {
                return;
            }
            this.f1283db.beginTransaction();
        } else if (this.f1283db.inTransaction()) {
            this.f1283db.setTransactionSuccessful();
            this.f1283db.endTransaction();
        }
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public Savepoint setSavePoint(String str) throws SQLException {
        try {
            this.f1283db.beginTransaction();
            logger.trace("{}: save-point set with name {}", this, str);
            return new OurSavePoint(str);
        } catch (android.database.SQLException e) {
            throw SqlExceptionUtil.create("problems beginning transaction " + str, e);
        }
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(super.hashCode());
    }

    @Override // com.j256.ormlite.support.DatabaseConnection
    public int update(String str, Object[] objArr, FieldType[] fieldTypeArr) throws SQLException {
        return update(str, objArr, fieldTypeArr, "updated");
    }
}
