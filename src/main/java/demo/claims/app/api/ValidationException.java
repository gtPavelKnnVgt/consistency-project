package demo.claims.app.api;

public class ValidationException extends RuntimeException {
    private static final String ERR_MSG = "Found errors while trying to validate: %s";

    public ValidationException(String message) {
        super(String.format(ERR_MSG, message));
    }
}
