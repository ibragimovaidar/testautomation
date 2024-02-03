package com.github.ibragimovaidar;

import com.github.ibragimovaidar.testautomationplatform.TestAutomationPlatformBaseListener;
import com.github.ibragimovaidar.testautomationplatform.TestAutomationPlatformParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ListenerImpl extends TestAutomationPlatformBaseListener {

    private static final Logger log = LoggerFactory.getLogger("ListenerImpl");

    @Override
    public void enterProg(TestAutomationPlatformParser.ProgContext ctx) {
        log.info("enterProg {}", ctx.getText());
    }

    @Override
    public void exitProg(TestAutomationPlatformParser.ProgContext ctx) {
        log.info("exitProg {}", ctx.getText());
    }

    @Override
    public void enterCommands(TestAutomationPlatformParser.CommandsContext ctx) {
        log.info("enterCommands {}", ctx.getText());
    }

    @Override
    public void exitCommands(TestAutomationPlatformParser.CommandsContext ctx) {
        log.info("exitCommands {}", ctx.getText());
    }

    @Override
    public void enterHttp_command(TestAutomationPlatformParser.Http_commandContext ctx) {
        log.info("enterHttpCommand {}", ctx.getText());
    }

    @Override
    public void exitHttp_command(TestAutomationPlatformParser.Http_commandContext ctx) {
        log.info("exitHttpCommand {}", ctx.getText());
    }

    @Override
    public void enterHttp_method(TestAutomationPlatformParser.Http_methodContext ctx) {
        log.info("enterHttpMethod {}", ctx.getText());
    }

    @Override
    public void exitHttp_method(TestAutomationPlatformParser.Http_methodContext ctx) {
        log.info("exitHttpMethod {}", ctx.getText());
    }

    @Override
    public void enterHttp_url(TestAutomationPlatformParser.Http_urlContext ctx) {
        log.info("enterHttpUrl {}", ctx.getText());
    }

    @Override
    public void exitHttp_url(TestAutomationPlatformParser.Http_urlContext ctx) {
        log.info("exitHttpUrl {}", ctx.getText());
    }
}
