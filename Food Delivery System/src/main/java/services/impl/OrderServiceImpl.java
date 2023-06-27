package services.impl;

import Exceptions.UserNotFoundException;
import models.Order;
import models.Restaurant;
import models.User;
import services.OrderService;
import services.RestaurantService;
import services.UserService;
import util.FoodKartUtil;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    RestaurantService restaurantService = RestaurantServiceImpl.INSTANCE;
    UserService userService = UserServiceImpl.INSTANCE;
    private Map<String, Order> orderMap = new HashMap<>();

    @Override
    public void place_order(String restaurantName, int quantity) {
        User loggedInUser = FoodKartUtil.getLoggedInUser();
        Restaurant restaurant = restaurantService.getRestaurant(restaurantName);
        Order order = null;
        if(quantity>restaurant.getQuantity()) {
            System.out.println("Cannot place order");
            order = new Order(false, restaurantName, quantity, 0);
        } else {
            System.out.println("Order Placed Successfully.");
            restaurant.setQuantity(restaurant.getQuantity()-quantity);
            order = new Order(true, restaurantName, quantity, quantity*restaurant.getPrice());
        }
        orderMap.put(loggedInUser.phoneNo, order);
        loggedInUser.getOrderList().add(order);
    }

    @Override
    public void order_history(String phoneNo) throws UserNotFoundException {
        User user = userService.getUser(phoneNo);
       for(Order order : user.getOrderList()) {
           System.out.println(order.getRestaurantName() + ", " + order.getQuantity() + ", " + order.isStatus());
       }
    }
}
