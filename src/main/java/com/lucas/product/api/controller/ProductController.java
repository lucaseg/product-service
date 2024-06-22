package com.lucas.product.api.controller;

import com.lucas.product.api.dto.Product;
import com.lucas.product.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product/api/v1")
@RequiredArgsConstructor
public class ProductController {
  private final ProductService productService;

  @PostMapping("")
  public ResponseEntity<?> createProduct(@RequestBody Product product) {
    var productCreated = productService.create(product);
    return ResponseEntity.ok(productCreated);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getProductById(@PathVariable Long id) {
    var product = productService.findById(id);
    return ResponseEntity.ok(product);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    var productUpdated = productService.update(id, product);
    return ResponseEntity.ok(productUpdated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
    productService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
