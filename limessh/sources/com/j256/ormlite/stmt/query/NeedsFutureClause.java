package com.j256.ormlite.stmt.query;

import com.j256.ormlite.p001db.DatabaseType;
import com.j256.ormlite.stmt.ArgumentHolder;
import java.sql.SQLException;
import java.util.List;

/* loaded from: classes.dex */
public interface NeedsFutureClause extends Clause {
    @Override // com.j256.ormlite.stmt.query.Clause
    /* synthetic */ void appendSql(DatabaseType databaseType, String str, StringBuilder sb, List<ArgumentHolder> list) throws SQLException;

    void setMissingClause(Clause clause);
}
