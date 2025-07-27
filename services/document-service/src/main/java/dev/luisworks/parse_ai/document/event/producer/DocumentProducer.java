package dev.luisworks.parse_ai.document.event.producer;

import java.util.Objects;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import dev.luisworks.common.event.DocumentOcrEvent;
import dev.luisworks.common.event.Topics;
import dev.luisworks.parse_ai.document.model.DocumentStatus;
import dev.luisworks.parse_ai.document.service.DocumentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentProducer {

    private final KafkaTemplate<Long, Object> kafkaTemplate;

    private final DocumentService documentService;

    public void sendDocumentOcrRequest(DocumentOcrEvent event) {
        kafkaTemplate.send(Topics.DOCUMENT_OCR_REQUEST, event.documentId(), event.fileUrl())
                .whenComplete((result, ex) -> {
                    if (Objects.nonNull(ex)) {
                        documentService.updateStatus(event.documentId(), DocumentStatus.OCR_IN_PROGRESS);

                        log.info("Event sucessfully sent to topic {} partition {} offset {}",
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    } else {
                        documentService.updateStatus(event.documentId(), DocumentStatus.OCR_FAILED);

                        log.error("Failed to send event to Kafka", ex);
                    }
                });
    }

    public void sendDocumentAiRequest(DocumentOcrEvent event) {
        kafkaTemplate.send(Topics.DOCUMENT_OCR_REQUEST, event.documentId(), event.fileUrl())
                .whenComplete((result, ex) -> {
                    if (Objects.nonNull(ex)) {
                        documentService.updateStatus(event.documentId(), DocumentStatus.OCR_IN_PROGRESS);

                        log.info("Event sucessfully sent to topic {} partition {} offset {}",
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    } else {
                        documentService.updateStatus(event.documentId(), DocumentStatus.OCR_FAILED);

                        log.error("Failed to send event to Kafka", ex);
                    }
                });
    }
}
