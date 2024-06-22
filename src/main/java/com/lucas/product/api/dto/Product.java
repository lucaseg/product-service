package com.lucas.product.api.dto;

import lombok.Data;

@Data
public class Product {
  private String name;
  private String category;
  private String description;
  private int quantity;
  private double price;
  private String dateCreated;
  private String dateUpdated;
  private String lastUpdatedBy;
}
