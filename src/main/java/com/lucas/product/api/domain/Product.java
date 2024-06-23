package com.lucas.product.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Products")
@Getter
@Setter
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String category;
  private String description;
  private int quantity;
  private double price;
  private String dateCreated;
  private String dateUpdated;
  private String lastUpdatedBy;

  public Product() {
  }

  public Product(Long id, String name, String category, String description, int quantity, double price, String dateCreated,
      String dateUpdated, String lastUpdatedBy) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
    this.dateCreated = dateCreated;
    this.dateUpdated = dateUpdated;
    this.lastUpdatedBy = lastUpdatedBy;
  }

}
