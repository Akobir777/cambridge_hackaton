package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Measurement;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.MeasurementDto;
import cambridge.uz.omborxona.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServisce {
    @Autowired
    MeasurementRepository measurementRepository;

    public ApiResponse getOne(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, optionalMeasurement.get());
    }

    public ApiResponse getAll() {
        List<Measurement> measurements = measurementRepository.findAll();

        return new ApiResponse("mana", true, measurements);
    }

    public ApiResponse add(MeasurementDto dto) {
        boolean existsByName = measurementRepository.existsByName(dto.getName());
        if (existsByName){
            return new ApiResponse("bunday nomli oldin mavjud",false);
        }
        Measurement measurement = new Measurement(dto.getName());
        Measurement save = measurementRepository.save(measurement);
        return new ApiResponse("Saqlandi",true,save);
    }

    public ApiResponse edit(Integer id, MeasurementDto dto) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isEmpty()) {
            return new ApiResponse("not found", false);
        }
        Measurement measurement = optionalMeasurement.get();
        measurement.setName(dto.getName());
        Measurement save = measurementRepository.save(measurement);
        return new ApiResponse("Edited", true, save);
    }
}
