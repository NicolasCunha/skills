package nfcunha.sandbox.suppliermicroservice.application.service;

import java.util.List;
import nfcunha.sandbox.suppliermicroservice.data.Supplier;

public interface SupplierService {

    List<Supplier> getSuppliers();

    Supplier createSupplier(Supplier supplier);

    Supplier updateSupplier(Supplier supplier);

    boolean deleteSupplier(Supplier supplier);

}
