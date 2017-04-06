package com.mobile.pickup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.Customer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Yanqing on 4/5/17.
 */
public class CustomerManagerTest {
    // test addCustomer function and getters of Customer class
    @Test
    public void addCustomer() throws Exception {
        CustomerManager tCustomerManager = new CustomerManager();
        Customer tCustomer = tCustomerManager.addCustomer("tCustomer");
        assert (tCustomer.getID() != null);
        assert (tCustomer.getCustomerName().equals("tCustomer"));
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