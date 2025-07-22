package dev.luisworks.parse_ai.document.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.luisworks.parse_ai.document.dto.DocumentResponse;
import dev.luisworks.parse_ai.document.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Override
    public DocumentResponse upload(MultipartFile multipartFile) {
         return null;
    }

}
