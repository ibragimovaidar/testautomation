package com.github.ibragimovaidar.testautomationplatform.engine.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VariableAssigment extends Statement {

    private String name;

    private Statement statement;
}
