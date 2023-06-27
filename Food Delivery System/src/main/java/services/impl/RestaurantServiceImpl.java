package services.impl;

import Exceptions.InvalidSortParamException;
import javafx.util.Pair;
import models.Restaurant;
import models.User;
import services.RestaurantService;
import util.FoodKartUtil;

import java.util.*;
import java.util.stream.Collectors;

public class RestaurantServiceImpl implements RestaurantService {

    public static RestaurantService INSTANCE = new RestaurantServiceImpl();
    private Map<String, Restaurant> restaurantNameMap = new HashMap<>();
    private List<Restaurant> restaurantList = new ArrayList<>();
    private List<String> validSortParams = Arrays.asList("price","rating");
    private RestaurantServiceImpl() {

    }

    @Override
    public void register_restaurant(String restaurantName, String location, String foodItem, int price, int quantity) {
        User loggedInUser = FoodKartUtil.getLoggedInUser();
        Set<String> locations = populateLocations(location);
        Restaurant restaurant = new Restaurant(loggedInUser, restaurantName, locations, foodItem, price, quantity);
        restaurantNameMap.put(restaurantName, restaurant);
        restaurantList.add(restaurant);
    }

    @Override
    public List<Pair<String, String>> show_restaurant(String sortParam) throws InvalidSortParamException {
        if(!validSortParams.contains(sortParam)) {
            throw new InvalidSortParamException("Invalid sort field + "+sortParam);
        }
        List<Pair<String, String>> restaurants = new ArrayList<>();
        if(sortParam.equals("price"))
            restaurantList = restaurantList.stream().sorted((r1,r2)->(r1.price<r2.price?1:-1)).collect(Collectors.toList());
        else
            restaurantList = restaurantList.stream().sorted((r1,r2)->(r1.rating<r2.rating?1:-1)).collect(Collectors.toList());

        for (Restaurant restaurant : restaurantList) {
            restaurants.add(new Pair<>(restaurant.getName(),restaurant.getFoodItem()));
        }
        return restaurants;
    }

    @Override
    public Restaurant getRestaurant(String restaurantName) {
        if(!restaurantNameMap.containsKey(restaurantName)) {
           // throw new RestaurantNotFoundException();
            System.out.println("Restaurant not found");
        }
        return restaurantNameMap.get(restaurantName);
    }

    @Override
    public void create_review(String restaurantName, int rating, String comment) {
        if(!restaurantNameMap.containsKey(restaurantName)) {
            // throw new RestaurantNotFoundException();
            System.out.println("Restaurant not found");
        }
        Restaurant restaurant = restaurantNameMap.get(restaurantName);
        int existingRating = restaurant.getRating();
        restaurant.setRating((existingRating+rating)/2);
        restaurant.getReviews().add(comment);
    }

    @Override
    public void update_quantity(String restaurantName, int quantity) {
        if(!restaurantNameMap.containsKey(restaurantName)) {
            // throw new RestaurantNotFoundException();
            System.out.println("Restaurant not found");
        }
        Restaurant restaurant = restaurantNameMap.get(restaurantName);
        restaurant.setQuantity(restaurant.getQuantity()+quantity);
        System.out.println(restaurantName+", "+restaurant.getLocation()+", "+restaurant.getFoodItem()+" - "+restaurant.getQuantity());
    }

    @Override
    public void update_location(String restaurantName, String location) {
        if(!restaurantNameMap.containsKey(restaurantName)) {
            // throw new RestaurantNotFoundException();
            System.out.println("Restaurant not found");
        }
        Restaurant restaurant = restaurantNameMap.get(restaurantName);
        Set<String> locations = new HashSet<>(Arrays.asList(location.split("/")));
        restaurant.getLocation().addAll(locations);
        System.out.println(restaurantName+", "+restaurant.getLocation()+", "+restaurant.getFoodItem()+" - "+restaurant.getQuantity());
    }

    private Set<String> populateLocations(String location) {
        Set<String> locations;
        String[] s = location.split("/");
        locations = new HashSet<>(Arrays.asList(s));
        return locations;
    }
}
