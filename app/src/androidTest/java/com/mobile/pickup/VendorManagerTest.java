package com.mobile.pickup;

import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Vendor;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Yanqing on 3/30/17.
 */
@RunWith(AndroidJUnit4.class)
public class VendorManagerTest {
    private Vendor testVendor = new Vendor();
    // test addVendor() using dummy menu data, getter from Vendor class
    @Test
    public void addVendor() throws Exception {
        VendorManager vendorManager = new VendorManager();
        testVendor = vendorManager.addVendor("Test Truck", "-Kg1ftYLPH-D9m4hZcoy", "10:00AM - 6:00PM", true);
        assert (testVendor.getID() != null);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");
        vendorRef.child(testVendor.getID()).removeValue();
    }

    // test updateFoodTruckName() using dummy menu data, addVendor() and getter from Vendor class
    @Test
    public void updateFoodTruckName() throws Exception {
        VendorManager vendorManager = new VendorManager();
        testVendor = vendorManager.addVendor("Test Truck", "-Kg1ftYLPH-D9m4hZcoy", "10:00AM - 6:00PM", true);
        vendorManager.updateFoodTruckName(testVendor.getID(), "Changed Food Truck Name");
        assert (testVendor.getFoodTruckName().equals("Changed Food Truck Name"));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference vendorRef = database.getReference("Vendor");
        vendorRef.child(testVendor.getID()).removeValue();
    }

}