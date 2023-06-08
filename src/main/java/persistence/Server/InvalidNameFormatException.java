package persistence.Server;

public class InvalidNameFormatException extends Exception {
    public InvalidNameFormatException() {}
    public InvalidNameFormatException(String message) {
        super(message);
    }
}
