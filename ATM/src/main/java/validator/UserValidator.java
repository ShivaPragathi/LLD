package validator;

import exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserValidator {

    public static List<String> users = new ArrayList<>();
    public static void doesUserExist(String user) throws UserNotFoundException {
        if(!users.contains(user)) {
            throw new UserNotFoundException("User not found");
        }
    }

}
