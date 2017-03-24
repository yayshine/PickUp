package com.mobile.pickup.Model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class FoodItem {
    private int foodItemID;
    private String name;
    private float price;
    private String desc;

    public FoodItem() {
    }

    public FoodItem(int foodItemID, String name, float price, String desc) {
        this.foodItemID = foodItemID;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public int getFoodItemID() {
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
