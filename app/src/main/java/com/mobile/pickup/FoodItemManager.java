package com.mobile.pickup2;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup2.model.FoodItem;

/**
 * Created by Yanqing on 3/24/17.
 */

public class FoodItemManager {
    public static FoodItem addFoodItem(String name, float price, String desc){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference foodItemRef = database.getReference("FoodItem");

        String foodItemID = foodItemRef.push().getKey();
        FoodItem nFoodItem = new FoodItem(foodItemID, name, price, desc);
        foodItemRef.child(foodItemID).setValue(nFoodItem);

        return nFoodItem;
    }

    public static void updateName(String foodItemID, String name){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference foodItemRef = database.getReference("FoodItem");

        foodItemRef.child(foodItemID).child("name").setValue(name);
    }

    public static void updatePrice(String foodItemID, float price){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference foodItemRef = database.getReference("FoodItem");

        foodItemRef.child(foodItemID).child("price").setValue(price);
    }

    public static void updateDesc(String foodItemID, String desc){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference foodItemRef = database.getReference("FoodItem");

        foodItemRef.child(foodItemID).child("desc").setValue(desc);
    }

    public static void updateFoodItem(String foodItemID, String name, float price, String desc){
        updateName(foodItemID,name);
        updatePrice(foodItemID,price);
        updateDesc(foodItemID,desc);
    }
}
