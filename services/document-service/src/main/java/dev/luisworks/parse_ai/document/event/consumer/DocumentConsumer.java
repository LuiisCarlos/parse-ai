package dev.luisworks.parse_ai.document.event.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import dev.luisworks.common.event.Topics;
import dev.luisworks.common.event.Groups;
import dev.luisworks.common.dto.DocumentStorageCompletedEvent;

@Service
public class DocumentConsumer {

    @KafkaListener(topics = Topics.DOCUMENT_STORAGE_COMPLETED, groupId = Groups.DOCUMENT_GROUP)
    public void handleStorageCompleted(DocumentStorageCompletedEvent event) {
        System.out.println("bebesitabebelean");
    }

}
