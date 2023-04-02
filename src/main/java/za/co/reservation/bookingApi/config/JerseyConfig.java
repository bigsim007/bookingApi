package za.co.reservation.bookingApi.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import za.co.reservation.bookingApi.advice.ReservationExceptionMapper;
import za.co.reservation.bookingApi.controller.ReservationController;

import java.util.logging.Logger;

@Configuration
public class JerseyConfig extends ResourceConfig {

     public JerseyConfig(Class<?>... classes){
        register(ReservationController.class);
        register(ReservationExceptionMapper.class);
    }
}
