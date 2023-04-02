package za.co.reservation.bookingApi.dto;


public class ErrorMessage {

    private int errorCode;
    private String errorMessage;

    public ErrorMessage() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
