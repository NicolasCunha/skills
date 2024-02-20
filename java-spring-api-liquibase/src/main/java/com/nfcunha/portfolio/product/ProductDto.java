package com.nfcunha.portfolio.product;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

  private UUID id;
  private String name;
  private Long quantity;
  private Double price;

}
