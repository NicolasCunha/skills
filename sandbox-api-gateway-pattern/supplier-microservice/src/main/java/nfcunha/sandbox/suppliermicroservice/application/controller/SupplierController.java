package nfcunha.sandbox.suppliermicroservice.application.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nfcunha.sandbox.suppliermicroservice.application.service.SupplierService;
import nfcunha.sandbox.suppliermicroservice.data.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSuppliers() {
        final List<Supplier> suppliers = supplierService.getSuppliers();
        return ResponseEntity.ok(suppliers);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createSupplier(@RequestBody final Supplier request) {
        final Supplier supplier = supplierService.createSupplier(request);
        return ResponseEntity.ok(supplier);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSupplier(@RequestBody final Supplier request) {
        final Supplier supplier = supplierService.updateSupplier(request);
        return ResponseEntity.ok(supplier);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteSupplier(@RequestBody final Supplier request) {
        final boolean supplier = supplierService.deleteSupplier(request);
        final Map<String, Object> response = new HashMap<>();
        response.put("status", supplier);
        return ResponseEntity.ok(response);
    }

}
