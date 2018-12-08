package util.epam.first.exception;

public class QuadrangleException extends Exception {
    public QuadrangleException() {
        super();
    }

    public QuadrangleException(String message) {
        super(message);
    }

    public QuadrangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuadrangleException(Throwable cause) {
        super(cause);
    }

    protected QuadrangleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
