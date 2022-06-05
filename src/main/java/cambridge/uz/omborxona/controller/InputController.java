package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.InputDto;
import cambridge.uz.omborxona.service.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    @GetMapping("/{id}")
    public HttpEntity<?> getInputById(@PathVariable Integer id) {
        ApiResponse apiResponse = inputService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getInputAll() {
        ApiResponse apiResponse = inputService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addInput(@RequestBody InputDto dto) {
        ApiResponse apiResponse = inputService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editInput(@PathVariable Integer id,@RequestBody InputDto dto) {
        ApiResponse apiResponse = inputService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> editInput(@PathVariable Integer id) {
        ApiResponse apiResponse = inputService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
}
