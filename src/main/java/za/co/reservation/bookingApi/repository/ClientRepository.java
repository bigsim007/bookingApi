package za.co.reservation.bookingApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.reservation.bookingApi.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
