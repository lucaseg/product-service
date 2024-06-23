package com.lucas.product.api.exception;

public class ProductAlreadyExistException extends RuntimeException {

  public ProductAlreadyExistException() {
    super();
  }

  public ProductAlreadyExistException(String message) {
    super(message);
  }
}
