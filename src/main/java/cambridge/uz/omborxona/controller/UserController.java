package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.ClientDto;
import cambridge.uz.omborxona.payload.UserDto;
import cambridge.uz.omborxona.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public HttpEntity<?> getUserById(@PathVariable Integer id) {
        ApiResponse apiResponse = userService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getUserAll() {
        ApiResponse apiResponse = userService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addUser(@RequestBody UserDto dto) {
        ApiResponse apiResponse = userService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editUser(@PathVariable Integer id,@RequestBody UserDto dto) {
        ApiResponse apiResponse = userService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

}
