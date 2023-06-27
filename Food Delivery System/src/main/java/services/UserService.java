package services;

import Exceptions.UserNotFoundException;
import models.User;

public interface UserService {

    void register_user(String name, String gender, String phoneNo, String location);

    void login_user(String phoneNo) throws UserNotFoundException;

    User getUser(String phoneNo) throws UserNotFoundException;
}
