package com.github.ibragimovaidar.testautomationplatform.runner.junit5;

import io.qameta.allure.DefaultConfiguration;
import io.qameta.allure.ReportGenerator;
import io.qameta.allure.core.Configuration;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.junitplatform.AllureJunitPlatform;
import io.qameta.allure.test.RunUtils;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;
import java.util.List;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestAutomationPlatformJunit5Runner {

    public void run() {
        SummaryGeneratingListener junitListener = new SummaryGeneratingListener();

        AllureJunitPlatform allureJunitPlatform = new AllureJunitPlatform();

        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(TestAutomationPlatformJunit5DynamicTestFactory.class))
                .build();

        Launcher launcher = LauncherFactory.create();
        launcher.discover(request);
        launcher.registerTestExecutionListeners(junitListener);
        launcher.registerTestExecutionListeners(allureJunitPlatform);
        launcher.execute(request);
        junitListener.getSummary().printTo(new PrintWriter(System.out));
    }
}
