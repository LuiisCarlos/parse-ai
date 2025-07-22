package dev.luisworks.parse_ai.document.service;

import org.springframework.web.multipart.MultipartFile;

import dev.luisworks.parse_ai.document.dto.DocumentResponse;

public interface DocumentService {

    DocumentResponse upload(MultipartFile multipartFile);

}
