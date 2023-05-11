package persistence;

public class InvalidNameFormatException extends Exception {
    public InvalidNameFormatException() {}
    public InvalidNameFormatException(String message) {
        super(message);
    }
}
