package com.lucas.product.api.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.product.api.domain.Product;
import com.lucas.product.api.dto.ProductDto;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MemoryRepositoryTest {

  private final MemoryRepository repository = new MemoryRepository();

  @Test
  void shouldSaveNewProductSuccess() {
    // Given
    Product product = new Product();
    product.setName("Test");
    product.setDescription("Test Description");

    //When
    Product result = repository.save(product);

    // Then
    assertEquals(0, result.getId());
    assertEquals("Test", result.getName());
    assertEquals("Test Description", result.getDescription());
  }

  @Test
  void shouldUpdateWhenSaveTheSameProduct() {
    // Given
    Product firstProduct = new Product();
    firstProduct.setName("Test");
    firstProduct.setDescription("Test Description");

    Product secondProduct = new Product();
    secondProduct.setName("New name");
    secondProduct.setDescription("New description");
    secondProduct.setId(0L);

    //When
    repository.save(firstProduct);
    Product result = repository.save(secondProduct);

    // Then
    assertEquals(0, result.getId());
    assertEquals("New name", result.getName());
    assertEquals("New description", result.getDescription());
  }

  @Test
  void shouldGetProductById() {
    // Given
    Product productN1 = new Product();
    productN1.setName("first");

    Product productN2 = new Product();
    productN2.setName("second");

    repository.save(productN1);
    repository.save(productN2);

    // When
    Product resultN1 = repository.getById(0L).get();
    Product resultN2 = repository.getById(1L).get();

    // Then
    assertEquals("first", resultN1.getName());
    assertEquals("second", resultN2.getName());
  }

  @Test
  void shouldGetEmptyProductWhenTheProductIsNotFound() {
    // When
    Optional<Product> resultProductN1 = repository.getById(0L);

    // Then
    assertTrue(resultProductN1.isEmpty());
  }

  @Test
  void shouldGetProductByName() {
    // Given
    Product product = new Product();
    product.setName("first");

    repository.save(product);

    // When
    Optional<Product> result = repository.getByName(product.getName());

    // Then
    assertFalse(result.isEmpty());
    assertEquals("first", result.get().getName());
  }

  @Test
  void shouldReturnEmptyOptionalGetByName() {
    // When
    Optional<Product> result = repository.getByName("first");

    // Then
    assertTrue(result.isEmpty());
  }

  @Test
  void shouldDeleteProductSuccess() {
    // Given
    Product productDto = new Product();
    productDto.setName("Test");
    productDto.setDescription("Test Description");

    Product sameProductDto = new Product();
    sameProductDto.setName("New name");
    sameProductDto.setDescription("New description");
    sameProductDto.setId(0L);

    repository.save(productDto);
    repository.save(sameProductDto);

    // Assert The product exist
    Optional<Product> firstProduct = repository.getById(0L);
    assertFalse(firstProduct.isEmpty());

    //When
    repository.delete(productDto.getId());

    // Then
    Optional<Product> firstProductDeleted = repository.getById(0L);
    assertTrue(firstProductDeleted.isEmpty());
  }
}