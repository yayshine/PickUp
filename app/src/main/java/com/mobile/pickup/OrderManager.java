package com.mobile.pickup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.pickup.Model.Customer;
import com.mobile.pickup.Model.VendorSide.OrderListItem;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Yanqing on 3/25/17.
 */

public class OrderManager {
    private OnOrdersReadListener mListener;

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

    public List<OrderListItem> getAllActiveOrders(final String vendorID){
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        final List<OrderListItem> customerOrders = new ArrayList<>();

        ValueEventListener orderListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot orderSnapshot = dataSnapshot.child("Order");

                for (DataSnapshot child : orderSnapshot.getChildren()) {
                    Order order = child.getValue(Order.class);
                    if (order.getVendorID().equals(vendorID)){
                        Customer customer = dataSnapshot.child("Customer").child(order.getCustomerID()).getValue(Customer.class);
                        String customerName = customer.getCustomerName();
                        Set<String> foodItemIDList = order.getFoodItemIDQuantMap().keySet();
                        for (String foodItemID: foodItemIDList) {
                            HashMap<String, Integer> foodItemNameQuantMap = new HashMap<>();
                            FoodItem foodItem = dataSnapshot.child("FoodItem").child(foodItemID).getValue(FoodItem.class);
                            foodItemNameQuantMap.put(foodItem.getName(), order.getFoodItemIDQuantMap().get(foodItemID));
                            OrderListItem singleDisplayOrder = new OrderListItem(order.getID(), customerName,foodItemNameQuantMap);
                            customerOrders.add(singleDisplayOrder);
                        }
                    }
                }

                mListener.onFinish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("getAllActiveOrders", "Display all orders failed.");
            }
        };
        mDatabaseReference.addValueEventListener(orderListener);
        return customerOrders;
    }

    public void setOnOrdersReadListener(OnOrdersReadListener listener) {
        mListener = listener;
    }

    public interface OnOrdersReadListener{
        void onFinish();
    }
}
