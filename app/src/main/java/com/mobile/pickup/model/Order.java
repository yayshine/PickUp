package com.mobile.pickup.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yanqing on 3/23/17.
 */

public class Order {
    private int orderID = -1;
    private int customerID;
    private int vendorID;
    private Map<Integer, Integer> foodItemQuantityPair = new HashMap<Integer, Integer>();
    private boolean isReady = false;
    private int waitingTime;
    private long timeCreated;

    // empty constructor
    public Order() {
    }

    // constructor
    public Order(int orderID, int customerID, int vendorID, Map<Integer, Integer> foodItemQuantityPair, boolean isReady, int waitingTime, long timeCreated) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.foodItemQuantityPair = foodItemQuantityPair;
        this.isReady = isReady;
        this.waitingTime = waitingTime;
        this.timeCreated = timeCreated;
    }

    // public getters
    public int getOrderID() { return orderID; }

    public int getCustomerID() {
        return customerID;
    }

    public int getVendorID() {
        return vendorID;
    }

    public Map<Integer, Integer> getFoodItemQuantityPair(){
        return foodItemQuantityPair;
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

    // public setters
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setVendorID(int vendorID) {
        this.vendorID = vendorID;
    }

    public void setFoodItemQuantityPair(Map<Integer, Integer> foodItemQuantityPair) {
        this.foodItemQuantityPair = foodItemQuantityPair;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }
}

