package dev.luisworks.common.event;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class Topics {

    public static final String DOCUMENT_STORAGE_REQUEST = "document.storage.request";

    public static final String DOCUMENT_STORAGE_COMPLETED = "document.storage.completed";

    public static final String DOCUMENT_STORAGE_FAILED = "document.storage.failed";

    public static final String DOCUMENT_OCR_REQUEST = "document.ocr.request";

    public static final String DOCUMENT_OCR_COMPLETED = "document.ocr.completed";

    public static final String DOCUMENT_OCR_FAILED = "document.ocr.failed";

    public static final String DOCUMENT_AI_REQUEST = "document.ai.request";

    public static final String DOCUMENT_AI_COMPLETED = "document.ai.completed";

    public static final String DOCUMENT_AI_FAILED = "document.ai.failed";

}
