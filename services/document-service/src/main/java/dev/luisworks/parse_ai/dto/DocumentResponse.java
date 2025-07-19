package dev.luisworks.parse_ai.dto;

import java.time.Instant;
import java.util.Set;
import java.util.Map;

import dev.luisworks.parse_ai.model.DocumentStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DocumentResponse {

    private DocumentStatus status;
    private String documentId;
    private String originalFilename;
    private Set<String> tags;
    private DocumentAnalysis analysis;
    private Map<String, Object> metadata;
    private Instant processedAt;

    @Getter
    @Builder
    public static class DocumentAnalysis {
        private String summary;
        private Map<String, String> keyData;
    }

}
