package dev.luisworks.parse_ai.document.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.luisworks.parse_ai.document.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

}
