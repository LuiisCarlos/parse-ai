package dev.luisworks.common.response;

import java.time.Instant;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    @Builder.Default
    private Integer status = 500;

    @Builder.Default
    private String error = "Internal Server Error";

    @Builder.Default
    private String message = "An unexpected error occurred";

    @Builder.Default
    private String path = "/";

    @Builder.Default
    private Instant timestamp = Instant.now();

}
