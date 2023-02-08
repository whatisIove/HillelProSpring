package ua.ithillel.hillelprospring.exception;

import java.io.IOException;

public class UserException extends IOException {
    public UserException(final String message) {
        super(message);
    }
}
