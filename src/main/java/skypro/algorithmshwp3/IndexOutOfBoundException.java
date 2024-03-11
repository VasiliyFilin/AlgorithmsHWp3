package skypro.algorithmshwp3;

public class IndexOutOfBoundException extends RuntimeException {
    public IndexOutOfBoundException() {
    }

    public IndexOutOfBoundException(String message) {
        super(message);
    }

    public IndexOutOfBoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutOfBoundException(Throwable cause) {
        super(cause);
    }

    public IndexOutOfBoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
