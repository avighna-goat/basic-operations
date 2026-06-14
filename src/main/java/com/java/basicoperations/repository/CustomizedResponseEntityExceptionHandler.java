package com.java.basicoperations.repository;

import com.java.basicoperations.entity.ErrorDetails;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(buildErrorDetails(ex.getMessage(), request), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundExceptions(Exception ex, WebRequest request) throws Exception {
        return new ResponseEntity<>(buildErrorDetails(ex.getMessage(), request), HttpStatus.NOT_FOUND);
    }

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        String combinedError = ex.getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(" and "));

        return new ResponseEntity<>(buildErrorDetails(combinedError, request), HttpStatus.BAD_REQUEST);
    }

    private ErrorDetails buildErrorDetails(String message, WebRequest request) {
        return ErrorDetails.builder()
                .timeStamp(LocalDateTime.now())
                .message(message)
                .details(request.getDescription(false))
                .build();
    }
}
