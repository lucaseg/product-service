package com.lucas.product.api.service;

import com.lucas.product.api.dto.Product;
import com.lucas.product.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
  private final ProductRepository repository;

  public Product create(Product product) {
    return repository.save(product);
  }

  public Product update(Long id, Product product) {
    return repository.update(product);
  }

  public Product findById(Long id) {
    return repository.getById(id);
  }

  public void delete(Long id) {
    repository.delete(id);
  }
}
