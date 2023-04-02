package za.co.reservation.bookingApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.reservation.bookingApi.model.Client;
import za.co.reservation.bookingApi.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Optional<Client> getById(Long id) {
        return clientRepository.findById(id);
    }
}
