package model;

import util.BnplUtil;

public class Inventory {

    public String id;
    public String name;
    public int price;
    public int quantity;

    public Inventory(){}

    public Inventory(String name, int price, int quantity) {
        this.id = BnplUtil.generateNewId();
        this.name = name;
        this.price = price;
        this.quantity = quantity;
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
}
