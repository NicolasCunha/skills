package nfcunha.sandbox.suppliermicroservice.persistence;

import nfcunha.sandbox.suppliermicroservice.data.Supplier;
import org.springframework.data.repository.CrudRepository;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
}
