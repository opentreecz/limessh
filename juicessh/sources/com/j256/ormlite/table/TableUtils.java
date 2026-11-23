package com.j256.ormlite.table;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class TableUtils {
    private static Logger logger = LoggerFactory.getLogger((Class<?>) TableUtils.class);
    private static final FieldType[] noFieldTypes = new FieldType[0];

    private TableUtils() {
    }

    private static <T, ID> void addCreateIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, boolean z, boolean z2) {
        HashMap hashMap = new HashMap();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String uniqueIndexName = z2 ? fieldType.getUniqueIndexName() : fieldType.getIndexName();
            if (uniqueIndexName != null) {
                List list2 = (List) hashMap.get(uniqueIndexName);
                if (list2 == null) {
                    list2 = new ArrayList();
                    hashMap.put(uniqueIndexName, list2);
                }
                list2.add(fieldType.getColumnName());
            }
        }
        StringBuilder sb = new StringBuilder(128);
        for (Map.Entry entry : hashMap.entrySet()) {
            logger.info("creating index '{}' for table '{}", entry.getKey(), tableInfo.getTableName());
            sb.append("CREATE ");
            if (z2) {
                sb.append("UNIQUE ");
            }
            sb.append("INDEX ");
            if (z && databaseType.isCreateIndexIfNotExistsSupported()) {
                sb.append("IF NOT EXISTS ");
            }
            databaseType.appendEscapedEntityName(sb, (String) entry.getKey());
            sb.append(" ON ");
            databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
            sb.append(" ( ");
            boolean z3 = true;
            for (String str : (List) entry.getValue()) {
                if (z3) {
                    z3 = false;
                } else {
                    sb.append(", ");
                }
                databaseType.appendEscapedEntityName(sb, str);
            }
            sb.append(" )");
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> List<String> addCreateTableStatements(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        ArrayList arrayList = new ArrayList();
        addCreateTableStatements(connectionSource.getDatabaseType(), tableInfo, arrayList, new ArrayList(), z);
        return arrayList;
    }

    private static <T, ID> void addCreateTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list, List<String> list2, boolean z) throws SQLException {
        boolean z2;
        int i;
        boolean z3;
        int i2;
        FieldType[] fieldTypeArr;
        StringBuilder sb = new StringBuilder(256);
        sb.append("CREATE TABLE ");
        if (z && databaseType.isCreateIfNotExistsSupported()) {
            sb.append("IF NOT EXISTS ");
        }
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(" (");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        FieldType[] fieldTypes = tableInfo.getFieldTypes();
        int length = fieldTypes.length;
        boolean z4 = false;
        boolean z5 = true;
        int i3 = 0;
        while (i3 < length) {
            FieldType fieldType = fieldTypes[i3];
            if (fieldType.isForeignCollection()) {
                i = i3;
                z3 = z4;
                i2 = length;
                fieldTypeArr = fieldTypes;
            } else {
                if (z5) {
                    z2 = z4;
                } else {
                    sb.append(", ");
                    z2 = z5;
                }
                String columnDefinition = fieldType.getColumnDefinition();
                if (columnDefinition == null) {
                    i = i3;
                    z3 = z4;
                    i2 = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendColumnArg(tableInfo.getTableName(), sb, fieldType, arrayList, arrayList2, arrayList3, list2);
                } else {
                    i = i3;
                    z3 = z4;
                    i2 = length;
                    fieldTypeArr = fieldTypes;
                    databaseType.appendEscapedEntityName(sb, fieldType.getColumnName());
                    sb.append(' ');
                    sb.append(columnDefinition);
                    sb.append(' ');
                }
                z5 = z2;
            }
            i3 = i + 1;
            z4 = z3;
            length = i2;
            fieldTypes = fieldTypeArr;
        }
        boolean z6 = z4;
        databaseType.addPrimaryKeySql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        databaseType.addUniqueComboSql(tableInfo.getFieldTypes(), arrayList, arrayList2, arrayList3, list2);
        for (String str : arrayList) {
            sb.append(", ");
            sb.append(str);
        }
        sb.append(") ");
        databaseType.appendCreateTableSuffix(sb);
        list.addAll(arrayList2);
        list.add(sb.toString());
        list.addAll(arrayList3);
        addCreateIndexStatements(databaseType, tableInfo, list, z, z6);
        addCreateIndexStatements(databaseType, tableInfo, list, z, true);
    }

    private static <T, ID> void addDropIndexStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        HashSet<String> hashSet = new HashSet();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            String indexName = fieldType.getIndexName();
            if (indexName != null) {
                hashSet.add(indexName);
            }
            String uniqueIndexName = fieldType.getUniqueIndexName();
            if (uniqueIndexName != null) {
                hashSet.add(uniqueIndexName);
            }
        }
        StringBuilder sb = new StringBuilder(48);
        for (String str : hashSet) {
            logger.info("dropping index '{}' for table '{}", str, tableInfo.getTableName());
            sb.append("DROP INDEX ");
            databaseType.appendEscapedEntityName(sb, str);
            list.add(sb.toString());
            sb.setLength(0);
        }
    }

    private static <T, ID> void addDropTableStatements(DatabaseType databaseType, TableInfo<T, ID> tableInfo, List<String> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            databaseType.dropColumnArg(fieldType, arrayList, arrayList2);
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("DROP TABLE ");
        databaseType.appendEscapedEntityName(sb, tableInfo.getTableName());
        sb.append(' ');
        list.addAll(arrayList);
        list.add(sb.toString());
        list.addAll(arrayList2);
    }

    public static <T> int clearTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return clearTable(connectionSource, databaseTableConfig.getTableName());
    }

    public static <T> int clearTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        String extractTableName = DatabaseTableConfig.extractTableName(cls);
        if (connectionSource.getDatabaseType().isEntityNamesMustBeUpCase()) {
            extractTableName = extractTableName.toUpperCase();
        }
        return clearTable(connectionSource, extractTableName);
    }

    private static <T> int clearTable(ConnectionSource connectionSource, String str) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        StringBuilder sb = new StringBuilder(48);
        if (databaseType.isTruncateSupported()) {
            sb.append("TRUNCATE TABLE ");
        } else {
            sb.append("DELETE FROM ");
        }
        databaseType.appendEscapedEntityName(sb, str);
        String sb2 = sb.toString();
        logger.info("clearing table '{}' with '{}", str, sb2);
        CompiledStatement compiledStatement = null;
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            compiledStatement = readWriteConnection.compileStatement(sb2, StatementBuilder.StatementType.EXECUTE, noFieldTypes);
            return compiledStatement.runExecute();
        } finally {
            if (compiledStatement != null) {
                compiledStatement.close();
            }
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    public static <T> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, (DatabaseTableConfig) databaseTableConfig, false);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doCreateTable(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doCreateTable(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), z);
    }

    public static <T> int createTable(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, (Class) cls, false);
    }

    private static <T, ID> int createTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        return createDao instanceof BaseDaoImpl ? doCreateTable(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z) : doCreateTable(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        return createTable(connectionSource, (DatabaseTableConfig) databaseTableConfig, true);
    }

    public static <T> int createTableIfNotExists(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return createTable(connectionSource, (Class) cls, true);
    }

    private static <T, ID> int doCreateTable(ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        logger.info("creating table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        addCreateTableStatements(databaseType, tableInfo, arrayList, arrayList2, z);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "create", arrayList, false, databaseType.isCreateTableReturnsNegative(), databaseType.isCreateTableReturnsZero()) + doCreateTestQueries(readWriteConnection, databaseType, arrayList2);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    private static int doCreateTestQueries(DatabaseConnection databaseConnection, DatabaseType databaseType, List<String> list) throws SQLException {
        CompiledStatement compileStatement;
        int i = 0;
        for (String str : list) {
            CompiledStatement compiledStatement = null;
            try {
                try {
                    compileStatement = databaseConnection.compileStatement(str, StatementBuilder.StatementType.SELECT, noFieldTypes);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (SQLException e) {
                e = e;
            }
            try {
                DatabaseResults runQuery = compileStatement.runQuery(null);
                int i2 = 0;
                for (boolean first = runQuery.first(); first; first = runQuery.next()) {
                    i2++;
                }
                logger.info("executing create table after-query got {} results: {}", Integer.valueOf(i2), str);
                if (compileStatement != null) {
                    compileStatement.close();
                }
                i++;
            } catch (SQLException e2) {
                e = e2;
                compiledStatement = compileStatement;
                throw SqlExceptionUtil.create("executing create table after-query failed: " + str, e);
            } catch (Throwable th2) {
                th = th2;
                compiledStatement = compileStatement;
                if (compiledStatement != null) {
                    compiledStatement.close();
                }
                throw th;
            }
        }
        return i;
    }

    private static <T, ID> int doDropTable(DatabaseType databaseType, ConnectionSource connectionSource, TableInfo<T, ID> tableInfo, boolean z) throws SQLException {
        logger.info("dropping table '{}'", tableInfo.getTableName());
        ArrayList arrayList = new ArrayList();
        addDropIndexStatements(databaseType, tableInfo, arrayList);
        addDropTableStatements(databaseType, tableInfo, arrayList);
        DatabaseConnection readWriteConnection = connectionSource.getReadWriteConnection();
        try {
            return doStatements(readWriteConnection, "drop", arrayList, z, databaseType.isCreateTableReturnsNegative(), false);
        } finally {
            connectionSource.releaseConnection(readWriteConnection);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
    
        if (r4 >= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
    
        if (r12 == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        throw new java.sql.SQLException("SQL statement " + r2 + " updated " + r4 + " rows, we were expecting >= 0");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0090, code lost:
    
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006c, code lost:
    
        if (r4 <= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x006e, code lost:
    
        if (r13 != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008f, code lost:
    
        throw new java.sql.SQLException("SQL statement updated " + r4 + " rows, we were expecting == 0: " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0040, code lost:
    
        if (r3 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int doStatements(com.j256.ormlite.support.DatabaseConnection r8, java.lang.String r9, java.util.Collection<java.lang.String> r10, boolean r11, boolean r12, boolean r13) throws java.sql.SQLException {
        /*
            java.util.Iterator r10 = r10.iterator()
            r0 = 0
            r1 = r0
        L6:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto Lb0
            java.lang.Object r2 = r10.next()
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            com.j256.ormlite.stmt.StatementBuilder$StatementType r4 = com.j256.ormlite.stmt.StatementBuilder.StatementType.EXECUTE     // Catch: java.lang.Throwable -> L32 java.sql.SQLException -> L35
            com.j256.ormlite.field.FieldType[] r5 = com.j256.ormlite.table.TableUtils.noFieldTypes     // Catch: java.lang.Throwable -> L32 java.sql.SQLException -> L35
            com.j256.ormlite.support.CompiledStatement r3 = r8.compileStatement(r2, r4, r5)     // Catch: java.lang.Throwable -> L32 java.sql.SQLException -> L35
            int r4 = r3.runExecute()     // Catch: java.lang.Throwable -> L32 java.sql.SQLException -> L35
            com.j256.ormlite.logger.Logger r5 = com.j256.ormlite.table.TableUtils.logger     // Catch: java.sql.SQLException -> L30 java.lang.Throwable -> L32
            java.lang.String r6 = "executed {} table statement changed {} rows: {}"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch: java.sql.SQLException -> L30 java.lang.Throwable -> L32
            r5.info(r6, r9, r7, r2)     // Catch: java.sql.SQLException -> L30 java.lang.Throwable -> L32
            if (r3 == 0) goto L43
        L2c:
            r3.close()
            goto L43
        L30:
            r5 = move-exception
            goto L37
        L32:
            r8 = move-exception
            goto Laa
        L35:
            r5 = move-exception
            r4 = r0
        L37:
            if (r11 == 0) goto L94
            com.j256.ormlite.logger.Logger r6 = com.j256.ormlite.table.TableUtils.logger     // Catch: java.lang.Throwable -> L32
            java.lang.String r7 = "ignoring {} error '{}' for statement: {}"
            r6.info(r7, r9, r5, r2)     // Catch: java.lang.Throwable -> L32
            if (r3 == 0) goto L43
            goto L2c
        L43:
            if (r4 >= 0) goto L6c
            if (r12 == 0) goto L48
            goto L90
        L48:
            java.sql.SQLException r8 = new java.sql.SQLException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "SQL statement "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r10 = " updated "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = " rows, we were expecting >= 0"
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L6c:
            if (r4 <= 0) goto L90
            if (r13 != 0) goto L71
            goto L90
        L71:
            java.sql.SQLException r8 = new java.sql.SQLException
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "SQL statement updated "
            r9.append(r10)
            r9.append(r4)
            java.lang.String r10 = " rows, we were expecting == 0: "
            r9.append(r10)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L90:
            int r1 = r1 + 1
            goto L6
        L94:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L32
            r8.<init>()     // Catch: java.lang.Throwable -> L32
            java.lang.String r9 = "SQL statement failed: "
            r8.append(r9)     // Catch: java.lang.Throwable -> L32
            r8.append(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L32
            java.sql.SQLException r8 = com.j256.ormlite.misc.SqlExceptionUtil.create(r8, r5)     // Catch: java.lang.Throwable -> L32
            throw r8     // Catch: java.lang.Throwable -> L32
        Laa:
            if (r3 == 0) goto Laf
            r3.close()
        Laf:
            throw r8
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.table.TableUtils.doStatements(com.j256.ormlite.support.DatabaseConnection, java.lang.String, java.util.Collection, boolean, boolean, boolean):int");
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return doDropTable(databaseType, connectionSource, new TableInfo(databaseType, (BaseDaoImpl) null, databaseTableConfig), z);
    }

    public static <T, ID> int dropTable(ConnectionSource connectionSource, Class<T> cls, boolean z) throws SQLException {
        DatabaseType databaseType = connectionSource.getDatabaseType();
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        return createDao instanceof BaseDaoImpl ? doDropTable(databaseType, connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), z) : doDropTable(databaseType, connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), z);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, DatabaseTableConfig<T> databaseTableConfig) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, databaseTableConfig);
        if (createDao instanceof BaseDaoImpl) {
            return addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false);
        }
        databaseTableConfig.extractFieldTypes(connectionSource);
        return addCreateTableStatements(connectionSource, new TableInfo(connectionSource.getDatabaseType(), (BaseDaoImpl) null, databaseTableConfig), false);
    }

    public static <T, ID> List<String> getCreateTableStatements(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        Dao createDao = DaoManager.createDao(connectionSource, cls);
        return createDao instanceof BaseDaoImpl ? addCreateTableStatements(connectionSource, ((BaseDaoImpl) createDao).getTableInfo(), false) : addCreateTableStatements(connectionSource, new TableInfo(connectionSource, (BaseDaoImpl) null, cls), false);
    }
}
