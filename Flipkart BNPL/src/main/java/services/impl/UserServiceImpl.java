package services.impl;

import exceptions.UserNotFoundException;
import model.Due;
import model.Order;
import model.User;
import model.enums.DueStatus;
import services.OrderService;
import services.UserService;

import java.util.*;

public class UserServiceImpl implements UserService {

    public static UserService INSTANCE = new UserServiceImpl();
    Map<String, User> userDetailsMap = new HashMap<>();
    public static OrderService orderService = OrderServiceImpl.INSTANCE;

    @Override
    public void registerUser(String name, String email, String phoneNo, int BNPLCredit) {
        User user = new User(name, email, phoneNo,BNPLCredit);
        userDetailsMap.put(name, user);
    }

    @Override
    public void viewDues(String user, String duesTillDate) {
        User user1 = userDetailsMap.get(user);
        List<Order> orders = user1.getOrders();
        List<Order> res = new ArrayList<>();
        for(Order order : orders) {
            if(order.getPurchaseDate().compareTo(new Date(duesTillDate))<0) {
                res.add(order);
            }
        }
    }

    @Override
    public void clearDues(String user, List<String> orders, String clearingDate) {
       User user1 =  userDetailsMap.get(user);
       for(String order : orders) {
            Order order1 = orderService.getOrder(order);
            Due due = new Due();
            due.setAmount(0);
            due.setStatus(DueStatus.DONE);
            due.setClearingDate(new Date(clearingDate));
            order1.setOrderDue(due);
       }
    }

    @Override
    public User getUser(String user) throws UserNotFoundException {
        if(!userDetailsMap.containsKey(user)) {
            throw new UserNotFoundException("User with name "+user+" not found");
        } else  {
            return userDetailsMap.get(user);
        }
    }
}
