package com.mobile.pickup.Model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Customer {
    private String id;
    private String customerName;

    public Customer() {
    }

    public Customer(String id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public String getID() {
        return id;
    }

    public String getCustomerName() {
        return customerName;
    }
}
