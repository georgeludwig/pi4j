package org.pi4j.exception;

/**
 * The exception that is thrown when a Pi ID is not found.
 * Pi ID can be found using several methods (@link org.pi4j.model.IdentityType)
 * Every other kind of info (Pi score, Topic etc.) requires Pi ID.
 * Pi IDs are not subject to change and can be stored indefinitely. It is advised to do so if you make a lot
 * of Pi API calls.
 */
public class IdentityNotFoundException extends PiException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor with message.
     *
     * @param message Error
     */
    public IdentityNotFoundException(String message) {
        super(message);
    }

    public IdentityNotFoundException(Object identity) {
        super("Pi ID not found by identity: " + identity);
    }
}
