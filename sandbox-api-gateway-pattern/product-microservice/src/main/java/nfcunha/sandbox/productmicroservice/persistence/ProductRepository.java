package nfcunha.sandbox.productmicroservice.persistence;

import nfcunha.sandbox.productmicroservice.data.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String> {
}
