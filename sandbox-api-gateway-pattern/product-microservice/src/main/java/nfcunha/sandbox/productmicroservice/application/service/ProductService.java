package nfcunha.sandbox.productmicroservice.application.service;

import java.util.List;
import nfcunha.sandbox.productmicroservice.data.Product;

public interface ProductService {

    List<Product> getProducts();

    Product createProduct(Product productDto);

    Product updateProduct(Product productDto);

    boolean deleteProduct(Product productDto);

}
