package com.mobile.pickup;

import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Order;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/30/17.
 */
@RunWith(AndroidJUnit4.class)
public class OrderManagerTest {
    private HashMap<String, Integer> foodQuantMap = new HashMap<>();
    private Order nOrder;

    // test addOrder() with dummy FoodItem data and using getter from Order class
    @Test
    public void addOrder() throws Exception {
        foodQuantMap.put("-KgII-d38BmwAWPoh-RA",1);
        nOrder = OrderManager.addOrder("Test Customer", "-Kfz4012r7qbR08higRA", foodQuantMap,5, 43555);
        assert (nOrder.getID() != null);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orderRef = database.getReference("Order");
        orderRef.child(nOrder.getID()).removeValue();
    }

    // test updateIsReady() using dummy FoodItem data and using addOrder() and getter from Order class
    @Test
    public void updateIsReady() throws Exception {
        foodQuantMap.put("-KgII-d38BmwAWPoh-RA",1);
        nOrder = OrderManager.addOrder("Test Customer", "-Kfz4012r7qbR08higRA", foodQuantMap,5, 43555);
        OrderManager.updateIsReady(nOrder.getID(), true);
        assert (nOrder.getReady() == true);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference orderRef = database.getReference("Order");
        orderRef.child(nOrder.getID()).removeValue();
    }

}