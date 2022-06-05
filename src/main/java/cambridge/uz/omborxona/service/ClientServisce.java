package cambridge.uz.omborxona.service;

import cambridge.uz.omborxona.entity.Client;


import cambridge.uz.omborxona.payload.ApiResponse;
import cambridge.uz.omborxona.payload.ClientDto;
import cambridge.uz.omborxona.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServisce {
    @Autowired
    ClientRepository clientRepository;
    public ApiResponse getOne(Integer id) {
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty())
            return new ApiResponse("not found", false);
        return new ApiResponse("mana", true, byId.get());
    }

    public ApiResponse getAll() {
        List<Client> clients = clientRepository.findAll();
        return new ApiResponse("mana", true, clients);
    }

    public ApiResponse add(ClientDto dto) {
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(dto.getPhoneNumber());
        if (existsByPhoneNumber){
            return new ApiResponse("bunday raqam oldin mavjud",false);
        }
        Client client = new Client(dto.getName(), dto.getPhoneNumber());
        Client save = clientRepository.save(client);
        return new ApiResponse("Saqlandi",true,save);
    }

    public ApiResponse edit(Integer id, ClientDto dto) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isEmpty())
            return new ApiResponse("not found", false);
        Client client = optionalClient.get();
        client.setName(dto.getName());
        client.setPhoneNumber(client.getPhoneNumber());
        Client save = clientRepository.save(client);
        return new ApiResponse("Edited",true,save);
    }
}
