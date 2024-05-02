package com.github.ibragimovaidar.testautomationplatform.runner.junit5;

import com.github.ibragimovaidar.testautomationplatform.runner.TestAutomationPlatformRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.test.AllureResults;
import io.qameta.allure.test.RunUtils;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class TestAutomationPlatformJunit5DynamicTestFactory {

    private final TestAutomationPlatformRunner testAutomationPlatformRunner = new TestAutomationPlatformRunner();

    @TestFactory
    public Iterable<DynamicTest> generateDynamicTests() {
        List<DynamicTest> tests = new ArrayList<>();


        tests.add(DynamicTest.dynamicTest("Test",
                () -> {
                    var results = RunUtils.runWithinTestContext(() -> {
                        Allure.step("Step", () -> {
                            testAutomationPlatformRunner.run();
                        });
                    });
                }
        ));
        return tests;
    }
}
