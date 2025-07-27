package dev.luisworks.parse_ai.document.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import dev.luisworks.common.util.EnumUtils;
import dev.luisworks.common.util.JsonValuedEnum;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DocumentStatus implements JsonValuedEnum {

    UPLOADED("Uploaded"),

    STORAGE_IN_PROGRESS("Storage in progress"),

    STORAGE_COMPLETED("Storage completed"),

    STORAGE_FAILED("Storage failed"),

    OCR_IN_PROGRESS("OCR in progress"),

    OCR_COMPLETED("OCR completed"),

    OCR_FAILED("OCR failed"),

    AI_IN_PROGRESS("AI in progress"),

    AI_COMPLETED("AI completed"),

    AI_FAILED("AI failed"),

    COMPLETED("Completed"),;

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
