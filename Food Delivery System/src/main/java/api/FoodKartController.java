package api;

import Exceptions.InvalidSortParamException;
import Exceptions.UserNotFoundException;
import javafx.util.Pair;
import services.OrderService;
import services.RestaurantService;
import services.UserService;
import services.impl.OrderServiceImpl;
import services.impl.RestaurantServiceImpl;
import services.impl.UserServiceImpl;

import java.util.List;

public class FoodKartController {

    UserService userService = UserServiceImpl.INSTANCE;
    RestaurantService restaurantService = RestaurantServiceImpl.INSTANCE;
    OrderService orderService = new OrderServiceImpl();

    public void register_user(String name, String gender, String phoneNo, String location) {
        userService.register_user(name, gender, phoneNo, location);
    }

    public void login_user(String phoneNo) throws UserNotFoundException {
        userService.login_user(phoneNo);
    }

    public void register_restaurant(String restaurantName, String locations, String foodItem, int price, int quantity) {
        restaurantService.register_restaurant(restaurantName, locations, foodItem, price, quantity);
    }

    public void show_restaurant(String sortParam) throws InvalidSortParamException {
        List<Pair<String, String>> restaurantParamList = restaurantService.show_restaurant(sortParam);
        for(Pair<String, String> restaurantNamePair : restaurantParamList) {
            System.out.println(restaurantNamePair.getKey() + ", " + restaurantNamePair.getValue());
        }
    }

    public void place_order(String restaurantName, int quantity) {
        orderService.place_order(restaurantName, quantity);
    }

    public void create_review(String restaurantName, int rating, String comment) {
        restaurantService.create_review(restaurantName,rating,comment);
    }

    public void update_quantity(String restaurantName, int quantity) {
        restaurantService.update_quantity(restaurantName, quantity);
    }

    public void update_location(String restaurantName, String location){
        restaurantService.update_location(restaurantName,location);
    }

    public void order_history(String phoneNo) throws UserNotFoundException {
        orderService.order_history(phoneNo);
    }

}
