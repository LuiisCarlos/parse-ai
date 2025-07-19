package dev.luisworks.parse_ai.service;

import org.springframework.web.multipart.MultipartFile;

import dev.luisworks.parse_ai.dto.DocumentResponse;

public interface DocumentService {

    DocumentResponse upload(MultipartFile multipartFile);

}
