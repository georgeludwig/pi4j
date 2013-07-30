package org.pi4j.exception;

/**
 * 
 * The root exception for errors encountered while communicating with the Pi API.
 *
 * @see org.pi4j.service.impl.PiImpl
 */
public class PiException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor with message.
	 * @param message Error message
	 */
    public PiException(String message) {
        super(message);
    }

    /**
     * Constructor with message and root cause.
     * @param message Error message
     * @param t Throwable up the stack
     */
    public PiException(String message, Throwable t) {
        super(message, t);
    }
}
