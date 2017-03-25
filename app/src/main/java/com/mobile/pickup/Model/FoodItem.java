package com.mobile.pickup.Model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class FoodItem {
    private String id;
    private String name;
    private float price;
    private String desc;

    public FoodItem() {
    }

    public FoodItem(String id, String name, float price, String desc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() { return price; }

    public String getDesc() {
        return desc;
    }
}
