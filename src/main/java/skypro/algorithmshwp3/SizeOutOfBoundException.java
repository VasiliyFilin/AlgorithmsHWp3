package skypro.algorithmshwp3;

public class SizeOutOfBoundException extends RuntimeException {
    public SizeOutOfBoundException() {
    }

    public SizeOutOfBoundException(String message) {
        super(message);
    }

    public SizeOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public SizeOutOfBoundException(Throwable cause) {
        super(cause);
    }

    public SizeOutOfBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
