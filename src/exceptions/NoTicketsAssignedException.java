package exceptions;

public class NoTicketsAssignedException extends Exception {
    public NoTicketsAssignedException(String message) {
        super(message);
    }
}