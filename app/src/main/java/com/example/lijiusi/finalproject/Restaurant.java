package com.example.lijiusi.finalproject;
import com.yelp.fusion.client.connection.YelpFusionApi;
import com.yelp.fusion.client.connection.YelpFusionApiFactory;
import java.io.*;

public class Restaurant {
    private int price;
    private String name;
    Restaurant(final String setName, final int setPrice) {
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
