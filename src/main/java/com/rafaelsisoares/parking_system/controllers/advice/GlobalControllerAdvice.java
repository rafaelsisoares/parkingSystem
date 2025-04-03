package com.rafaelsisoares.parking_system.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.rafaelsisoares.parking_system.services.exceptions.NotFoundException;

// Classe que centraliza o tratamento de excecoes.
@ControllerAdvice
public class GlobalControllerAdvice {
  @ExceptionHandler
  public ResponseEntity<String> handleNotFound(NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler
  public ResponseEntity<String> handleGenericException(Exception _exception) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Ocorreu um erro inesperado.");
  }
}
