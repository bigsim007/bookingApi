package za.co.reservation.bookingApi.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import za.co.reservation.bookingApi.advice.ReservationException;
import za.co.reservation.bookingApi.model.Client;
import za.co.reservation.bookingApi.model.Reservation;
import za.co.reservation.bookingApi.repository.ReservationRepository;

import java.util.Collection;
import java.util.Date;

@Service
public class ReservationServiceImpl implements ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation getReservation(int resId) {
        return reservationRepository.findById(resId);
    }

    @Override
    public void save(Reservation reservation, Client client) throws Exception {

        Collection<Reservation> reservations =findAllByRoomAndArrivalDepartureDate(reservation.getRoom(),reservation.getArrivalDate(),reservation.getDepartureDate());

        if(reservations.isEmpty()) {
            reservation.setClient(client);
            reservationRepository.save(reservation);
        }else {
            throw new Exception("Reservation not available");
        }
    }

    @Override
    public void deleteReservation(Long resId) {
        reservationRepository.deleteById(resId);
    }

    @Override
    public Collection<Reservation> getReservationsForClient(Client client) {
        return reservationRepository.findAllByClient((client));
    }

    @Override
    public Collection<Reservation> findAllByRoomAndArrivalDepartureDate(String room, Date arrivalDate, Date departureDate) {
        return reservationRepository.findAllByRoomAndArrivalDepartureDate(room, arrivalDate, departureDate);
    }


}
