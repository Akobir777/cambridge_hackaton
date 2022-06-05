package cambridge.uz.omborxona.repository;

import cambridge.uz.omborxona.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    boolean existsByPhoneNumber(String number);
}
