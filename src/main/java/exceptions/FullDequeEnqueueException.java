package exceptions;

public class FullDequeEnqueueException extends RuntimeException {
    /**
     * Constructor uses no error message.
     */
    public FullDequeEnqueueException() {
        super();
    }

    /**
     * Constructor specifies an error message.
     * @param message The error message.
     */
    public FullDequeEnqueueException(String message) {
        super(message);
    }
}
