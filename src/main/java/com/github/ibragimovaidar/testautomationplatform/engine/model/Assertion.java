package com.github.ibragimovaidar.testautomationplatform.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Assertion extends Statement {

    private String variableName;

    private List<String> expressions = new ArrayList<>();
}
