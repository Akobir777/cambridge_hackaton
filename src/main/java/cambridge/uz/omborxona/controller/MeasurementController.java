package cambridge.uz.omborxona.controller;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.MeasurementDto;
import cambridge.uz.omborxona.service.MeasurementServisce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementServisce measurementServisce;

    @GetMapping("/{id}")
    public HttpEntity<?> getMeasurementById(@PathVariable Integer id) {
        ApiResponse apiResponse = measurementServisce.getOne(id);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getMeasuremenAll() {
        ApiResponse apiResponse = measurementServisce.getAll();
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @PostMapping
    public HttpEntity<?> addMeasurement(@RequestBody MeasurementDto dto) {
        ApiResponse apiResponse = measurementServisce.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> editMeasurement(@PathVariable Integer id,@RequestBody MeasurementDto dto) {
        ApiResponse apiResponse = measurementServisce.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

}
