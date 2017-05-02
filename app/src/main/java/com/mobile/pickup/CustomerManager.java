package com.mobile.pickup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.pickup.Model.Customer;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;

import java.util.Set;

/**
 * Created by Yanqing on 3/30/17.
 */

public class CustomerManager {

    public static Customer addCustomer(String customerName){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference customerRef = database.getReference("Customer");

        String customerID = customerRef.push().getKey();
        Customer nCustomer = new Customer(customerID,customerName);
        customerRef.child(customerID).setValue(nCustomer);

        return nCustomer;
    }

    public static Customer setCustomer(String customerID, String customerName){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference customerRef = database.getReference("Customer");

        Customer nCustomer = new Customer(customerID,customerName);
        customerRef.child(customerID).setValue(nCustomer);

        return nCustomer;
    }

    public static void removeCustomer(String customerID){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference customerRef = database.getReference("Customer");
        customerRef.child(customerID).removeValue();
    }
}
