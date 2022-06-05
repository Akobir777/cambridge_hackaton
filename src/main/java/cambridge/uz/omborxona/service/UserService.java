package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Client;
import cambridge.uz.omborxona.entity.User;
import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.ClientDto;
import cambridge.uz.omborxona.payload.UserDto;
import cambridge.uz.omborxona.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;
    public ApiResponse getOne(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, byId.get());
    }
    public ApiResponse getAll() {
        List<User> all = userRepository.findAll();
        return new ApiResponse("mana", true, all);
    }

    public ApiResponse add(UserDto dto) {
        boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(dto.getPhoneNumber());
        if (existsByPhoneNumber){
            return new ApiResponse("bunday raqam oldin mavjud",false);
        }
        return new ApiResponse();
    }

    public ApiResponse edit(Integer id, UserDto dto) {
        return null;
    }
}
