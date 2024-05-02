// Generated from com.github.ibragimovaidar/TestAutomationPlatform.g4 by ANTLR 4.7.1
package com.github.ibragimovaidar.testautomationplatform.engine.parser.listener;
import com.github.ibragimovaidar.testautomationplatform.engine.parser.ast.TestAutomationPlatformParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestAutomationPlatformParser}.
 */
public interface TestAutomationPlatformListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TestAutomationPlatformParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TestAutomationPlatformParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#features}.
	 * @param ctx the parse tree
	 */
	void enterFeatures(TestAutomationPlatformParser.FeaturesContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#features}.
	 * @param ctx the parse tree
	 */
	void exitFeatures(TestAutomationPlatformParser.FeaturesContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#feature}.
	 * @param ctx the parse tree
	 */
	void enterFeature(TestAutomationPlatformParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#feature}.
	 * @param ctx the parse tree
	 */
	void exitFeature(TestAutomationPlatformParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#featureName}.
	 * @param ctx the parse tree
	 */
	void enterFeatureName(TestAutomationPlatformParser.FeatureNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#featureName}.
	 * @param ctx the parse tree
	 */
	void exitFeatureName(TestAutomationPlatformParser.FeatureNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#assertion}.
	 * @param ctx the parse tree
	 */
	void enterAssertion(TestAutomationPlatformParser.AssertionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#assertion}.
	 * @param ctx the parse tree
	 */
	void exitAssertion(TestAutomationPlatformParser.AssertionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#exression}.
	 * @param ctx the parse tree
	 */
	void enterExression(TestAutomationPlatformParser.ExressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#exression}.
	 * @param ctx the parse tree
	 */
	void exitExression(TestAutomationPlatformParser.ExressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(TestAutomationPlatformParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(TestAutomationPlatformParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(TestAutomationPlatformParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(TestAutomationPlatformParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(TestAutomationPlatformParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(TestAutomationPlatformParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#http_command}.
	 * @param ctx the parse tree
	 */
	void enterHttp_command(TestAutomationPlatformParser.Http_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#http_command}.
	 * @param ctx the parse tree
	 */
	void exitHttp_command(TestAutomationPlatformParser.Http_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#db_command}.
	 * @param ctx the parse tree
	 */
	void enterDb_command(TestAutomationPlatformParser.Db_commandContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#db_command}.
	 * @param ctx the parse tree
	 */
	void exitDb_command(TestAutomationPlatformParser.Db_commandContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#httpMethod}.
	 * @param ctx the parse tree
	 */
	void enterHttpMethod(TestAutomationPlatformParser.HttpMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#httpMethod}.
	 * @param ctx the parse tree
	 */
	void exitHttpMethod(TestAutomationPlatformParser.HttpMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#httpUrl}.
	 * @param ctx the parse tree
	 */
	void enterHttpUrl(TestAutomationPlatformParser.HttpUrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#httpUrl}.
	 * @param ctx the parse tree
	 */
	void exitHttpUrl(TestAutomationPlatformParser.HttpUrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#httpBody}.
	 * @param ctx the parse tree
	 */
	void enterHttpBody(TestAutomationPlatformParser.HttpBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#httpBody}.
	 * @param ctx the parse tree
	 */
	void exitHttpBody(TestAutomationPlatformParser.HttpBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#httpHeaders}.
	 * @param ctx the parse tree
	 */
	void enterHttpHeaders(TestAutomationPlatformParser.HttpHeadersContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#httpHeaders}.
	 * @param ctx the parse tree
	 */
	void exitHttpHeaders(TestAutomationPlatformParser.HttpHeadersContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#db_query}.
	 * @param ctx the parse tree
	 */
	void enterDb_query(TestAutomationPlatformParser.Db_queryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#db_query}.
	 * @param ctx the parse tree
	 */
	void exitDb_query(TestAutomationPlatformParser.Db_queryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#string}.
	 * @param ctx the parse tree
	 */
	void enterString(TestAutomationPlatformParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#string}.
	 * @param ctx the parse tree
	 */
	void exitString(TestAutomationPlatformParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#json}.
	 * @param ctx the parse tree
	 */
	void enterJson(TestAutomationPlatformParser.JsonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#json}.
	 * @param ctx the parse tree
	 */
	void exitJson(TestAutomationPlatformParser.JsonContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(TestAutomationPlatformParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(TestAutomationPlatformParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterPair(TestAutomationPlatformParser.PairContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitPair(TestAutomationPlatformParser.PairContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#arr}.
	 * @param ctx the parse tree
	 */
	void enterArr(TestAutomationPlatformParser.ArrContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#arr}.
	 * @param ctx the parse tree
	 */
	void exitArr(TestAutomationPlatformParser.ArrContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(TestAutomationPlatformParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(TestAutomationPlatformParser.ValueContext ctx);
}