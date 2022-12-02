package com.github.computerhuis.dhwco.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.io.Serial;
import java.time.OffsetDateTime;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@Getter
public class RestResponseStatusException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2748468283071478430L;

    private final OffsetDateTime timestamp;
    private final int status;
    private final String error;
    private final String reason;
    private final String path;

    public RestResponseStatusException(@NonNull final HttpStatus status, final String reason) {
        this.status = status.value();
        this.error = status.getReasonPhrase();
        this.reason = reason;
        this.timestamp = OffsetDateTime.now();
        this.path = lookupPath();
    }

    private String lookupPath() {
        val url = new StringBuilder();
        try {
            val req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

            url.append(req.getRequestURI());
            if (isNotBlank(req.getPathInfo())) {
                url.append(req.getPathInfo());
            }
            if (isNotBlank(req.getQueryString())) {
                url.append("?").append(req.getQueryString());
            }
        } catch (IllegalStateException e) {
            log.warn("IllegalStateException: {}", e.getMessage());
        }
        return url.toString();
    }
}
