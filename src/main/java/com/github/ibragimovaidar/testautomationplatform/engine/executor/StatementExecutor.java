package com.github.ibragimovaidar.testautomationplatform.engine.executor;

import com.github.ibragimovaidar.testautomationplatform.engine.model.Statement;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.StatementResult;

public interface StatementExecutor <T extends Statement> {

    StatementResult execute(T statement);
}
