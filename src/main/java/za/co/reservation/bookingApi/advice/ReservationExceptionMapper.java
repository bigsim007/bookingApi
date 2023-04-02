package za.co.reservation.bookingApi.advice;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.springframework.http.HttpStatus;
import za.co.reservation.bookingApi.dto.ErrorMessage;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ReservationExceptionMapper implements ExceptionMapper<ReservationException> {

    @Override
    public Response toResponse(ReservationException ex) {
        ErrorMessage error = new ErrorMessage();
        error.setErrorMessage(ex.getMessage());
        error.setErrorCode(ex.getStatusCode());
        StringWriter stringWriter = new StringWriter();
        ex.printStackTrace(new PrintWriter(stringWriter));
        return Response.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .entity(error).type(MediaType.APPLICATION_JSON).build();
    }
}
