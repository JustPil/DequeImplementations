package exceptions;

public class EmptyDequeDequeueException extends RuntimeException {
    /**
     * Constructor uses no error message.
     */
    public EmptyDequeDequeueException() {
        super();
    }

    /**
     * Constructor specifies an error message.
     * @param message The error message.
     */
    public EmptyDequeDequeueException(String message) {
        super(message);
    }
}
