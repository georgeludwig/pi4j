package org.pi4j.exception;

/**
 * The exception that is thrown when a user is not found.
 */
public class ProfileNotFoundException extends PiException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor with message.
     *
     * @param message Error
     */
    public ProfileNotFoundException(String message) {
        super(message);
    }

    public ProfileNotFoundException(Long kloutId) {
        super("Pi profile not found: " + kloutId);
    }
}
