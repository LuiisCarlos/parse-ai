package dev.luisworks.parse_ai.document.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import dev.luisworks.common.util.EnumUtils;
import dev.luisworks.common.util.JsonValuedEnum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DocumentStatus implements JsonValuedEnum {

    PROCESSING("Processing"),

    SUCCESS("Success"),

    FAILED("Failed");

    private String value;

    @JsonValue
    public String value() {
        return value;
    }

    @JsonCreator
    public static DocumentStatus fromValue(String value) {
        return EnumUtils.fromValue(DocumentStatus.class, value);
    }

}
