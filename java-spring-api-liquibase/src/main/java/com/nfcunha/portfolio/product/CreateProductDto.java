package com.nfcunha.portfolio.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDto {

  private String name;
  private Long quantity;
  private Double price;

}
