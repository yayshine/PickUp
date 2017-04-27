package com.mobile.pickup;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.pickup.Model.Vendor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yanqing on 3/24/17.
 */

public final class VendorManager {

    private static final String TAG = "VendorManager";
    private OnVendorReadListener mListener;

    public Vendor addVendor(String foodTruckName, String menuID, String operatingHours, boolean isOpen) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        String vendorID = vendorRef.push().getKey();
        Vendor nVendor = new Vendor(vendorID, foodTruckName, menuID, operatingHours, isOpen);
        vendorRef.child(vendorID).setValue(nVendor);

        return nVendor;
    }

    public Vendor getVendor(String vendorID) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        if (vendorRef.child(vendorID).equals(null)) {
            return null;
        }
        else {
            String foodTruckName = vendorRef.child(vendorID).child("foodTruckName").toString();
            String menuID = vendorRef.child(vendorID).child("menuID").toString();
            String operatingHours = vendorRef.child(vendorID).child("operatingHours").toString();
            boolean isOpen = vendorRef.child(vendorID).child("open").toString().equals("true");
            Vendor nVendor = new Vendor(vendorID, foodTruckName, menuID, operatingHours, isOpen);

            return nVendor;
        }
    }

    public Vendor setVendor(String vendorID, String foodTruckName, String menuID, String operatingHours, boolean isOpen){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        Vendor nVendor = new Vendor(vendorID, foodTruckName, menuID, operatingHours, isOpen);
        vendorRef.child(vendorID).setValue(nVendor);

        return nVendor;
    }

    public void updateFoodTruckName(String vendorID, String ftName){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("foodTruckName").setValue(ftName);
    }

    public void updateMenuID(String vendorID, String menuID){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("menuID").setValue(menuID);
    }

    public void updateOperatingHours(String vendorID, String operatingHours){
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("operatingHours").setValue(operatingHours);
    }

    public void updateIsOpen(String vendorID, Boolean isOpen){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");

        vendorRef.child(vendorID).child("isOpen").setValue(isOpen);
    }

    public List<Vendor> getAllVendors(){
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Vendor");
        final List<Vendor> vendors = new ArrayList<>();

        ValueEventListener vendorListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Vendor vendor = child.getValue(Vendor.class);
                    vendors.add(vendor);
                }
                mListener.onFinish();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("getVendors", "Your getAllVendors() failed.");
            }
        };
        mDatabase.addValueEventListener(vendorListener);
        return vendors;
    }

    public void setOnVendorReadListener(OnVendorReadListener listener) {
        mListener = listener;
    }

    public interface OnVendorReadListener{
        void onFinish();
    }
}
