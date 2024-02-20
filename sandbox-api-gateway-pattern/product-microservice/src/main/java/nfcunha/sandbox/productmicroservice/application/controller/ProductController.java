package nfcunha.sandbox.productmicroservice.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nfcunha.sandbox.productmicroservice.application.service.ProductService;
import nfcunha.sandbox.productmicroservice.data.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduct() {
        final List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createProduct(@RequestBody final Product request) {
        final Product product = productService.createProduct(request);
        return ResponseEntity.ok(product);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody final Product request) {
        final Product product = productService.updateProduct(request);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteProduct(@RequestBody final Product request) {
        final boolean status = productService.deleteProduct(request);
        final Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", status);
        return ResponseEntity.ok(responseBody);
    }


}
