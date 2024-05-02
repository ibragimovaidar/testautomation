package com.github.ibragimovaidar.testautomationplatform.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feature {

    private String name;

    private List<Statement> statements = new LinkedList<>();

    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    public void addVariable(VariableAssigment variable) {
        this.statements.add(variable);
    }

    public void addAssertion(Assertion assertion) {
        this.statements.add(assertion);
    }
}
