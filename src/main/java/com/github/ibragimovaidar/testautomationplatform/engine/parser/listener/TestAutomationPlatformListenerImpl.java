package com.github.ibragimovaidar.testautomationplatform.engine.parser.listener;

import com.github.ibragimovaidar.testautomationplatform.engine.exception.TestAutomationPlatformException;
import com.github.ibragimovaidar.testautomationplatform.engine.model.*;
import com.github.ibragimovaidar.testautomationplatform.engine.parser.ast.TestAutomationPlatformParser;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import static com.github.ibragimovaidar.testautomationplatform.engine.parser.listener.ExpressionContext.*;
import static com.github.ibragimovaidar.testautomationplatform.engine.parser.util.DeserializationTypeUtil.HTTP_HEADERS_TYPE;


@Getter
@Setter
public class TestAutomationPlatformListenerImpl extends TestAutomationPlatformBaseListener {

    private final Gson gson = new Gson();

    private List<Feature> features = new ArrayList<>();

    private Feature currentFeature = null;

    private HttpStatement currentHttp = null;

    private DatabaseStatement currentDb = null;

    private VariableAssigment currentVariable = null;

    private Assertion currentAssertion = null;

    private EnumSet<ExpressionContext> activeContext = EnumSet.noneOf(ExpressionContext.class);

    @Override
    public void enterFeature(TestAutomationPlatformParser.FeatureContext ctx) {
        this.currentFeature = new Feature();
    }

    @Override
    public void exitFeature(TestAutomationPlatformParser.FeatureContext ctx) {
        this.features.add(currentFeature);
        this.currentFeature = null;
    }

    @Override
    public void enterVariable(TestAutomationPlatformParser.VariableContext ctx) {
        this.activeContext.add(ExpressionContext.VARIABLE);
        this.currentVariable = new VariableAssigment();
    }

    @Override
    public void exitVariable(TestAutomationPlatformParser.VariableContext ctx) {
        this.activeContext.remove(ExpressionContext.VARIABLE);
        this.currentFeature.addVariable(this.currentVariable);
        this.currentVariable = null;
    }

    @Override
    public void enterVariableName(TestAutomationPlatformParser.VariableNameContext ctx) {
        resolveVariableName(ctx);
    }

    @Override
    public void enterFeatureName(TestAutomationPlatformParser.FeatureNameContext ctx) {
        this.currentFeature.setName(ctx.getText());
    }

    @Override
    public void enterHttp_command(TestAutomationPlatformParser.Http_commandContext ctx) {
        this.currentHttp = new HttpStatement();
    }

    @Override
    public void exitHttp_command(TestAutomationPlatformParser.Http_commandContext ctx) {
        if (this.activeContext.contains(ExpressionContext.VARIABLE)) {
            this.currentVariable.setStatement(currentHttp);
        } else {
            this.currentFeature.addStatement(currentHttp);
        }
        this.currentHttp = null;
    }

    @Override
    public void enterHttpMethod(TestAutomationPlatformParser.HttpMethodContext ctx) {
        this.currentHttp.setMethod(ctx.getText());
    }

    @Override
    public void enterHttpUrl(TestAutomationPlatformParser.HttpUrlContext ctx) {
        var stringLiteral = ctx.getText();
        this.currentHttp.setUrl(stringLiteral.substring(1, stringLiteral.length()-1));
    }


    @Override
    public void enterHttpBody(TestAutomationPlatformParser.HttpBodyContext ctx) {
        this.activeContext.add(HTTP_BODY);
    }

    @Override
    public void exitHttpBody(TestAutomationPlatformParser.HttpBodyContext ctx) {
        this.activeContext.remove(HTTP_BODY);
    }

    @Override
    public void enterHttpHeaders(TestAutomationPlatformParser.HttpHeadersContext ctx) {
        this.activeContext.add(ExpressionContext.HTTP_HEADERS);
    }

    @Override
    public void exitHttpHeaders(TestAutomationPlatformParser.HttpHeadersContext ctx) {
        this.activeContext.remove(ExpressionContext.HTTP_HEADERS);
    }

    @Override
    public void enterAssertion(TestAutomationPlatformParser.AssertionContext ctx) {
        this.currentAssertion = new Assertion();
        this.activeContext.add(ExpressionContext.ASSERTION);
    }

    @Override
    public void exitAssertion(TestAutomationPlatformParser.AssertionContext ctx) {
        this.currentFeature.addAssertion(this.currentAssertion);
        this.activeContext.remove(ExpressionContext.ASSERTION);
        this.currentAssertion = null;
    }

    @Override
    public void enterDb_command(TestAutomationPlatformParser.Db_commandContext ctx) {
        this.currentDb = new DatabaseStatement();
    }

    @Override
    public void exitDb_command(TestAutomationPlatformParser.Db_commandContext ctx) {
        if (this.activeContext.contains(ExpressionContext.VARIABLE)) {
            this.currentVariable.setStatement(currentDb);
        } else {
            this.currentFeature.addStatement(this.currentDb);
        }
        this.currentDb = null;
    }

    @Override
    public void enterDb_query(TestAutomationPlatformParser.Db_queryContext ctx) {
        String query = ctx.getText().substring(1, ctx.getText().length()-1);
        this.currentDb.setQuery(query);
    }

    @Override
    public void enterString(TestAutomationPlatformParser.StringContext ctx) {
        resolveString(ctx);
    }

    @Override
    public void enterJson(TestAutomationPlatformParser.JsonContext ctx) {
        resolveJsonContext(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

    private void resolveJsonContext(TestAutomationPlatformParser.JsonContext ctx) {
        if (activeContext.contains(HTTP_BODY)) {
            this.currentHttp.setBody(ctx.getText().getBytes(StandardCharsets.UTF_8));
        } else if (activeContext.contains(HTTP_HEADERS)) {
            this.currentHttp.setHeaders(gson.fromJson(ctx.getText(), HTTP_HEADERS_TYPE));
        } else {
            throw new TestAutomationPlatformException("No statement context");
        }
    }

    private void resolveString(TestAutomationPlatformParser.StringContext ctx) {
        // remove ""
        String string = ctx.getText().substring(1, ctx.getText().length()-1);
        if (activeContext.contains(HTTP_BODY)) {
            this.currentHttp.setBody(string.getBytes(StandardCharsets.UTF_8));
        } else if (activeContext.contains(HTTP_HEADERS)) {
            this.currentHttp.setHeaders(gson.fromJson(string, HTTP_HEADERS_TYPE));
        } else {
            throw new TestAutomationPlatformException("No statement context");
        }
    }

    private void resolveVariableName(TestAutomationPlatformParser.VariableNameContext ctx) {
        String variableName = ctx.getText();
        if (activeContext.contains(VARIABLE)) {
            this.currentVariable.setName(variableName);
        } else if (activeContext.contains(ASSERTION)) {
            this.currentAssertion.setVariableName(variableName);
        } else {
            throw new TestAutomationPlatformException("No statement context");
        }
    }

    @Override
    public void enterExression(TestAutomationPlatformParser.ExressionContext ctx) {
        if (this.currentAssertion != null) {
            if (currentAssertion.getExpressions() == null) {
                currentAssertion.setExpressions(new ArrayList<>());
            }
            currentAssertion.getExpressions().add(ctx.getText());
        }
    }
}
