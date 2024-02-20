package nfcunha.sandbox.suppliermicroservice.application.service;

import java.util.List;
import nfcunha.sandbox.suppliermicroservice.data.Supplier;
import nfcunha.sandbox.suppliermicroservice.persistence.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> getSuppliers() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    @Override
    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier updateSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public boolean deleteSupplier(Supplier supplier) {
        supplierRepository.delete(supplier);
        return true;
    }
}
