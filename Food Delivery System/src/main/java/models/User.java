package models;

import util.FoodKartUtil;

import java.util.ArrayList;
import java.util.List;

public class User {

    public String name;
    public String gender;
    public String phoneNo;
    public String location;
    public String id;
    public List<Order> orderList;
    public List<Restaurant> restaurantList;

    public User() {

    }

    public User(String name, String gender, String phoneNo, String location) {
        this.setId(FoodKartUtil.generateNewId());
        this.setName(name);
        this.setGender(gender);
        this.setLocation(location);
        this.setPhoneNo(phoneNo);
        this.setOrderList(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
