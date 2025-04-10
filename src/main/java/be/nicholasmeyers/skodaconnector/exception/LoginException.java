package be.nicholasmeyers.skodaconnector.exception;

public class LoginException extends RuntimeException {
    public LoginException(String message, String loginUrl) {
        super(message + " " + loginUrl);
    }
}
