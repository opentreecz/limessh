package com.j256.ormlite.field;

import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;
import java.sql.SQLException;

/* loaded from: classes.dex */
public interface DataPersister extends FieldConverter {
    Object convertIdNumber(Number number);

    boolean dataIsEqual(Object obj, Object obj2);

    Object generateId();

    String[] getAssociatedClassNames();

    Class<?>[] getAssociatedClasses();

    int getDefaultWidth();

    Class<?> getPrimaryClass();

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ SqlType getSqlType();

    boolean isAppropriateId();

    boolean isArgumentHolderRequired();

    boolean isComparable();

    boolean isEscapedDefaultValue();

    boolean isEscapedValue();

    boolean isPrimitive();

    boolean isSelfGeneratedId();

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ boolean isStreamType();

    boolean isValidForField(Field field);

    boolean isValidForVersion();

    boolean isValidGeneratedType();

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ Object javaToSqlArg(FieldType fieldType, Object obj) throws SQLException;

    Object makeConfigObject(FieldType fieldType) throws SQLException;

    Object moveToNextValue(Object obj);

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ Object parseDefaultString(FieldType fieldType, String str) throws SQLException;

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ Object resultStringToJava(FieldType fieldType, String str, int i) throws SQLException;

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ Object resultToJava(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException;

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ Object resultToSqlArg(FieldType fieldType, DatabaseResults databaseResults, int i) throws SQLException;

    @Override // com.j256.ormlite.field.FieldConverter
    /* synthetic */ Object sqlArgToJava(FieldType fieldType, Object obj, int i) throws SQLException;
}
