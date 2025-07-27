package dev.luisworks.parse_ai.document.model;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DocumentAnalysis {

    private String summary;

    private Map<String, String> keyData;

}
