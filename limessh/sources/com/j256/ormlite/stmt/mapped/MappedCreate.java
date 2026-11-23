package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID> {
    private String dataClassName;
    private final String queryNextSequenceStmt;
    private int versionFieldTypeIndex;

    /* loaded from: classes.dex */
    public static class KeyHolder implements GeneratedKeyHolder {
        public Number key;

        private KeyHolder() {
        }

        @Override // com.j256.ormlite.support.GeneratedKeyHolder
        public void addKey(Number number) throws SQLException {
            if (this.key == null) {
                this.key = number;
                return;
            }
            throw new SQLException("generated key has already been set to " + this.key + ", now set to " + number);
        }

        public Number getKey() {
            return this.key;
        }
    }

    private MappedCreate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, String str2, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.dataClassName = tableInfo.getDataClass().getSimpleName();
        this.queryNextSequenceStmt = str2;
        this.versionFieldTypeIndex = i;
    }

    private void assignIdValue(T t, Number number, String str, ObjectCache objectCache) throws SQLException {
        this.idField.assignIdValue(t, number, objectCache);
        if (BaseMappedStatement.logger.isLevelEnabled(Log.Level.DEBUG)) {
            BaseMappedStatement.logger.debug("assigned id '{}' from {} to '{}' in {} object", new Object[]{number, str, this.idField.getFieldName(), this.dataClassName});
        }
    }

    private void assignSequenceId(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        long queryForLong = databaseConnection.queryForLong(this.queryNextSequenceStmt);
        BaseMappedStatement.logger.debug("queried for sequence {} using stmt: {}", Long.valueOf(queryForLong), this.queryNextSequenceStmt);
        if (queryForLong != 0) {
            assignIdValue(t, Long.valueOf(queryForLong), "sequence", objectCache);
            return;
        }
        throw new SQLException("Should not have returned 0 for stmt: " + this.queryNextSequenceStmt);
    }

    public static <T, ID> MappedCreate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) {
        StringBuilder sb = new StringBuilder(128);
        BaseMappedStatement.appendTableName(databaseType, sb, "INSERT INTO ", tableInfo.getTableName());
        sb.append('(');
        int i = 0;
        int i2 = -1;
        for (FieldType fieldType : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType)) {
                if (fieldType.isVersion()) {
                    i2 = i;
                }
                i++;
            }
        }
        FieldType[] fieldTypeArr = new FieldType[i];
        boolean z = true;
        int i3 = 0;
        boolean z2 = true;
        for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType2)) {
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(",");
                }
                BaseMappedStatement.appendFieldColumnName(databaseType, sb, fieldType2, null);
                fieldTypeArr[i3] = fieldType2;
                i3++;
            }
        }
        sb.append(") VALUES (");
        for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
            if (isFieldCreatable(databaseType, fieldType3)) {
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append("?");
            }
        }
        sb.append(")");
        return new MappedCreate<>(tableInfo, sb.toString(), fieldTypeArr, buildQueryNextSequence(databaseType, tableInfo.getIdField()), i2);
    }

    private static String buildQueryNextSequence(DatabaseType databaseType, FieldType fieldType) {
        String generatedIdSequence;
        if (fieldType == null || (generatedIdSequence = fieldType.getGeneratedIdSequence()) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(64);
        databaseType.appendSelectNextValFromSequence(sb, generatedIdSequence);
        return sb.toString();
    }

    private boolean foreignCollectionsAreAssigned(FieldType[] fieldTypeArr, Object obj) throws SQLException {
        for (FieldType fieldType : fieldTypeArr) {
            if (fieldType.extractJavaFieldValue(obj) == null) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFieldCreatable(DatabaseType databaseType, FieldType fieldType) {
        if (fieldType.isForeignCollection()) {
            return false;
        }
        return (databaseType.isIdSequenceNeeded() && databaseType.isSelectSequenceBeforeInsert()) || !fieldType.isGeneratedId() || fieldType.isSelfGeneratedId() || fieldType.isAllowGeneratedIdInsert();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0060 A[Catch: SQLException -> 0x011a, TryCatch #0 {SQLException -> 0x011a, blocks: (B:25:0x0058, B:27:0x0060, B:29:0x006a, B:33:0x0086, B:34:0x0073, B:36:0x0079, B:38:0x0083, B:43:0x0089, B:45:0x0091, B:47:0x0095, B:48:0x00a7, B:50:0x00c4, B:53:0x00cf, B:55:0x00da, B:57:0x00e0, B:59:0x00ea, B:60:0x00f0, B:61:0x00f7, B:63:0x00f8, B:64:0x00ff, B:66:0x0102, B:68:0x010e), top: B:24:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00c4 A[Catch: SQLException -> 0x011a, TryCatch #0 {SQLException -> 0x011a, blocks: (B:25:0x0058, B:27:0x0060, B:29:0x006a, B:33:0x0086, B:34:0x0073, B:36:0x0079, B:38:0x0083, B:43:0x0089, B:45:0x0091, B:47:0x0095, B:48:0x00a7, B:50:0x00c4, B:53:0x00cf, B:55:0x00da, B:57:0x00e0, B:59:0x00ea, B:60:0x00f0, B:61:0x00f7, B:63:0x00f8, B:64:0x00ff, B:66:0x0102, B:68:0x010e), top: B:24:0x0058 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int insert(com.j256.ormlite.p001db.DatabaseType r10, com.j256.ormlite.support.DatabaseConnection r11, T r12, com.j256.ormlite.dao.ObjectCache r13) throws java.sql.SQLException {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.stmt.mapped.MappedCreate.insert(com.j256.ormlite.db.DatabaseType, com.j256.ormlite.support.DatabaseConnection, java.lang.Object, com.j256.ormlite.dao.ObjectCache):int");
    }
}
