package services;

import exceptions.UserAlreadyExistsException;
import exceptions.UserNotFoundException;
import exceptions.UserNotValidException;
import models.User;
import models.UserRole;
import validator.UserValidator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {

    private static Map<String, UserRole> users = new HashMap<>();
    private static AtomicLong idCounter = new AtomicLong();

    public void validateCustomer(String user) throws UserNotFoundException, UserNotValidException {
        UserValidator.doesUserExist(user);
        if(!users.get(user).equals(UserRole.CUSTOMER)){
            throw new UserNotValidException("User is not customer");
        }
    }

    public void validateBankManager(String user) throws UserNotFoundException, UserNotValidException {
        UserValidator.doesUserExist(user);
        if(!users.get(user).equals(UserRole.MANAGER)){
            throw new UserNotValidException("User is not customer");
        }
    }

    public void validateOperator(String user) throws Exception {
        try {
            UserValidator.doesUserExist(user);
            if (!users.get(user).equals(UserRole.OPERATOR)) {
                throw new UserNotValidException("User is not customer");
            }
        } catch (UserNotFoundException | UserNotValidException e) {
            throw new Exception(e.getMessage());
        }
    }

    public static void addUser(String user, UserRole role) throws UserAlreadyExistsException {
        if(!users.containsKey(user)) {
            users.put(user, role);
            UserValidator.users.add(user);
        }
        else {
            throw new UserAlreadyExistsException("User already exists");
        }
    }

    public User createUser(String name, String email, String imageUrl, String address, String phoneNo) throws UserAlreadyExistsException {
        String id = generateUserId();
        User user = new User(id, name, email, imageUrl, address, phoneNo);
        addUser(name, UserRole.CUSTOMER);
        return user;
    }

    private String generateUserId() {
        return String.valueOf(idCounter.getAndIncrement());
 //       return UUID.randomUUID().toString();
    }
}
