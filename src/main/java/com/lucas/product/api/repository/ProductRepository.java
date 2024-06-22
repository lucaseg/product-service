package com.lucas.product.api.repository;

import com.lucas.product.api.dto.Product;

public interface ProductRepository {
  /**
   * Save a new product.
   *
   * @param product product info to save.
   * @return the product saved.
   * */
  Product save(Product product);

  /**
   * Find a product by its id.
   *
   * @param id the id identifier.
   * @return the product object.
   * */
  Product getById(Long id);

  /**
   * Update an existing product.
   *
   * @param product the new product information.
   * @return the product object updated.
   * */
  Product update(Product product);

  /**
   * Delete a product.
   *
   * @param id the product identifier.
   * */
  void delete(Long id);
}
