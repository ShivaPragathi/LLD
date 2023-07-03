package model;

import model.enums.PaymentMode;

import java.util.Date;
import java.util.Map;

public class Order {

    public String orderID;
    public boolean status;
    public PaymentMode paymentMethod;
    public Map<String, Integer> orderDetails;
    public Date purchaseDate;
    public int OrderCost;
    public User orderedByUser;
    public Due orderDue;

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

    public PaymentMode getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMode paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Map<String, Integer> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Map<String, Integer> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getOrderCost() {
        return OrderCost;
    }

    public void setOrderCost(int orderCost) {
        OrderCost = orderCost;
    }

    public User getOrderedByUser() {
        return orderedByUser;
    }

    public void setOrderedByUser(User orderedByUser) {
        this.orderedByUser = orderedByUser;
    }

    public Due getOrderDue() {
        return orderDue;
    }

    public void setOrderDue(Due orderDue) {
        this.orderDue = orderDue;
    }
}
