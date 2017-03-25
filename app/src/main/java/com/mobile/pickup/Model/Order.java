package com.mobile.pickup.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yanqing on 3/23/17.
 */

public class Order {
    private String id;
    private String customerID;
    private String vendorID;
    private Map<String,Integer> foodItemIDQuantMap;
    private boolean isReady;
    private int waitingTime;
    private long timeCreated;

    // empty constructor
    public Order() {
    }

    public Order(String id, String customerID, String vendorID,
                 HashMap<String, Integer> foodItemIDQuantMap, boolean isReady,
                 int waitingTime, long timeCreated) {
        this.id = id;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.foodItemIDQuantMap = foodItemIDQuantMap;
        this.isReady = isReady;
        this.waitingTime = waitingTime;
        this.timeCreated = timeCreated;
    }

    public String getID() {
        return id;
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
}

