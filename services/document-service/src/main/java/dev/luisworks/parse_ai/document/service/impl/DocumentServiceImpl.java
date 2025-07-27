package dev.luisworks.parse_ai.document.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.luisworks.parse_ai.document.dto.DocumentResponse;
// import dev.luisworks.parse_ai.document.event.producer.DocumentProducer;
import dev.luisworks.parse_ai.document.model.Document;
import dev.luisworks.parse_ai.document.model.DocumentStatus;
import dev.luisworks.parse_ai.document.repository.DocumentRepository;
import dev.luisworks.parse_ai.document.service.DocumentService;
import dev.luisworks.parse_ai.document.service.StorageServiceClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;

    private final StorageServiceClient storageClient;

    // private final DocumentProducer producer;

    @Override
    public DocumentResponse upload(MultipartFile multipartFile) {
        // Some Logic
        /* Document newDocument = new Document();
        newDocument.setOriginalFilename(multipartFile.getOriginalFilename());
        newDocument.setStatus(DocumentStatus.UPLOADED); */

        // Save in database
        /* Document document = repository.save(newDocument); */

        // Send storage request event
        storageClient.uploadFileAsync(multipartFile);

        // // Send ocr/pdf request event
        // DocumentOcrEvent documentOcrEvent = new DocumentOcrEvent(document.getDocumentId(), document.getFileUrl());
        // producer.sendDocumentOcrRequest(documentOcrEvent);

        // // Send ai request event
        // producer.sendDocumentAiRequest(documentOcrEvent);

        return DocumentResponse.builder().originalFilename("correcto todo broski").build();
    }

    @Override
    public Document updateStatus(long id, DocumentStatus status) {
        return repository.findById(id)
                .map(document -> {
                    document.setStatus(status);
                    Document updated = repository.save(document);

                    log.info("Document {} updated successfully with status {}", id, status);
                    return updated;
                })
                .orElseThrow(() -> {
                    log.error("Document registry not found with ID {}", id);
                    return new RuntimeException(String.format("Document registry not found with ID %s", id));
                });
    }

}
