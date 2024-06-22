package com.lucas.product.api.repository;

import com.lucas.product.api.dto.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  @Override
  public Product save(Product product) {
    return null;
  }

  @Override
  public Product getById(Long id) {
    return null;
  }

  @Override
  public Product update(Product product) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
