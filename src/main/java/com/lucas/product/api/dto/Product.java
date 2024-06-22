package com.lucas.product.api.dto;

import java.util.Date;
import lombok.Data;

@Data
public class Product {
  private String name;
  private String category;
  private String description;
  private int quantity;
  private double price;
  private Date dateCreated;
  private Date dateUpdated;
  private String lastUpdatedBy;
}
