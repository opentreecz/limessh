package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID> {
    private final FieldType versionFieldType;
    private final int versionFieldTypeIndex;

    private MappedUpdate(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType fieldType, int i) {
        super(tableInfo, str, fieldTypeArr);
        this.versionFieldType = fieldType;
        this.versionFieldTypeIndex = i;
    }

    public static <T, ID> MappedUpdate<T, ID> build(DatabaseType databaseType, TableInfo<T, ID> tableInfo) throws SQLException {
        FieldType idField = tableInfo.getIdField();
        if (idField == null) {
            throw new SQLException("Cannot update " + tableInfo.getDataClass() + " because it doesn't have an id field");
        }
        StringBuilder sb = new StringBuilder(64);
        BaseMappedStatement.appendTableName(databaseType, sb, "UPDATE ", tableInfo.getTableName());
        int i = -1;
        FieldType fieldType = null;
        int i2 = 0;
        for (FieldType fieldType2 : tableInfo.getFieldTypes()) {
            if (isFieldUpdatable(fieldType2, idField)) {
                if (fieldType2.isVersion()) {
                    i = i2;
                    fieldType = fieldType2;
                }
                i2++;
            }
        }
        boolean z = true;
        int i3 = i2 + 1;
        if (fieldType != null) {
            i3++;
        }
        FieldType[] fieldTypeArr = new FieldType[i3];
        int i4 = 0;
        for (FieldType fieldType3 : tableInfo.getFieldTypes()) {
            if (isFieldUpdatable(fieldType3, idField)) {
                if (z) {
                    sb.append("SET ");
                    z = false;
                } else {
                    sb.append(", ");
                }
                BaseMappedStatement.appendFieldColumnName(databaseType, sb, fieldType3, null);
                fieldTypeArr[i4] = fieldType3;
                sb.append("= ?");
                i4++;
            }
        }
        sb.append(' ');
        BaseMappedStatement.appendWhereFieldEq(databaseType, idField, sb, null);
        int i5 = i4 + 1;
        fieldTypeArr[i4] = idField;
        if (fieldType != null) {
            sb.append(" AND ");
            BaseMappedStatement.appendFieldColumnName(databaseType, sb, fieldType, null);
            sb.append("= ?");
            fieldTypeArr[i5] = fieldType;
        }
        return new MappedUpdate<>(tableInfo, sb.toString(), fieldTypeArr, fieldType, i);
    }

    private static boolean isFieldUpdatable(FieldType fieldType, FieldType fieldType2) {
        return (fieldType == fieldType2 || fieldType.isForeignCollection()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int update(DatabaseConnection databaseConnection, T t, ObjectCache objectCache) throws SQLException {
        Object obj;
        try {
            if (this.argFieldTypes.length <= 1) {
                return 0;
            }
            Object[] fieldObjects = getFieldObjects(t);
            FieldType fieldType = this.versionFieldType;
            if (fieldType != null) {
                obj = this.versionFieldType.moveToNextValue(fieldType.extractJavaFieldValue(t));
                fieldObjects[this.versionFieldTypeIndex] = this.versionFieldType.convertJavaFieldToSqlArgValue(obj);
            } else {
                obj = null;
            }
            int update = databaseConnection.update(this.statement, fieldObjects, this.argFieldTypes);
            if (update > 0) {
                if (obj != null) {
                    this.versionFieldType.assignField(t, obj, false, null);
                }
                if (objectCache != 0) {
                    Object obj2 = objectCache.get(this.clazz, this.idField.extractJavaFieldValue(t));
                    if (obj2 != null && obj2 != t) {
                        for (FieldType fieldType2 : this.tableInfo.getFieldTypes()) {
                            if (fieldType2 != this.idField) {
                                fieldType2.assignField(obj2, fieldType2.extractJavaFieldValue(t), false, objectCache);
                            }
                        }
                    }
                }
            }
            BaseMappedStatement.logger.debug("update data with statement '{}' and {} args, changed {} rows", this.statement, Integer.valueOf(fieldObjects.length), Integer.valueOf(update));
            if (fieldObjects.length > 0) {
                BaseMappedStatement.logger.trace("update arguments: {}", (Object) fieldObjects);
            }
            return update;
        } catch (SQLException e) {
            throw SqlExceptionUtil.create("Unable to run update stmt on object " + t + ": " + this.statement, e);
        }
    }
}
