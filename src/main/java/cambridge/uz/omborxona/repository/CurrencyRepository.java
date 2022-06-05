package cambridge.uz.omborxona.repository;

import cambridge.uz.omborxona.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
boolean existsByName(String name);
}
