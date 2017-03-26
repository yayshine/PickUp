package com.mobile.pickup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by Yanqing on 3/24/17.
 */

public class MenuManager {
    private OnFoodItemsReadListener mListener;

    public Menu addMenu(String vendorID, HashMap<String, Boolean> foodItemIDList){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        String menuID = menuRef.push().getKey();
        Menu nMenu = new Menu(menuID, vendorID, foodItemIDList);
        menuRef.child(menuID).setValue(nMenu);

        return nMenu;
    }

    public void updateVendorID(String menuID, String vendorID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        menuRef.child(menuID).child("vendorID").setValue(vendorID);
    }


    public void addFoodItem(String menuID, String foodItemID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        menuRef.child(menuID).child("foodItemIDList").child(foodItemID).setValue(true);
    }

    public void activateFoodItem(String menuID, String foodItemID){
        addFoodItem(menuID,foodItemID);
    }

    public void deleteFoodItem(String menuID, String foodItemID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        menuRef.child(menuID).child("foodItemIDList").child(foodItemID).setValue(false);
    }

    public List<FoodItem> getAllFoodItems(final String menuID){
        DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        final List<FoodItem> foodItems = new ArrayList<>();

        ValueEventListener menuListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Menu menu = dataSnapshot.child("Menu").child(menuID).getValue(Menu.class);

                Set<String> foodItemIDList = menu.getFoodItemIDVisibilityMap().keySet();
                for(String foodItemID : foodItemIDList){
                    if(menu.getFoodItemIDVisibilityMap().get(foodItemID) == true){
                        FoodItem foodItem = dataSnapshot.child("FoodItem").child(foodItemID).getValue(FoodItem.class);
                        foodItems.add(foodItem);
                    }
                }
                mListener.onFinish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("getMenu", "Display menu failed.");
            }
        };
        mDatabaseReference.addValueEventListener(menuListener);
        return foodItems;
    }

    public void setOnFoodItemsReadListener(OnFoodItemsReadListener listener) {
        mListener = listener;
    }

    public interface OnFoodItemsReadListener{
        void onFinish();
    }
}
