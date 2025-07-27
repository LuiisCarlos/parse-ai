package dev.luisworks.common.dto;

import dev.luisworks.common.event.BaseEvent;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DocumentStorageCompletedEvent extends BaseEvent {

    private long documentId;

    private String storageUrl;

    private String storageProvider;

}
