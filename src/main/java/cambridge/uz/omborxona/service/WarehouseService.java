package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Currency;
import cambridge.uz.omborxona.entity.Warehouse;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.WarehouseDto;
import cambridge.uz.omborxona.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse getOne(Integer id) {
        Optional<Warehouse> byId = warehouseRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, byId.get());
    }

    public ApiResponse getAll() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        return new ApiResponse("mana", true, warehouses);
    }

    public ApiResponse add(WarehouseDto dto) {

        boolean existsByName = warehouseRepository.existsByName(dto.getName());
        if (existsByName) {
            return new ApiResponse("bunday warehouse oldin mavjud", false);
        }
        Warehouse warehouse = new Warehouse(dto.getName(), dto.getCapacity());
        Warehouse save = warehouseRepository.save(warehouse);
        return new ApiResponse("Saqlandi", true, save);

    }

    public ApiResponse edit(Integer id, WarehouseDto dto) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("not found", false);
        Warehouse warehouse = optionalWarehouse.get();
        warehouse.setName(dto.getName());
        warehouse.setCapacity(dto.getCapacity());
        Warehouse save = warehouseRepository.save(warehouse);
        return new ApiResponse("Edited", true, save);
    }

    public ApiResponse delete(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (optionalWarehouse.isEmpty())
            return new ApiResponse("not found", false);
        Warehouse warehouse = optionalWarehouse.get();
        warehouse.setActive(false);
        Warehouse save = warehouseRepository.save(warehouse);
        return new ApiResponse("Ochirildi",true,save);
    }
}