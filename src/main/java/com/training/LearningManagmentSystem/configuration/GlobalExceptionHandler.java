package com.training.LearningManagmentSystem.configuration;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundInDatabaseException.class)
    public ResponseEntity<?> handleNotFoundInDatabaseException(NotFoundInDatabaseException ex){
        return ResponseEntity
                .badRequest().body(
                        ex.getMessage()
                );
    }
}
