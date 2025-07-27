package dev.luisworks.common.event;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class BaseEvent {

    @Builder.Default
    private String eventId = java.util.UUID.randomUUID().toString();;

    @Builder.Default
    private Instant timestamp = Instant.now();;

    @Builder.Default
    private String sourceService = "unkownn-service";

}
