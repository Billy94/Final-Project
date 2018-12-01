package com.example.lijiusi.finalproject;

public class Restaurant {
    private int price;
    private String name;
    public Restaurant(final String setName, final int setPrice) {
        price = setPrice;
        name = setName;
    }
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
