package dev.luisworks.common.dto;

import dev.luisworks.common.event.BaseEvent;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class DocumentStorageRequestEvent extends BaseEvent {

    private long documentId;

    private String action;

    private String originalFilename;

    private String contentType;

    private long size;

    private String tempFilePath;

    private String userId;

}
