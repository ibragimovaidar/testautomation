package com.github.ibragimovaidar.testautomationplatform.engine.exception;

public class TestAutomationPlatformException extends RuntimeException {

    public TestAutomationPlatformException(String message) {
        super(message);
    }

    public TestAutomationPlatformException(String message, Throwable cause) {
        super(message, cause);
    }
}
