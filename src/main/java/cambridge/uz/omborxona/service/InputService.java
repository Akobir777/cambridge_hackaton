package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Currency;
import cambridge.uz.omborxona.entity.Input;
import cambridge.uz.omborxona.entity.Supplier;
import cambridge.uz.omborxona.entity.Warehouse;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.InputDto;
import cambridge.uz.omborxona.repository.CurrencyRepository;
import cambridge.uz.omborxona.repository.InputRepository;
import cambridge.uz.omborxona.repository.SupplierRepository;
import cambridge.uz.omborxona.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    CurrencyRepository currencyRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse getOne(Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, byId.get());
    }

    public ApiResponse getAll() {
        List<Input> inputs = inputRepository.findAll();
        return new ApiResponse("mana", true, inputs);
    }

    public ApiResponse add(InputDto dto) {
        Input input = new Input();
        input.setCode(dto.getCode());
        Optional<Currency> optionalCurrency = currencyRepository.findById(dto.getCurrency_id());
        if (optionalCurrency.isEmpty())
            return new ApiResponse("Bunday currnsiy mavjud emas", false);
        input.setCurrency(optionalCurrency.get());
        input.setDate(dto.getDate());
        input.setFactureNumber(dto.getFactureNumber());
        Optional<Supplier> optionalSupplier = supplierRepository.findById(dto.getSupplier_id());
        if (optionalSupplier.isEmpty())
            return new ApiResponse("Bunday currency mavjud emas", false);
        input.setSupplier(optionalSupplier.get());
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(dto.getWarehouse_id());
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Bunday Warehouse mavjud emas", false);
        input.setWarehouse(optionalWarehouse.get());
        Input save = inputRepository.save(input);
        return new ApiResponse("Tayyor", true, save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        inputRepository.deleteById(id);
        return new ApiResponse("Ochirildi", true);
    }

    public ApiResponse edit(Integer id, InputDto dto) {
        Optional<Input> byId = inputRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not fout",false);
        Input input = new Input();
        input.setCode(dto.getCode());
        Optional<Currency> optionalCurrency = currencyRepository.findById(dto.getCurrency_id());
        if (optionalCurrency.isEmpty())
            return new ApiResponse("Bunday currnsiy mavjud emas", false);
        input.setCurrency(optionalCurrency.get());
        input.setDate(dto.getDate());
        input.setFactureNumber(dto.getFactureNumber());
        Optional<Supplier> optionalSupplier = supplierRepository.findById(dto.getSupplier_id());
        if (optionalSupplier.isEmpty())
            return new ApiResponse("Bunday currency mavjud emas", false);
        input.setSupplier(optionalSupplier.get());
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(dto.getWarehouse_id());
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("Bunday Warehouse mavjud emas", false);
        input.setWarehouse(optionalWarehouse.get());
        Input save = inputRepository.save(input);
        return new ApiResponse("Tayyor", true, save);
    }
}
