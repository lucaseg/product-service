package com.lucas.product.api.repository;

import com.lucas.product.api.dto.Product;
import java.util.LinkedHashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("Memory")
@Primary
@Slf4j
public class MemoryRepository implements ProductRepository {

  private final LinkedHashMap<Long, Product> products = new LinkedHashMap<>();

  @Override
  public Product save(Product product) {
    Long id = (long) products.size();
    products.putIfAbsent(id, product);
    return product;
  }

  @Override
  public Product getById(Long id) {
    products.get(id);
    return products.get(id);
  }

  @Override
  public Product update(Product product) {
    return null;
  }

  @Override
  public void delete(Long id) {

  }
}
