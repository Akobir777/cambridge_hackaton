package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Measurement;
import cambridge.uz.omborxona.entity.Supplier;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.SupplierDto;
import cambridge.uz.omborxona.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public ApiResponse getOne(Integer id) {
        Optional<Supplier> optinolSupplier = supplierRepository.findById(id);
        if (optinolSupplier.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, optinolSupplier.get());
    }

    public ApiResponse getAll() {
        List<Supplier> suppliers = supplierRepository.findAll();
        return new ApiResponse("mana", true, suppliers);
    }

    public ApiResponse add(SupplierDto dto) {
        boolean existsByPhoneNumber = supplierRepository.existsByPhoneNumber(dto.getPhoneNumber());
        if (existsByPhoneNumber) {
            return new ApiResponse("bunday raram oldin mavjud", false);
        }
        Supplier supplier = new Supplier(dto.getName(), dto.getPhoneNumber());
        Supplier save = supplierRepository.save(supplier);
        return new ApiResponse("Saqlandi", true, save);

    }

    public ApiResponse edit(Integer id, SupplierDto dto) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (optionalSupplier.isEmpty())
            return new ApiResponse("not found", false);
        Supplier supplier = optionalSupplier.get();
        supplier.setName(dto.getName());
        supplier.setPhoneNumber(supplier.getPhoneNumber());
        Supplier save = supplierRepository.save(supplier);
        return new ApiResponse("Edited",true,save);
    }
}
