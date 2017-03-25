package com.mobile.pickup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Menu;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/24/17.
 */

public class MenuManager {

    public static Menu addMenu(String vendorID, HashMap<String, Boolean> foodItemIDList){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        String menuID = menuRef.push().getKey();
        Menu nMenu = new Menu(menuID, vendorID, foodItemIDList);
        menuRef.child(menuID).setValue(nMenu);

        return nMenu;
    }

    public static void updateVendorID(String menuID, String vendorID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        menuRef.child(menuID).child("vendorID").setValue(vendorID);
    }


    public static void addFoodItem(String menuID, String foodItemID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        menuRef.child(menuID).child("foodItemIDList").child(foodItemID).setValue(true);
    }

    public static void activateFoodItem(String menuID, String foodItemID){
        addFoodItem(menuID,foodItemID);
    }

    public static void deleteFoodItem(String menuID, String foodItemID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");

        menuRef.child(menuID).child("foodItemIDList").child(foodItemID).setValue(false);
    }
}
