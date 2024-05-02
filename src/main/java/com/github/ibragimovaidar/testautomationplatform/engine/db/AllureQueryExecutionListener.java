package com.github.ibragimovaidar.testautomationplatform.engine.db;

import io.qameta.allure.Allure;
import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;
import net.ttddyy.dsproxy.listener.logging.DefaultQueryLogEntryCreator;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class AllureQueryExecutionListener implements QueryExecutionListener {

    private final DefaultQueryLogEntryCreator logEntryCreator = new DefaultQueryLogEntryCreator();


    @Override
    public void beforeQuery(ExecutionInfo executionInfo, List<QueryInfo> list) {
        // NOBODY
    }

    @Override
    public void afterQuery(ExecutionInfo executionInfo, List<QueryInfo> list) {
        var lifecycle = Allure.getLifecycle();
        if (lifecycle.getCurrentTestCase().isPresent()) {
            lifecycle.addAttachment(
                    "SQL",
                    "text/html",
                    "html",
                    logEntryCreator.getLogEntry(executionInfo, list, true, true, true).getBytes(StandardCharsets.UTF_8));
        }
    }

}
