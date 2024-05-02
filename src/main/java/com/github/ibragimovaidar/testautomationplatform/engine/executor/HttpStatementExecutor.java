package com.github.ibragimovaidar.testautomationplatform.engine.executor;

import com.github.ibragimovaidar.testautomationplatform.engine.exception.TestAutomationPlatformException;
import com.github.ibragimovaidar.testautomationplatform.engine.http.HttpRequestBuilder;
import com.github.ibragimovaidar.testautomationplatform.engine.model.HttpStatement;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.HttpStatementResult;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class HttpStatementExecutor implements StatementExecutor<HttpStatement> {

    private static final RequestSpecBuilder httpSpec = HttpRequestBuilder.getRequestSpecificationBuilder();

    private static final RequestSpecification rest = RestAssured.given().spec(httpSpec.build());

    @Override
    public HttpStatementResult execute(HttpStatement statement) {
        final Response[] response = new Response[1];
        Allure.step(String.format("%s %s", statement.getMethod(), statement.getUrl()), () -> {
            var spec = rest;
            if (statement.getHeaders() != null) {
                spec = spec.headers(statement.getHeaders());
            }
            if (statement.getBody() != null) {
                spec = spec.body(statement.getBody());
            }
            response[0] = switch (statement.getMethod().toUpperCase()) {
                case "GET" -> spec.get(statement.getUrl());
                case "POST" -> spec.post(statement.getUrl());
                case "PUT" -> spec.put(statement.getUrl(        ));
                case "PATCH" -> spec.patch(statement.getUrl());
                case "DELETE" -> spec.delete(statement.getUrl());
                case "OPTIONS" -> spec.options(statement.getUrl());
                default -> throw new TestAutomationPlatformException("Error parsing HTTP request method");
            };
            Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
        });

        return new HttpStatementResult(response[0].statusCode(), response[0].asByteArray());
    }
}
