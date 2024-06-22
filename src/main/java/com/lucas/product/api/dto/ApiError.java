package com.lucas.product.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiError {
  private String code;
  private String message;
  private int status;
}
