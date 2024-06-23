package com.lucas.product.api.repository;

import com.lucas.product.api.domain.Product;
import java.util.Optional;

public interface ProductRepository {
  /**
   * Save a new product.
   *
   * @param productDto product info to save.
   * @return the product saved.
   * */
  Product save(Product productDto);

  /**
   * Find a product by its id.
   *
   * @param id the id identifier.
   * @return the product object.
   */
  Optional<Product> getById(Long id);

  /**
   * Find a product by its id.
   *
   * @param name the name of the product.
   * @return the product object.
   * */
  Optional<Product> getByName(String name);

  /**
   * Delete a product.
   *
   * @param id the product identifier.
   * */
  void delete(Long id);
}
