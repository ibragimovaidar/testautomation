package com.github.ibragimovaidar.testautomationplatform.engine.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DatabaseStatementResult extends StatementResult {

    private String result;
}
