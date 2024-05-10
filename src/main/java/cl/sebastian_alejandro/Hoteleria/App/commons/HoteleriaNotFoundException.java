package cl.sebastian_alejandro.Hoteleria.App.commons;

public class HoteleriaNotFoundException extends RuntimeException {

    public HoteleriaNotFoundException(String message) {
        super(message);
    }

    public HoteleriaNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HoteleriaNotFoundException(Throwable cause) {
        super(cause);
    }
}
