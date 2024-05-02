package com.github.ibragimovaidar.testautomationplatform.engine.executor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ibragimovaidar.testautomationplatform.engine.exception.TestAutomationPlatformException;
import com.github.ibragimovaidar.testautomationplatform.engine.model.Assertion;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.DatabaseStatementResult;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.HttpStatementResult;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.StatementResult;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.VariableStatementResult;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;

import java.util.Collection;

public class AssertionStatementExecutor {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public StatementResult execute(Assertion assertion, Collection<VariableStatementResult> variables) {
        Allure.step(String.format("Assertion %s", assertion.getVariableName()), () -> {
            Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
        });
       return null;
    }

    private void resolveStatementResult(String name, String value, StatementResult result) {
        if (result instanceof HttpStatementResult httpResult) {
            resolveHttpResult(name, value, httpResult);
        } else if (result instanceof DatabaseStatementResult dbResult) {
            resolveDbResult(name, value, dbResult);
        }
    }

    private boolean resolveHttpResult(String name, String value, HttpStatementResult result) {
        if ("status".equals(name)) {
            return Integer.valueOf(value).equals(result.getStatusCode());
        }
        if (name.startsWith("body")) {
            return true;
        }
        return false;
    }

    private boolean resolveDbResult(String name, String value, DatabaseStatementResult result) {
        return true;
    }
}
