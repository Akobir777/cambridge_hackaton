package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.ClientDto;
import cambridge.uz.omborxona.service.ClientServisce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientServisce clientServisce;

    @GetMapping("/{id}")
    public HttpEntity<?> getClientById(@PathVariable Integer id) {
        ApiResponse apiResponse = clientServisce.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getClientAll() {
        ApiResponse apiResponse = clientServisce.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addClient(@RequestBody ClientDto dto) {
        ApiResponse apiResponse = clientServisce.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editClient(@PathVariable Integer id,@RequestBody ClientDto dto) {
        ApiResponse apiResponse = clientServisce.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

}
