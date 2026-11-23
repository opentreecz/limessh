package com.j256.ormlite.stmt;

import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

/* loaded from: classes.dex */
public interface PreparedQuery<T> extends PreparedStmt<T> {
    @Override // com.j256.ormlite.stmt.PreparedStmt
    /* synthetic */ CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException;

    @Override // com.j256.ormlite.stmt.PreparedStmt
    /* synthetic */ CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i) throws SQLException;

    @Override // com.j256.ormlite.stmt.PreparedStmt
    /* synthetic */ String getStatement() throws SQLException;

    @Override // com.j256.ormlite.stmt.PreparedStmt
    /* synthetic */ StatementBuilder.StatementType getType();

    @Override // com.j256.ormlite.stmt.PreparedStmt, com.j256.ormlite.stmt.GenericRowMapper
    /* synthetic */ T mapRow(DatabaseResults databaseResults) throws SQLException;

    @Override // com.j256.ormlite.stmt.PreparedStmt
    /* synthetic */ void setArgumentHolderValue(int i, Object obj) throws SQLException;
}
