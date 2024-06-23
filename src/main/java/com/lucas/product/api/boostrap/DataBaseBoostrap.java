package com.lucas.product.api.boostrap;

import com.lucas.product.api.domain.Product;
import com.lucas.product.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataBaseBoostrap implements CommandLineRunner {

  private final ProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {
    Product product = new Product();
    product.setName("first");
    product.setDescription("first description");

    productRepository.save(product);
    log.info("Data initialized: {}", product.getName());
  }
}
