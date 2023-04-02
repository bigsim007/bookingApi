package za.co.reservation.bookingApi;

import jakarta.ws.rs.core.MediaType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookingApiApplicationTests {

	private static String GET_RESERVATION = "/api/booking/reservations/1";
	private static String POST_RESERVATION = "/api/booking/reservations/save/1";
	private static String PUT_RESERVATION = "/api/booking/reservations/update/1";
	private static String DELETE_RESERVATION = "/api/booking/reservations/delete/1";

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getListOfReservation() {
		ResponseEntity<String> entity = this.restTemplate.getForEntity(GET_RESERVATION,
				String.class, Map.of("id", "1"));

		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().toString()).contains("S50");
	}

	@Test
	public void updateReservation (){

		String jobj = " {\n" +
				"            \"room\": \"S50\",\n" +
				"            \"price\": 250,\n" +
				"            \"rooms\": 3,\n" +
				"            \"persons\": 2,\n" +
				"            \"children\": 2,\n" +
				"            \"openBuffet\": \"Y\",\n" +
				"            \"arrivalDate\": \"2023-04-08T22:00:00.000+00:00\",\n" +
				"            \"stayDays\": 7\n" +
				"        }";
		this.restTemplate.put(PUT_RESERVATION,
				jobj);

	}

}
