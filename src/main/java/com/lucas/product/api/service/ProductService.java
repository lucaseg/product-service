package com.lucas.product.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucas.product.api.domain.Product;
import com.lucas.product.api.dto.ProductDto;
import com.lucas.product.api.exception.NotFoundException;
import com.lucas.product.api.exception.ProductAlreadyExistException;
import com.lucas.product.api.repository.ProductRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {
  private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  private final ProductRepository repository;
  private final ObjectMapper mapper = new ObjectMapper();

  public ProductDto create(ProductDto productDto, String caller) {
    Optional<Product> result = repository.getByName(productDto.getName());
    if (result.isPresent()) {
      throw new ProductAlreadyExistException(String.format("The product %s already exist", productDto.getName()));
    }
    LocalDate dateNow = LocalDate.now();

    productDto.setDateCreated(dateNow.format(dateFormat));
    productDto.setDateUpdated(dateNow.format(dateFormat));
    productDto.setLastUpdatedBy(caller);

    Product product = mapper.convertValue(productDto, Product.class);
    return mapper.convertValue(repository.save(product), ProductDto.class);
  }

  public ProductDto update(Long id, ProductDto productDto, String caller) {
    ProductDto currentProductDto = findById(id);

    if (Objects.isNull(currentProductDto)) {
      throw new NotFoundException(String.format("Product %s not found", productDto.getName()));
    }

    // Update values
    currentProductDto.setName(productDto.getName());
    currentProductDto.setDescription(productDto.getDescription());
    currentProductDto.setPrice(productDto.getPrice());
    currentProductDto.setCategory(productDto.getCategory());
    currentProductDto.setQuantity(productDto.getQuantity());

    LocalDate dateNow = LocalDate.now();
    currentProductDto.setDateUpdated(dateNow.format(dateFormat));
    currentProductDto.setLastUpdatedBy(caller);

    Product product = mapper.convertValue(productDto, Product.class);
    return mapper.convertValue(repository.save(product), ProductDto.class);
  }

  public ProductDto findById(Long id) {
    Optional<Product> product = repository.getById(id);
    Product result = product.orElseThrow(() -> new NotFoundException(String.format("Product with id %s not found", id)));

    return mapper.convertValue(result, ProductDto.class);
  }

  public void delete(Long id) {
    repository.delete(id);
  }

}
