package dev.luisworks.parse_ai.document.dto;

import java.util.Map;

import dev.luisworks.parse_ai.document.model.DocumentStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DocumentUploadedResponse {

    private DocumentStatus status;

    private String documentId;

    private String originalFilename;

    private Map<String, String> metadata;

}
