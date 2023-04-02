package za.co.reservation.bookingApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.reservation.bookingApi.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Long> {
}
