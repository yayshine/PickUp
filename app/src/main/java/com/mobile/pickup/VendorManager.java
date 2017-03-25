package com.mobile.pickup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Vendor;

/**
 * Created by Yanqing on 3/24/17.
 */

public final class VendorManager {

    public static Vendor addVendor(String foodTruckName, String menuID, String operatingHours, boolean isOpen){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        String vendorID = vendorRef.push().getKey();
        Vendor nVendor = new Vendor(vendorID, foodTruckName, menuID, operatingHours, isOpen);
        vendorRef.child(vendorID).setValue(nVendor);

        return nVendor;
    }

    public static void updateFoodTruckName(String vendorID, String ftName){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("foodTruckName").setValue(ftName);
    }

    public static void updateMenuID(String vendorID, String menuID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("menuID").setValue(menuID);
    }

    public static void updateOperatingHours(String vendorID, String operatingHours){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("operatingHours").setValue(operatingHours);
    }

    public static void updateIsOpen(String vendorID, Boolean isOpen){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("isOpen").setValue(isOpen);
    }
}
