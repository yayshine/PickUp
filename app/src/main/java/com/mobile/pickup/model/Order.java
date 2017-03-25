package com.mobile.pickup.Model;

import java.util.HashMap;
<<<<<<< HEAD
=======
import java.util.Map;
>>>>>>> 7234a3fe07b37d80d1b407c5433e6eabf937e09e

/**
 * Created by Yanqing on 3/23/17.
 */

public class Order {
<<<<<<< HEAD
    private String orderID;
    private String customerID;
    private String vendorID;
    private HashMap<String,Integer> foodItemIDQuantMap;
    private boolean isReady;
=======
    private int orderID = -1;
    private int customerID;
    private int vendorID;
    private Map<Integer, Integer> foodItemQuantityPair = new HashMap<Integer, Integer>();
    private boolean isReady = false;
>>>>>>> 7234a3fe07b37d80d1b407c5433e6eabf937e09e
    private int waitingTime;
    private long timeCreated;

    // empty constructor
    public Order() {
    }

<<<<<<< HEAD
    public Order(String orderID, String customerID, String vendorID,
                 HashMap<String, Integer> foodItemIDQuantMap, boolean isReady,
                 int waitingTime, long timeCreated) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.foodItemIDQuantMap = foodItemIDQuantMap;
=======
    // constructor
    public Order(int orderID, int customerID, int vendorID, Map<Integer, Integer> foodItemQuantityPair, boolean isReady, int waitingTime, long timeCreated) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.vendorID = vendorID;
        this.foodItemQuantityPair = foodItemQuantityPair;
>>>>>>> 7234a3fe07b37d80d1b407c5433e6eabf937e09e
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

<<<<<<< HEAD
    public HashMap<String, Integer> getFoodItemIDQuantMap() {
        return foodItemIDQuantMap;
=======
    public Map<Integer, Integer> getFoodItemQuantityPair(){
        return foodItemQuantityPair;
>>>>>>> 7234a3fe07b37d80d1b407c5433e6eabf937e09e
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
<<<<<<< HEAD
=======

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
>>>>>>> 7234a3fe07b37d80d1b407c5433e6eabf937e09e
}

