package com.github.ibragimovaidar.testautomationplatform.runner.allure;

import com.github.ibragimovaidar.testautomationplatform.runner.TestAutomationPlatformRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.FileSystemResultsWriter;
import io.qameta.allure.model.Status;
import io.qameta.allure.test.RunUtils;

import java.io.ByteArrayInputStream;
import java.nio.file.Path;
import java.time.ZonedDateTime;

public class TestAutomationPlatformAllureRunner {

    private final TestAutomationPlatformRunner testAutomationPlatformRunner = new TestAutomationPlatformRunner();

/*    private static final List<Extension> EXTENSIONS = Arrays.asList(
            new JacksonContext(),
            new MarkdownContext(),
            new FreemarkerContext(),
            new RandomUidContext(),
            new MarkdownDescriptionsPlugin(),
            new TagsPlugin(),
            new RetryPlugin(),
            new RetryTrendPlugin(),
            new SeverityPlugin(),
            new OwnerPlugin(),
            new IdeaLinksPlugin(),
            new HistoryPlugin(),
            new HistoryTrendPlugin(),
            new CategoriesPlugin(),
            new CategoriesTrendPlugin(),
            new DurationPlugin(),
            new DurationTrendPlugin(),
            new StatusChartPlugin(),
            new TimelinePlugin(),
            new SuitesPlugin(),
            new TestsResultsPlugin(),
            new AttachmentsPlugin(),
            new MailPlugin(),
            new InfluxDbExportPlugin(),
            new PrometheusExportPlugin(),
            new SummaryPlugin(),
            new ExecutorPlugin(),
            new LaunchPlugin(),
            new Allure1Plugin(),
            new Allure1EnvironmentPlugin(),
            new Allure2Plugin()
    );*/

    public void run() {
        var results = RunUtils.runWithinTestContext(() -> {
            Allure.story("story");
            Allure.suite("suite");
            testAutomationPlatformRunner.run();

            var testCase = Allure.getLifecycle().getCurrentTestCase().get();
            Allure.getLifecycle().updateTestCase(testCase, result -> {
                result.setStatus(Status.PASSED);
                result.setName(String.format("Test automation platform execution %s", ZonedDateTime.now()));
                result.setDescription("Test automation platform execution");
            });
        });

        var resultsWriter = new FileSystemResultsWriter(Path.of("/home/aydar/IdeaProjects/antlr-parser/antlr-grammar/allure"));
        results.getAttachments().forEach((name, content) -> {
            resultsWriter.write(name, new ByteArrayInputStream(content));
        });
        results.getTestResults().forEach(resultsWriter::write);
    }
}
