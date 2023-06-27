package services.impl;

import Exceptions.UserNotFoundException;
import models.User;
import services.UserService;
import util.FoodKartUtil;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    public static UserService INSTANCE = new UserServiceImpl();
    Map<String, User> userDetailsMap = new HashMap<>();

    private UserServiceImpl(){

    }

    @Override
    public void register_user(String name, String gender, String phoneNo, String location) {
        User user = new User(name, gender, phoneNo, location);
        userDetailsMap.put(phoneNo,user);
    }

    @Override
    public void login_user(String phoneNo) throws UserNotFoundException {
        if(!userDetailsMap.containsKey(phoneNo)) {
            throw new UserNotFoundException("User with phoneNo "+phoneNo+" not found");
        } else  {
            FoodKartUtil.setLoggedInUser(userDetailsMap.get(phoneNo));
        }
    }

    @Override
    public User getUser(String phoneNo) throws UserNotFoundException {
        if(!userDetailsMap.containsKey(phoneNo)) {
            throw new UserNotFoundException("User with phoneNo "+phoneNo+" not found");
        } else  {
            return userDetailsMap.get(phoneNo);
        }
    }

}
