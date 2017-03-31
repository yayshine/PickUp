package com.mobile.pickup;

import com.mobile.pickup.Model.Vendor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yanqing on 3/30/17.
 */
public class VendorManagerTest {
    private Vendor testVendor = new Vendor();
    @Test
    public void addVendor() throws Exception {
        VendorManager vendorManager = new VendorManager();
        testVendor = vendorManager.addVendor("Test Truck", "-Kg1ftYLPH-D9m4hZcoy", "10:00AM - 6:00PM", true);
        assert (testVendor.getID() != null);
    }

    @Test
    public void updateFoodTruckName() throws Exception {
        VendorManager vendorManager = new VendorManager();
        testVendor = vendorManager.addVendor("Test Truck", "-Kg1ftYLPH-D9m4hZcoy", "10:00AM - 6:00PM", true);
        vendorManager.updateFoodTruckName(testVendor.getID(), "Changed Food Truck Name");
        assert (testVendor.getFoodTruckName().equals("Changed Food Truck Name"));
    }

}