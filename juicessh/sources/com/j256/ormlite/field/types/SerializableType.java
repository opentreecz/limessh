package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class SerializableType extends BaseDataType {
    private static final SerializableType singleTon = new SerializableType();

    private SerializableType() {
        super(SqlType.SERIALIZABLE, new Class[0]);
    }

    public SerializableType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static SerializableType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public Class<?> getPrimaryClass() {
        return Serializable.class;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isAppropriateId() {
        return false;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isArgumentHolderRequired() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isComparable() {
        return false;
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public boolean isStreamType() {
        return true;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isValidForField(Field field) {
        return Serializable.class.isAssignableFrom(field.getType());
    }

    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(obj);
            objectOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            e = e2;
            objectOutputStream2 = objectOutputStream;
            throw SqlExceptionUtil.create("Could not write serialized object to byte array: " + obj, e);
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused) {
                }
            }
            throw th;
        }
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object parseDefaultString(FieldType fieldType, String str) throws SQLException {
        throw new SQLException("Default values for serializable types are not supported");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException {
        throw new SQLException("Serializable type cannot be converted from string to Java");
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    public Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException {
        return databaseResults.getBytes(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [int] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.ObjectInputStream] */
    @Override // com.j256.ormlite.field.BaseFieldConverter, com.j256.ormlite.field.FieldConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object sqlArgToJava(com.j256.ormlite.field.FieldType r4, java.lang.Object r5, int r6) throws java.sql.SQLException {
        /*
            r3 = this;
            byte[] r5 = (byte[]) r5
            r4 = 0
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1b
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1b
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1b
            r6.<init>(r0)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L1b
            java.lang.Object r4 = r6.readObject()     // Catch: java.lang.Exception -> L15 java.lang.Throwable -> L47
            r6.close()     // Catch: java.io.IOException -> L14
        L14:
            return r4
        L15:
            r4 = move-exception
            goto L1f
        L17:
            r5 = move-exception
            r6 = r4
            r4 = r5
            goto L48
        L1b:
            r6 = move-exception
            r2 = r6
            r6 = r4
            r4 = r2
        L1f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r0.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = "Could not read serialized object from byte array: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = java.util.Arrays.toString(r5)     // Catch: java.lang.Throwable -> L47
            r0.append(r1)     // Catch: java.lang.Throwable -> L47
            java.lang.String r1 = "(len "
            r0.append(r1)     // Catch: java.lang.Throwable -> L47
            int r5 = r5.length     // Catch: java.lang.Throwable -> L47
            r0.append(r5)     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = ")"
            r0.append(r5)     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = r0.toString()     // Catch: java.lang.Throwable -> L47
            java.sql.SQLException r4 = com.j256.ormlite.misc.SqlExceptionUtil.create(r5, r4)     // Catch: java.lang.Throwable -> L47
            throw r4     // Catch: java.lang.Throwable -> L47
        L47:
            r4 = move-exception
        L48:
            if (r6 == 0) goto L4d
            r6.close()     // Catch: java.io.IOException -> L4d
        L4d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.j256.ormlite.field.types.SerializableType.sqlArgToJava(com.j256.ormlite.field.FieldType, java.lang.Object, int):java.lang.Object");
    }
}
