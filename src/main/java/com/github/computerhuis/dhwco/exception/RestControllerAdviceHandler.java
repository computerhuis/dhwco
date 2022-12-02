package com.github.computerhuis.dhwco.exception;

import com.github.computerhuis.dhwco.config.MessageSourceConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

@RequiredArgsConstructor
@RestControllerAdvice
public class RestControllerAdviceHandler {

    private final MessageSourceConfiguration messageSourceConfiguration;

    @ExceptionHandler(RestResponseStatusException.class)
    public ResponseEntity<RestResponseStatusExceptionModel> handleException(final RestResponseStatusException e) {
        return ResponseEntity.status(e.getStatus()).body(new RestResponseStatusExceptionModel(e));
    }

    @ExceptionHandler(MultipartException.class)
    public ResponseEntity<RestResponseStatusExceptionModel> handleException(final MultipartException e) {
        val rest = new RestResponseStatusException(HttpStatus.FORBIDDEN, messageSourceConfiguration.getLabel("Alg.Label.error.bestand.grootte"));
        return ResponseEntity.status(rest.getStatus()).body(new RestResponseStatusExceptionModel(rest));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestResponseStatusExceptionModel> handleException(final MethodArgumentNotValidException e) {
        val validationErrors = new StringBuilder();
        for (val fieldError : e.getBindingResult().getFieldErrors()) {
            validationErrors.append(fieldError.getField());
            validationErrors.append(": ");
            validationErrors.append(fieldError.getDefaultMessage());
            validationErrors.append(". ");
        }
        val error = new RestResponseStatusException(HttpStatus.BAD_REQUEST, validationErrors.toString().trim());
        return ResponseEntity.status(error.getStatus()).body(new RestResponseStatusExceptionModel(error));
    }

}
