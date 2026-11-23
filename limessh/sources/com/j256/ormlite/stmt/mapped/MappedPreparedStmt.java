package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.PreparedDelete;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.PreparedUpdate;
import com.j256.ormlite.stmt.StatementBuilder;
import com.j256.ormlite.support.CompiledStatement;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

/* loaded from: classes.dex */
public class MappedPreparedStmt<T, ID> extends BaseMappedQuery<T, ID> implements PreparedQuery<T>, PreparedDelete<T>, PreparedUpdate<T> {
    private final ArgumentHolder[] argHolders;
    private final Long limit;
    private final StatementBuilder.StatementType type;

    public MappedPreparedStmt(TableInfo<T, ID> tableInfo, String str, FieldType[] fieldTypeArr, FieldType[] fieldTypeArr2, ArgumentHolder[] argumentHolderArr, Long l, StatementBuilder.StatementType statementType) {
        super(tableInfo, str, fieldTypeArr, fieldTypeArr2);
        this.argHolders = argumentHolderArr;
        this.limit = l;
        this.type = statementType;
    }

    private CompiledStatement assignStatementArguments(CompiledStatement compiledStatement) throws SQLException {
        ArgumentHolder[] argumentHolderArr;
        try {
            Long l = this.limit;
            if (l != null) {
                compiledStatement.setMaxRows(l.intValue());
            }
            Object[] objArr = null;
            if (BaseMappedStatement.logger.isLevelEnabled(Log.Level.TRACE)) {
                ArgumentHolder[] argumentHolderArr2 = this.argHolders;
                if (argumentHolderArr2.length > 0) {
                    objArr = new Object[argumentHolderArr2.length];
                }
            }
            int i = 0;
            while (true) {
                argumentHolderArr = this.argHolders;
                if (i >= argumentHolderArr.length) {
                    break;
                }
                Object sqlArgValue = argumentHolderArr[i].getSqlArgValue();
                FieldType fieldType = this.argFieldTypes[i];
                compiledStatement.setObject(i, sqlArgValue, fieldType == null ? this.argHolders[i].getSqlType() : fieldType.getSqlType());
                if (objArr != null) {
                    objArr[i] = sqlArgValue;
                }
                i++;
            }
            BaseMappedStatement.logger.debug("prepared statement '{}' with {} args", this.statement, Integer.valueOf(argumentHolderArr.length));
            if (objArr != null) {
                BaseMappedStatement.logger.trace("prepared statement arguments: {}", (Object) objArr);
            }
            return compiledStatement;
        } catch (Throwable th) {
            compiledStatement.close();
            throw th;
        }
    }

    @Override // com.j256.ormlite.stmt.PreparedQuery, com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType) throws SQLException {
        return compile(databaseConnection, statementType, -1);
    }

    @Override // com.j256.ormlite.stmt.PreparedQuery, com.j256.ormlite.stmt.PreparedStmt
    public CompiledStatement compile(DatabaseConnection databaseConnection, StatementBuilder.StatementType statementType, int i) throws SQLException {
        if (this.type == statementType) {
            return assignStatementArguments(databaseConnection.compileStatement(this.statement, statementType, this.argFieldTypes, i));
        }
        throw new SQLException("Could not compile this " + this.type + " statement since the caller is expecting a " + statementType + " statement.  Check your QueryBuilder methods.");
    }

    @Override // com.j256.ormlite.stmt.PreparedQuery, com.j256.ormlite.stmt.PreparedStmt
    public String getStatement() {
        return this.statement;
    }

    @Override // com.j256.ormlite.stmt.PreparedQuery, com.j256.ormlite.stmt.PreparedStmt
    public StatementBuilder.StatementType getType() {
        return this.type;
    }

    @Override // com.j256.ormlite.stmt.PreparedQuery, com.j256.ormlite.stmt.PreparedStmt
    public void setArgumentHolderValue(int i, Object obj) throws SQLException {
        if (i < 0) {
            throw new SQLException("argument holder index " + i + " must be >= 0");
        }
        ArgumentHolder[] argumentHolderArr = this.argHolders;
        if (argumentHolderArr.length > i) {
            argumentHolderArr[i].setValue(obj);
            return;
        }
        throw new SQLException("argument holder index " + i + " not valid, only " + this.argHolders.length + " in statement");
    }
}
