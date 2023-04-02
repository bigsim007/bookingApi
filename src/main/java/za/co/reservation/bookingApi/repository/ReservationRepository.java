package za.co.reservation.bookingApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.reservation.bookingApi.model.Client;
import za.co.reservation.bookingApi.model.Reservation;

import java.util.Collection;
import java.util.Date;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation findById(int resId);

    Collection<Reservation> findAllByClient(Client client);

    //SELECT * FROM RESERVATION WHERE ROOM='S50' AND ARRIVAL_DATE BETWEEN '2023-04-09' AND  '2023-04-20';
    //@Query(value = "from EntityClassTable t where yourDate BETWEEN :startDate AND :endDate")
    @Query(value = "FROM Reservation r WHERE room = :room AND arrivalDate BETWEEN :arrivalDate AND :departureDate")
    Collection<Reservation> findAllByRoomAndArrivalDepartureDate(String room, Date arrivalDate, Date departureDate);
}
