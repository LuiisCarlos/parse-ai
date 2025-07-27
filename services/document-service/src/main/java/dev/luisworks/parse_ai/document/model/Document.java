package dev.luisworks.parse_ai.document.model;

import dev.luisworks.common.util.MetadataConverter;

import java.time.Instant;
import java.util.Map;
import java.util.Set;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PreUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Document {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    private DocumentStatus status;

    @Column(name = "original_filename")
    private String originalFilename;

    @Column(name = "file_url")
    private String fileUrl;

    private Set<String> tags;

    @Builder.Default
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private DocumentAnalysis analysis = new DocumentAnalysis();

    @Column(columnDefinition = "jsonb")
    @Convert(converter = MetadataConverter.class)
    private Map<String, String> metadata;

    @Builder.Default
    @Column(name = "updated_at")
    private Instant updatedAt = Instant.now();

    @Builder.Default
    @Column(name = "processed_at")
    private Instant processedAt = Instant.now();

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = Instant.now();
    }

}
