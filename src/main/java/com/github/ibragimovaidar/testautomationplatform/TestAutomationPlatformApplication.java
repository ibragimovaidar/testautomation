package com.github.ibragimovaidar.testautomationplatform;

import com.github.ibragimovaidar.testautomationplatform.runner.allure.TestAutomationPlatformAllureRunner;
import com.github.ibragimovaidar.testautomationplatform.runner.junit5.TestAutomationPlatformJunit5Runner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TestAutomationPlatformApplication implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(TestAutomationPlatformApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var runner = new TestAutomationPlatformJunit5Runner();
        var runnerAllure = new TestAutomationPlatformAllureRunner();
        runnerAllure.run();
    }
}