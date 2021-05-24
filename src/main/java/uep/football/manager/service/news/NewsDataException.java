package uep.football.manager.service.news;


public class NewsDataException extends RuntimeException {

    public NewsDataException() {
        super();
    }

    public NewsDataException(String message) {
        super(message);
    }

    public NewsDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public NewsDataException(Throwable cause) {
        super(cause);
    }

    protected NewsDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
