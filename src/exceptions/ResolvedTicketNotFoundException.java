package exceptions;

public class ResolvedTicketNotFoundException extends Exception {
    public ResolvedTicketNotFoundException(String message) {
        super(message);
    }
}