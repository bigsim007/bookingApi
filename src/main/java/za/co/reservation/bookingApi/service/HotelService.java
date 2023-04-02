package za.co.reservation.bookingApi.service;

import za.co.reservation.bookingApi.model.Hotel;

import java.util.List;

public interface HotelService {

    List<Hotel> getHotels();
    Hotel getById(Long id);
}
