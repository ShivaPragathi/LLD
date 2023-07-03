package services;

import exceptions.UserNotFoundException;
import model.User;

import java.util.List;

public interface UserService {

    void registerUser (String name, String email, String phoneNo, int BNPLCredit);

    void viewDues(String user, String duesTillDate);

    void clearDues(String user, List<String> orders, String clearingDate);

    User getUser(String user) throws UserNotFoundException;
}
