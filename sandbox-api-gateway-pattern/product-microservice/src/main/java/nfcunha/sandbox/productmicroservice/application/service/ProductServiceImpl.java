package nfcunha.sandbox.productmicroservice.application.service;

import java.util.List;
import nfcunha.sandbox.productmicroservice.data.Product;
import nfcunha.sandbox.productmicroservice.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product createProduct(Product productDto) {
        return productRepository.save(productDto);
    }

    @Override
    public Product updateProduct(Product productDto) {
        return productRepository.save(productDto);
    }

    @Override
    public boolean deleteProduct(Product productDto) {
        productRepository.delete(productDto);
        return true;
    }
}
