package com.github.ibragimovaidar.testautomationplatform.engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpStatement extends Statement {

    private String method;

    private String url;

    private Map<String, Object> headers;

    private byte[] body;
}
