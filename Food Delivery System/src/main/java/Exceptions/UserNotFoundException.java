package Exceptions;

public class UserNotFoundException extends Exception {

   public UserNotFoundException() {}

    public UserNotFoundException(String message) {
       System.out.println(message);
    }

}
