package com.example.lijiusi.finalproject;


public class Restaurant {
    private int price;
    private String name;
    private String alias;
    Restaurant(final String setName, final int setPrice, final String setAlias) {
        price = setPrice;
        name = setName;
        alias = setAlias;
    }
    public int getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getUrl() {
        return "https://api.yelp.com/v3/businesses/" + alias;
    }
}
