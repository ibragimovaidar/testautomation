package com.github.ibragimovaidar.testautomationplatform.engine.parser.util;

import com.google.gson.reflect.TypeToken;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Type;
import java.util.Map;

@UtilityClass
public class DeserializationTypeUtil {

    public static final Type HTTP_HEADERS_TYPE = new TypeToken<Map<String, Object>>(){}.getType();
}
