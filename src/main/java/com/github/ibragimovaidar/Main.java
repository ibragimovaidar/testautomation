package com.github.ibragimovaidar;

import com.github.ibragimovaidar.testautomationplatform.TestAutomationPlatformLexer;
import com.github.ibragimovaidar.testautomationplatform.TestAutomationPlatformParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {

    public static void main(String[] args) {


        String logLines = "http GET \"/api/v1/test\";\r\n";
        var lexer = new TestAutomationPlatformLexer(CharStreams.fromString(logLines));
        var tokens = new CommonTokenStream(lexer);


        var parser = new TestAutomationPlatformParser(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        var listener = new ListenerImpl();
        walker.walk(listener, parser.prog());
    }
}