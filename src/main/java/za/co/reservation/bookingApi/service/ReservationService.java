package za.co.reservation.bookingApi.service;

import za.co.reservation.bookingApi.model.Client;
import za.co.reservation.bookingApi.model.Reservation;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface ReservationService {
    Reservation getReservation(int resId);
    void save(Reservation reservation, Client client) throws Exception;
    void deleteReservation(Long id);

    Collection<Reservation> getReservationsForClient(Client client);

    Collection<Reservation> findAllByRoomAndArrivalDepartureDate(String room, Date arrivalDate, Date departureDate);

}
