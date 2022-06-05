package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;

import cambridge.uz.omborxona.payload.SupplierDto;
import cambridge.uz.omborxona.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @GetMapping("/{id}")
    public HttpEntity<?> getSupplierById(@PathVariable Integer id) {
        ApiResponse apiResponse = supplierService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getSupplierAll() {
        ApiResponse apiResponse = supplierService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addSupplier(@RequestBody SupplierDto dto) {
        ApiResponse apiResponse = supplierService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editSupplier(@PathVariable Integer id,@RequestBody SupplierDto dto) {
        ApiResponse apiResponse = supplierService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

}
