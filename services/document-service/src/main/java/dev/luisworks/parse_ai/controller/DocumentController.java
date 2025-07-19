package dev.luisworks.parse_ai.controller;

import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    @GetMapping
    public ResponseEntity<String> getAll(Pageable pageable) {
        return ResponseEntity.ok("Document-service response");
    }

    @GetMapping("/get")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Document-service response");
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<String> uploadAll(Set<MultipartFile> multiparFile) {

        return null;
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<String> upload(MultipartFile multiparFile) {

        return null;
    }

}
