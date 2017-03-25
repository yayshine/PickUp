package com.mobile.pickup.model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class FoodItem {
    private String foodItemID;
    private String name;
    private float price;
    private String desc;

    public FoodItem() {
    }

    public FoodItem(String foodItemID, String name, float price, String desc) {
        this.foodItemID = foodItemID;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public String getFoodItemID() {
        return foodItemID;
    }

    public String getName() {
        return name;
    }

    public float getPrice() { return price; }

    public String getDesc() {
        return desc;
    }
}
