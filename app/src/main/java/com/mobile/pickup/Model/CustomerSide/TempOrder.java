package com.mobile.pickup.Model.CustomerSide;

import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Vendor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yayshin on 3/25/17.
 */

public class TempOrder {
    private Vendor vendor;
    private Map<FoodItem,Integer> foodItemQuantMap = new HashMap<>();

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setFoodItemQuantMap(Map<FoodItem, Integer> foodItemQuantMap) {
        this.foodItemQuantMap = foodItemQuantMap;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public Map<FoodItem, Integer> getFoodItemQuantMap() {
        return foodItemQuantMap;
    }
}
