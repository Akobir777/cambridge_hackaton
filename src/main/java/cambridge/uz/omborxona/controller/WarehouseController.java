package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.WarehouseDto;
import cambridge.uz.omborxona.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @GetMapping("/{id}")
    public HttpEntity<?> getWarehouseById(@PathVariable Integer id) {
        ApiResponse apiResponse = warehouseService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getWarehouseAll() {
        ApiResponse apiResponse = warehouseService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addWarehouse(@RequestBody WarehouseDto dto) {
        ApiResponse apiResponse = warehouseService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editWarehouse(@PathVariable Integer id,@RequestBody WarehouseDto dto) {
        ApiResponse apiResponse = warehouseService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> editWarehouse(@PathVariable Integer id) {
        ApiResponse apiResponse = warehouseService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
}
