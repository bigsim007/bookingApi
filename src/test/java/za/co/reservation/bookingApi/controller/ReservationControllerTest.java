package za.co.reservation.bookingApi.controller;

//The Booking API would be a hotel booking service that allows you to list, create, update and delete a reservation.

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import za.co.reservation.bookingApi.advice.ReservationException;
import za.co.reservation.bookingApi.model.Client;
import za.co.reservation.bookingApi.model.Reservation;
import za.co.reservation.bookingApi.service.ClientService;
import za.co.reservation.bookingApi.service.ReservationService;

import java.util.Collection;
import java.util.Optional;

@Service
@Path("/api/booking")
public class ReservationControllerTest {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ClientService clientService;

    public ReservationControllerTest() {
    }

    //@Autowired
   // public ReservationController(ReservationService reservationService){
   //     this.reservationService = reservationService;
  //  }

//json : application/json
   @GET
   @Path("/reservations/{userId}")
   @Produces(MediaType.APPLICATION_JSON)
   public ResponseEntity<Collection<Reservation>> getListOfReservation(@PathParam("userId") long userId) throws ReservationException {

        Optional<Client> client =clientService.getById(userId);
        client.orElseThrow(() -> new ReservationException("User does not exist", HttpStatus.NO_CONTENT.value()));

        Collection<Reservation> reservations = reservationService.getReservationsForClient(client.get());

        if(reservations.isEmpty()){
            throw new ReservationException("User does not have any reservations", HttpStatus.NO_CONTENT.value());
        }

        return new ResponseEntity<Collection<Reservation>>(reservations,HttpStatus.OK);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/reservations/save/{userId}")
    public ResponseEntity createReservation(@PathParam("userId") long userId, Reservation reservation) throws ReservationException {

        Optional<Client> client =clientService.getById(userId);
        client.orElseThrow(() -> new ReservationException("User does not exist", HttpStatus.NO_CONTENT.value()));

        try {
            reservationService.save(reservation, client.get());
        }catch (Exception ex) {
            throw new ReservationException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/reservations/update/{userId}")
    public ResponseEntity updateReservation(@PathParam("userId") long userId, Reservation reservation) throws ReservationException{

        Optional<Client> client =clientService.getById(userId);
        client.orElseThrow(() -> new ReservationException("User does not exist", HttpStatus.NO_CONTENT.value()));

        if(reservation.getId()==null || reservation.getId() == 0){
            throw new ReservationException("Id must not be null or zero", HttpStatus.BAD_REQUEST.value());
        }

        try {
            reservationService.save(reservation, client.get());
        }catch (Exception ex) {
            throw new ReservationException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/reservation/delete/{resId}")
    public ResponseEntity deleteReservation(@PathParam("resId") Long resId){

        reservationService.deleteReservation(resId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GET
    @Path("/reservation/{userId}/{resId}")
    public String getReservation(){
        return "Hello from Spring";
    }
}
