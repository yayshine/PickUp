package com.mobile.pickup.Model.VendorSide;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/28/17.
 */

public class OrderListItem {
    private String customerName;
    private HashMap<String, Integer> foodItemNameQuantMap;

    public OrderListItem() {
    }

    public OrderListItem(String customerName, HashMap<String, Integer> foodItemNameQuantMap) {
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
