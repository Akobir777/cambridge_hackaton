package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Currency;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.CurrencyDto;
import cambridge.uz.omborxona.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    final
    CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public ApiResponse getOne(Integer id) {
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, byId.get());
    }

    public ApiResponse getAll() {
        List<Currency> currencies = currencyRepository.findAll();
        return new ApiResponse("mana", true, currencies);
    }

    public ApiResponse add(CurrencyDto dto) {
        boolean existsByName = currencyRepository.existsByName(dto.getName());
        if (existsByName){
            return new ApiResponse("bunday currency oldin mavjud",false);
        }
        Currency currency = new Currency(dto.getName());
        Currency save = currencyRepository.save(currency);
        return new ApiResponse("Saqlandi",true,save);
    }

    public ApiResponse edit(Integer id, CurrencyDto dto) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isEmpty())
            return new ApiResponse("not found", false);
        Currency currency = optionalCurrency.get();
        currency.setName(dto.getName());
        Currency save = currencyRepository.save(currency);
        return new ApiResponse("Edited",true,save);

    }

    public ApiResponse delete(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (optionalCurrency.isEmpty())
            return new ApiResponse("not found", false);
        Currency currency = optionalCurrency.get();
        currency.setActive(false);
        Currency save = currencyRepository.save(currency);
        return new ApiResponse("Ochirildi",true,save);
    }
}
