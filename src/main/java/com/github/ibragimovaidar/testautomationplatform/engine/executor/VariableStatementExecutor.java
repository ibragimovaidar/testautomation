package com.github.ibragimovaidar.testautomationplatform.engine.executor;

import com.github.ibragimovaidar.testautomationplatform.engine.exception.TestAutomationPlatformException;
import com.github.ibragimovaidar.testautomationplatform.engine.model.DatabaseStatement;
import com.github.ibragimovaidar.testautomationplatform.engine.model.HttpStatement;
import com.github.ibragimovaidar.testautomationplatform.engine.model.Statement;
import com.github.ibragimovaidar.testautomationplatform.engine.model.VariableAssigment;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.StatementResult;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.VariableStatementResult;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VariableStatementExecutor implements StatementExecutor<VariableAssigment> {

    private final HttpStatementExecutor httpStatementExecutor;

    private final DatabaseStatementExecutor databaseStatementExecutor;

    @Override
    public StatementResult execute(VariableAssigment variable) {
        var result = new VariableStatementResult();
        result.setVariableName(variable.getName());
        result.setResult(executeVariableStatement(variable.getStatement()));
        return result;
    }

    private StatementResult executeVariableStatement(Statement statement) {
        if (statement instanceof HttpStatement httpStatement) {
            return httpStatementExecutor.execute(httpStatement);
        }
        if (statement instanceof DatabaseStatement dbStatement) {
            return databaseStatementExecutor.execute(dbStatement);
        }
        throw new TestAutomationPlatformException("Variable statement type is not supported");
    }
}
