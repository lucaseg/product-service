package com.lucas.product.api.config;

import com.lucas.product.api.dto.ApiError;
import com.lucas.product.api.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ControllerExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<ApiError> handleNotFoundException(NotFoundException ex) {
    ApiError apiError = new ApiError("not_found", ex.getMessage(), HttpStatus.NOT_FOUND.value());
    return ResponseEntity.status(apiError.getStatus()).body(apiError);
  }
}
