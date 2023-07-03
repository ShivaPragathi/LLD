package model;

import model.enums.UserStatus;
import util.BnplUtil;

import java.util.List;

public class User {

    public String id;
    public String name;
    public String email;
    public String phoneNo;
    public Address address;
    public UserStatus userStatus;
    public int BNPLCredit;
    public List<Order> orders;

    public User(String name, String email, String phoneNo, int bnplCredit) {
        this.id = BnplUtil.generateNewId();
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.BNPLCredit = bnplCredit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public int getBNPLCredit() {
        return BNPLCredit;
    }

    public void setBNPLCredit(int BNPLCredit) {
        this.BNPLCredit = BNPLCredit;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
