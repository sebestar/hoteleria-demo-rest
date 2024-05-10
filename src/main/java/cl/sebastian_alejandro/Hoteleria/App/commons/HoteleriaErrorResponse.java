package cl.sebastian_alejandro.Hoteleria.App.commons;

public class HoteleriaErrorResponse {

    private int error;
    private String message;
    private long timestamp;

    public HoteleriaErrorResponse() {
    }

    public HoteleriaErrorResponse(int error, String message, long timestamp) {
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "HoteleriaErrorResponse{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
