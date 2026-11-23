package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.j256.ormlite.stmt.query.In */
/* loaded from: classes.dex */
public class C0688In extends BaseComparison {

    /* renamed from: in */
    private final boolean f1286in;
    private Iterable<?> objects;

    public C0688In(String str, FieldType fieldType, Iterable<?> iterable, boolean z) throws SQLException {
        super(str, fieldType, null, true);
        this.objects = iterable;
        this.f1286in = z;
    }

    public C0688In(String str, FieldType fieldType, Object[] objArr, boolean z) throws SQLException {
        super(str, fieldType, null, true);
        this.objects = Arrays.asList(objArr);
        this.f1286in = z;
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendOperation(StringBuilder sb) {
        if (this.f1286in) {
            sb.append("IN ");
        } else {
            sb.append("NOT IN ");
        }
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison, com.j256.ormlite.stmt.query.Clause
    public /* bridge */ /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List list) throws SQLException {
        super.appendSql(databaseType, str, sb, list);
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public void appendValue(DatabaseType databaseType, StringBuilder sb, List<ArgumentHolder> list) throws SQLException {
        sb.append('(');
        boolean z = true;
        for (Object obj : this.objects) {
            if (obj == null) {
                throw new IllegalArgumentException("one of the IN values for '" + this.columnName + "' is null");
            }
            if (z) {
                z = false;
            } else {
                sb.append(',');
            }
            super.appendArgOrValue(databaseType, this.fieldType, sb, list, obj);
        }
        sb.append(") ");
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison, com.j256.ormlite.stmt.query.Comparison
    public /* bridge */ /* synthetic */ String getColumnName() {
        return super.getColumnName();
    }

    @Override // com.j256.ormlite.stmt.query.BaseComparison
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
