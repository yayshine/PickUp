package com.mobile.pickup.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yanqing on 3/23/17.
 */

public class Order {
    private String orderID;
    private String customerID;
    private String vendorID;
    private Map<String,Integer> foodItemIDQuantMap = new HashMap<>();
    private boolean isReady;
    private int waitingTime;
    private long timeCreated;

    // empty constructor
    public Order() {
    }

    public Order(String orderID, String customerID, String vendorID,
                 HashMap<String, Integer> foodItemIDQuantMap, boolean isReady,
                 int waitingTime, long timeCreated) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.foodItemIDQuantMap = foodItemIDQuantMap;
        this.isReady = isReady;
        this.waitingTime = waitingTime;
        this.timeCreated = timeCreated;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getVendorID() {
        return vendorID;
    }

    public Map<String, Integer> getFoodItemIDQuantMap() {
        return foodItemIDQuantMap;
    }

    public boolean isReady() {
        return isReady;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }
}

