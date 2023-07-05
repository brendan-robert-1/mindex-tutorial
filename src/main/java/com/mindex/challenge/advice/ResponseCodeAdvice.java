package com.mindex.challenge.advice;
import com.mindex.challenge.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ResponseCodeAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    // Add additional exception handlers for other response codes

    // HttpStatus.UNAUTHORIZED
    // HttpStatus.FORBIDDEN
    // HttpStatus.CONFLICT
    // HttpStatus.METHOD_NOT_ALLOWED
    // HttpStatus.UNSUPPORTED_MEDIA_TYPE
    // HttpStatus.TOO_MANY_REQUESTS
    // HttpStatus.NOT_IMPLEMENTED
    // HttpStatus.SERVICE_UNAVAILABLE

    // Handle other custom exceptions as needed

}