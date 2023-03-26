package com.example.musicapp.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException() {
        String message = "duplicate username";
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException() {
        String message = "User not found";
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
