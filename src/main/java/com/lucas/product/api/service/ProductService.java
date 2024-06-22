package com.lucas.product.api.service;

import com.lucas.product.api.dto.Product;
import com.lucas.product.api.exception.NotFoundException;
import com.lucas.product.api.repository.ProductRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
  private final ProductRepository repository;

  public Product create(Product product, String caller) {
    LocalDate dateNow = LocalDate.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    product.setDateCreated(dateNow.format(format));
    product.setDateUpdated(dateNow.format(format));
    product.setLastUpdatedBy(caller);

    return repository.save(product);
  }

  public Product update(Long id, Product product, String caller) {
    return repository.update(product);
  }

  public Product findById(Long id) {
    Product product = repository.getById(id);
    if (Objects.isNull(product)) {
      throw new NotFoundException(String.format("Product with id %s not found", id));
    }
    return product;
  }

  public void delete(Long id) {
    repository.delete(id);
  }
}
