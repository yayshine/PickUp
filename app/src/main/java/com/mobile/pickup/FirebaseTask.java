package com.mobile.pickup;

import com.firebase.client.Firebase;
import com.mobile.pickup.model.Order;

import java.util.List;

/**
 * Created by Yanqing on 3/21/17.
 */

public class FirebaseTask {
    public static final String FIREBASE_URL = "https://pickup-64523.firebaseio.com/";

    // insert an order into database, not working
    public void addOrder(int customerID, int vendorID, List<Integer> foodItemsID, int waitingTime, long timeCreated){
        Firebase ref = new Firebase(FIREBASE_URL);
        Firebase orderRef = ref.child("activeOrders").push();
        Order order = new Order(customerID, vendorID, foodItemsID, false, waitingTime, timeCreated);
        orderRef.setValue(order);
    }

    // get a snapshot for all the active orders

}
