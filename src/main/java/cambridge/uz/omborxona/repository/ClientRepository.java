package cambridge.uz.omborxona.repository;

import cambridge.uz.omborxona.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository  extends JpaRepository<Client,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);
}
