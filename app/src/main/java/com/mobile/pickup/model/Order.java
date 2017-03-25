package com.mobile.pickup2.model;

import java.util.List;

/**
 * Created by Yanqing on 3/23/17.
 */

public class Order {
    private int orderID;
    private int customerID;
    private int vendorID;
    private List<Integer> foodItemsID;
    private boolean isReady;
    private int waitingTime;
    private long timeCreated;

    // empty constructor
    public Order() {
    }

    // constructor
    public Order(int orderID, int customerID, int vendorID, List<Integer> foodItemsID, boolean isReady, int waitingTime, long timeCreated) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.foodItemsID = foodItemsID;
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

    public List<Integer> getFoodItemsID() {
        return foodItemsID;
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

