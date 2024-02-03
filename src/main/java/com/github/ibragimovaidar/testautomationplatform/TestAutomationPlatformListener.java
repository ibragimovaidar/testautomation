// Generated from com.github.ibragimovaidar/TestAutomationPlatform.g4 by ANTLR 4.7.1
package com.github.ibragimovaidar.testautomationplatform;
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
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#commands}.
	 * @param ctx the parse tree
	 */
	void enterCommands(TestAutomationPlatformParser.CommandsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#commands}.
	 * @param ctx the parse tree
	 */
	void exitCommands(TestAutomationPlatformParser.CommandsContext ctx);
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
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#http_method}.
	 * @param ctx the parse tree
	 */
	void enterHttp_method(TestAutomationPlatformParser.Http_methodContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#http_method}.
	 * @param ctx the parse tree
	 */
	void exitHttp_method(TestAutomationPlatformParser.Http_methodContext ctx);
	/**
	 * Enter a parse tree produced by {@link TestAutomationPlatformParser#http_url}.
	 * @param ctx the parse tree
	 */
	void enterHttp_url(TestAutomationPlatformParser.Http_urlContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestAutomationPlatformParser#http_url}.
	 * @param ctx the parse tree
	 */
	void exitHttp_url(TestAutomationPlatformParser.Http_urlContext ctx);
}