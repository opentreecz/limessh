package com.j256.ormlite.p001db;

import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateStringType;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class SqliteAndroidDatabaseType extends BaseSqliteDatabaseType implements DatabaseType {

    /* renamed from: com.j256.ormlite.db.SqliteAndroidDatabaseType$1 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C06811 {
        public static final /* synthetic */ int[] $SwitchMap$com$j256$ormlite$field$SqlType;

        static {
            int[] iArr = new int[SqlType.values().length];
            $SwitchMap$com$j256$ormlite$field$SqlType = iArr;
            try {
                iArr[SqlType.DATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType
    public void appendBooleanType(StringBuilder sb, FieldType fieldType, int i) {
        appendShortType(sb, fieldType, i);
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType
    public void appendDateType(StringBuilder sb, FieldType fieldType, int i) {
        appendStringType(sb, fieldType, i);
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource connectionSource, Class<T> cls) throws SQLException {
        return DatabaseTableConfigUtil.fromClass(connectionSource, cls);
    }

    @Override // com.j256.ormlite.p001db.BaseSqliteDatabaseType, com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public String getDatabaseName() {
        return "Android SQLite";
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType
    public String getDriverClassName() {
        return null;
    }

    @Override // com.j256.ormlite.p001db.BaseSqliteDatabaseType, com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public FieldConverter getFieldConverter(DataPersister dataPersister) {
        return C06811.$SwitchMap$com$j256$ormlite$field$SqlType[dataPersister.getSqlType().ordinal()] != 1 ? super.getFieldConverter(dataPersister) : DateStringType.getSingleton();
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public boolean isBatchUseTransaction() {
        return true;
    }

    @Override // com.j256.ormlite.p001db.BaseSqliteDatabaseType, com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public boolean isDatabaseUrlThisType(String str, String str2) {
        return true;
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public boolean isNestedSavePointsSupported() {
        return false;
    }

    @Override // com.j256.ormlite.p001db.BaseDatabaseType, com.j256.ormlite.p001db.DatabaseType
    public void loadDriver() {
    }
}
