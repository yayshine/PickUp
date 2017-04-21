package com.mobile.pickup;

import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Customer;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Yanqing on 4/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class CustomerManagerTest {
    // test addCustomer function and getters of Customer class
    @Test
    public void addCustomer() throws Exception {
        CustomerManager tCustomerManager = new CustomerManager();
        Customer tCustomer = tCustomerManager.addCustomer("tCustomer");
        assert (tCustomer.getID() != null);
        assert (tCustomer.getCustomerName().equals("tCustomer"));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference customerRef = database.getReference("Customer");
        customerRef.child(tCustomer.getID()).removeValue();
    }

    // test removeCustomer function after addCustomer() with raw firebase query
    @Test
    public void removeCustomer() throws Exception {
        CustomerManager tCustomerManager = new CustomerManager();
        Customer tCustomer = tCustomerManager.addCustomer("tCustomer");
        tCustomerManager.removeCustomer(tCustomer.getID());

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference customerRef = database.getReference("Customer");
        assert (customerRef.child(tCustomer.getID()).equals(null));
    }

}