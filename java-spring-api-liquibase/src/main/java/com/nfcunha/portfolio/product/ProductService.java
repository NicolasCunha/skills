package com.nfcunha.portfolio.product;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductService(final ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<ProductDto> getProducts() {
    final List<Product> products = this.productRepository.findAll();

    if (products.isEmpty()) {
      return new LinkedList<>();
    }

    final ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(products, new TypeToken<List<ProductDto>>(){}.getType());
  }

  public ProductDto createProduct(final CreateProductDto createProductDto) {
    final Product product = Product.builder()
        .name(createProductDto.getName())
        .quantity(createProductDto.getQuantity())
        .price(createProductDto.getPrice())
        .build();
    return new ModelMapper().map(this.productRepository.save(product), ProductDto.class);
  }


}
