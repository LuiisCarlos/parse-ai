package dev.luisworks.parse_ai.document.service;

import org.springframework.web.multipart.MultipartFile;

import dev.luisworks.parse_ai.document.dto.DocumentResponse;
import dev.luisworks.parse_ai.document.model.Document;
import dev.luisworks.parse_ai.document.model.DocumentStatus;

public interface DocumentService {

    DocumentResponse upload(MultipartFile multipartFile);

    Document updateStatus(long id, DocumentStatus status);

}
