package com.lucas.product.api.repository;

import com.lucas.product.api.domain.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<Product, Long> {

  Optional<Product> findByName(String name);
}
