package com.github.ibragimovaidar.testautomationplatform.runner;

import com.github.ibragimovaidar.testautomationplatform.engine.executor.AssertionStatementExecutor;
import com.github.ibragimovaidar.testautomationplatform.engine.executor.DatabaseStatementExecutor;
import com.github.ibragimovaidar.testautomationplatform.engine.executor.VariableStatementExecutor;
import com.github.ibragimovaidar.testautomationplatform.engine.model.*;
import com.github.ibragimovaidar.testautomationplatform.engine.parser.ast.TestAutomationPlatformParser;
import com.github.ibragimovaidar.testautomationplatform.engine.parser.ast.TestAutomationPlatformLexer;
import com.github.ibragimovaidar.testautomationplatform.engine.exception.TestAutomationPlatformException;
import com.github.ibragimovaidar.testautomationplatform.engine.executor.HttpStatementExecutor;
import com.github.ibragimovaidar.testautomationplatform.engine.parser.listener.TestAutomationPlatformListenerImpl;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Objects;

@Slf4j
public class TestAutomationPlatformRunner {

    HttpStatementExecutor httpStatementExecutor = new HttpStatementExecutor();

    DatabaseStatementExecutor databaseStatementExecutor = new DatabaseStatementExecutor();

    VariableStatementExecutor variableStatementExecutor = new VariableStatementExecutor(httpStatementExecutor, databaseStatementExecutor);
    AssertionStatementExecutor assertionStatementExecutor = new AssertionStatementExecutor();

    public void run() {
        try (var is = this.getClass().getClassLoader().getResourceAsStream("testFeature.features")) {
            run(Objects.requireNonNull(is));
        } catch (Exception e) {
            log.error("", e);
            throw new TestAutomationPlatformException("Error", e);
        }
    }

    public void run(InputStream featureStream) throws TestAutomationPlatformException {
        String featuresString = null;
        try {
             featuresString = new String(featureStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("Error reading features from InputStream");
            throw new TestAutomationPlatformException("Error reading features from InputStream");
        }

        var features = parseFeatures(featuresString);
        for (var feature: features) {
            Allure.feature(feature.getName());
            var statements = feature.getStatements();
            for (var statement: statements) {
                if (statement instanceof HttpStatement httpStatement) {
                    httpStatementExecutor.execute(httpStatement);
                }
                if (statement instanceof VariableAssigment variableAssigment) {
                    variableStatementExecutor.execute(variableAssigment);
                }
                if (statement instanceof DatabaseStatement databaseStatement) {
                    databaseStatementExecutor.execute(databaseStatement);
                }
                if (statement instanceof Assertion assertion) {
                    assertionStatementExecutor.execute(assertion, null);
                }
            }
        }
    }

    private Collection<Feature> parseFeatures(String features) {
        var lexer = new TestAutomationPlatformLexer(CharStreams.fromString(features));
        var tokens = new CommonTokenStream(lexer);
        var parser = new TestAutomationPlatformParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        var listener = new TestAutomationPlatformListenerImpl();
        walker.walk(listener, parser.prog());
        return listener.getFeatures();
    }
}
