package cambridge.uz.omborxona.repository;

import cambridge.uz.omborxona.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String number);
}
