package exceptions;

public class UserNotValidException extends Exception{
    public UserNotValidException() {
        super();
    }

    public UserNotValidException(String message) {
        super(message);
    }
}
