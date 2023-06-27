package models;

import util.FoodKartUtil;

import java.util.Date;

public class Order {

    public String orderID;
    public boolean status;
    public String restaurantName;
    public int quantity;
    public int bill;
    public String orderDate;

    public Order(){}

    public Order(boolean status, String restaurantName, int quantity, int bill) {
        this.orderID = FoodKartUtil.generateNewId();
        this.status = status;
        this.restaurantName = restaurantName;
        this.quantity = quantity;
        this.bill = bill;
        this.orderDate = new Date().toString();
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBill() {
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
