package za.co.reservation.bookingApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import za.co.reservation.bookingApi.model.Hotel;
import za.co.reservation.bookingApi.repository.HotelRepository;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApiApplication.class, args);
	}

}
