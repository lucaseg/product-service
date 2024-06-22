package com.lucas.product.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class ProductRequest {
  @NotBlank
  @Length(min = 1, max = 255)
  private String name;

  @NotBlank
  @Length(min = 1, max = 255)
  private String category;

  @NotBlank
  @Length(min = 10, max = 255)
  private String description;

  @NotNull
  private int quantity;

  @NotNull
  private double price;
}
