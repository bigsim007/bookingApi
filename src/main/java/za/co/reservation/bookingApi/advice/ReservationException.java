package za.co.reservation.bookingApi.advice;

public class ReservationException extends Exception {

    private int statusCode;

    public ReservationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
