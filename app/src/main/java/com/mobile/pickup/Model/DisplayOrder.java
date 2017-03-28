package com.mobile.pickup.Model;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/28/17.
 */

public class DisplayOrder {
    private String customerName;
    private HashMap<String, Integer> foodItemNameQuantMap;

    public DisplayOrder() {
    }

    public DisplayOrder(String customerName, HashMap<String, Integer> foodItemNameQuantMap) {
        this.customerName = customerName;
        this.foodItemNameQuantMap = foodItemNameQuantMap;
    }

    public String getCustomerName() {
        return customerName;
    }

    public HashMap<String, Integer> getFoodItemNameQuantMap() {
        return foodItemNameQuantMap;
    }
}
