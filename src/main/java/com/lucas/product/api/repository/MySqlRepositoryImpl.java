package com.lucas.product.api.repository;

import com.lucas.product.api.domain.Product;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Profile("my-sql")
@Repository
@RequiredArgsConstructor
public class MySqlRepositoryImpl implements ProductRepository {

  private final JpaProductRepository productRepository;

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

  @Override
  public Optional<Product> getById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public Optional<Product> getByName(String name) {
    return productRepository.findByName(name);
  }

  @Override
  public void delete(Long id) {
    productRepository.deleteById(id);
  }
}
