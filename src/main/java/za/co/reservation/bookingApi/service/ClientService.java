package za.co.reservation.bookingApi.service;

import za.co.reservation.bookingApi.model.Client;

import java.util.Optional;

public interface ClientService {

    Optional<Client> getById(Long id);
}
