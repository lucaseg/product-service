package com.lucas.product.api.repository;

import com.lucas.product.api.dto.Product;

public interface ProductRepository {
  Product save(Product product);
  Product getById(Long id);
  Product update(Product product);
  void delete(Long id);
}
