package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Restaurant {

    public String name;
    public String foodItem;
    public Set<String> location;
    public int price;
    public int quantity;
    public int rating;
    public List<String> reviews;
    public User registeredUser;

    public Restaurant() {}

    public Restaurant(User loggedInUser, String restaurantName, Set<String> locations, String foodItem, int price, int quantity){
        this.setName(restaurantName);
        this.setLocation(locations);
        this.setFoodItem(foodItem);
        this.setPrice(price);
        this.setQuantity(quantity);
        this.setRegisteredUser(loggedInUser);
        this.setRating(0);
        this.setReviews(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(String foodItem) {
        this.foodItem = foodItem;
    }

    public Set<String> getLocation() {
        return location;
    }

    public void setLocation(Set<String> location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public void setReviews(List<String> reviews) {
        this.reviews = reviews;
    }

    public User getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(User registeredUser) {
        this.registeredUser = registeredUser;
    }
}
