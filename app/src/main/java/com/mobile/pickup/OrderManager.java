package com.mobile.pickup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Order;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/25/17.
 */

public class OrderManager {
    public static Order addOrder(String customerID, String vendorID,
                                 HashMap<String, Integer> foodItemIDQuantMap,
                                 int waitingTime, long timeCreated){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orderRef = database.getReference("Order");

        String orderID = orderRef.push().getKey();
        Order nOrder = new Order(orderID,customerID,vendorID,foodItemIDQuantMap,false,waitingTime,timeCreated);
        orderRef.child(orderID).setValue(nOrder);

        return nOrder;
    }

    public static void updateIsReady(String orderID, Boolean isReady){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orderRef = database.getReference("Order");

        orderRef.child(orderID).child("ready").setValue(isReady);
    }
}
