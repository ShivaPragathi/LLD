package exceptions;

public class AmountInsufficientException extends Exception{
    public AmountInsufficientException() {
        super();
    }
    public AmountInsufficientException(String msg) {
        super(msg);
    }
}
