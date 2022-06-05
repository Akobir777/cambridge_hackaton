package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.CurrencyDto;
import cambridge.uz.omborxona.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @GetMapping("/{id}")
    public HttpEntity<?> getCurrencyById(@PathVariable Integer id) {
        ApiResponse apiResponse = currencyService.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getCurrencyAll() {
        ApiResponse apiResponse = currencyService.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addCurrency(@RequestBody CurrencyDto dto) {
        ApiResponse apiResponse = currencyService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editCurrency(@PathVariable Integer id,@RequestBody CurrencyDto dto) {
        ApiResponse apiResponse = currencyService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> editCurrency(@PathVariable Integer id) {
        ApiResponse apiResponse = currencyService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
}
