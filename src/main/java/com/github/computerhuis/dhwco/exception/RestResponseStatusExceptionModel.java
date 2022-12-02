package com.github.computerhuis.dhwco.exception;

import lombok.Getter;

import java.time.OffsetDateTime;

@Getter
public class RestResponseStatusExceptionModel {
    private final OffsetDateTime timestamp;
    private final int status;
    private final String error;
    private final String reason;
    private final String path;

    public RestResponseStatusExceptionModel(final RestResponseStatusException e) {
        timestamp = e.getTimestamp();
        status = e.getStatus();
        error = e.getError();
        reason = e.getReason();
        path = e.getPath();
    }
}
