package com.lucas.product.api.repository;

import com.lucas.product.api.domain.Product;
import java.util.LinkedHashMap;
import java.util.Optional;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
@Primary
@Profile("in-memory")
public class MemoryRepository implements ProductRepository {

  private final LinkedHashMap<Long, Product> products = new LinkedHashMap<>();

  @Override
  public Product save(Product Product) {
    if (Product.getId() == null) {
      Long id = (long) products.size();
      Product.setId(id);
    }
    products.put(Product.getId(), Product);
    return Product;
  }

  @Override
  public Optional<Product> getByName(String name) {
    return products.values().stream().filter(p -> p.getName().equals(name)).findFirst();
  }

  @Override
  public Optional<Product> getById(Long id) {
    Product Product = products.get(id);
    if (Product == null) {
      return Optional.empty();
    }
    return Optional.of(Product);
  }

  @Override
  public void delete(Long id) {
    products.remove(id);
  }
}
