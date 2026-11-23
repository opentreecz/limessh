package com.j256.ormlite.field.types;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes.dex */
public class FloatType extends FloatObjectType {
    private static final FloatType singleTon = new FloatType();

    private FloatType() {
        super(SqlType.FLOAT, new Class[]{Float.TYPE});
    }

    public FloatType(SqlType sqlType, Class<?>[] clsArr) {
        super(sqlType, clsArr);
    }

    public static FloatType getSingleton() {
        return singleTon;
    }

    @Override // com.j256.ormlite.field.types.BaseDataType, com.j256.ormlite.field.DataPersister
    public boolean isPrimitive() {
        return true;
    }
}
