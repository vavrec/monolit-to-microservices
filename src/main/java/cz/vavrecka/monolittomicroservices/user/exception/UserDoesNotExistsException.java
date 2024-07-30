package cz.vavrecka.monolittomicroservices.user.exception;

public class UserDoesNotExistsException extends RuntimeException {

    public UserDoesNotExistsException(String message) {
        super(message);
    }

}
