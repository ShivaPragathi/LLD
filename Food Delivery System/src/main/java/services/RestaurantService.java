package services;

import Exceptions.InvalidSortParamException;
import javafx.util.Pair;
import models.Restaurant;

import java.util.List;

public interface RestaurantService {

    void register_restaurant(String restaurantName, String location, String foodItem, int price, int quantity);

    List<Pair<String, String>> show_restaurant(String sortParam) throws InvalidSortParamException;

    void create_review(String restaurantName, int rating, String comment);

    void update_quantity(String restaurantName, int quantity);

    void update_location(String restaurantName, String location);

    Restaurant getRestaurant(String restaurantName);
}
