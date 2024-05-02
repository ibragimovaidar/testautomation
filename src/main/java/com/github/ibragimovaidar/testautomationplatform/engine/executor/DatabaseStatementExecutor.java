package com.github.ibragimovaidar.testautomationplatform.engine.executor;

import com.github.ibragimovaidar.testautomationplatform.engine.db.AllureQueryExecutionListener;
import com.github.ibragimovaidar.testautomationplatform.engine.model.DatabaseStatement;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.DatabaseStatementResult;
import com.github.ibragimovaidar.testautomationplatform.engine.model.result.StatementResult;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseStatementExecutor implements StatementExecutor<DatabaseStatement> {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseStatementExecutor() {
        var config = new HikariConfig();
        config.setDriverClassName("org.postgresql.Driver");
        config.setPassword("123456");
        config.setUsername("testautomationplatform");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/testautomationplatform");
        var dataSource = new HikariDataSource(config);

        var proxyDataSource = ProxyDataSourceBuilder.create(dataSource)
                .listener(new AllureQueryExecutionListener()).build();

        this.jdbcTemplate = new JdbcTemplate(proxyDataSource);
    }


    @Override
    public StatementResult execute(DatabaseStatement statement) {
        Allure.step("Database query: " + statement.getQuery(), () -> {
            jdbcTemplate.execute(statement.getQuery());
            Allure.getLifecycle().updateStep(stepResult -> stepResult.setStatus(Status.PASSED));
        });
        return new DatabaseStatementResult("result");
    }
}
