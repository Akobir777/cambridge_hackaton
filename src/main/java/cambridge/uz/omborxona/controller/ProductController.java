package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.ProductDto;
import cambridge.uz.omborxona.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public HttpEntity<?> getProductById(@PathVariable Integer id) {
        ApiResponse apiResponse = productService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getProductAll() {
        ApiResponse apiResponse = productService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addProduct(@RequestBody ProductDto dto) {
        ApiResponse apiResponse = productService.addProduct(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editProduct(@PathVariable Integer id,@RequestBody ProductDto dto) {
        ApiResponse apiResponse = productService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> editProduct(@PathVariable Integer id) {
        ApiResponse apiResponse = productService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
}
