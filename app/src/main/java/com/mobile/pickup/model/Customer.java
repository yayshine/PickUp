package com.mobile.pickup.model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Customer {
    private String customerID;
    private String customerName;

    public Customer() {
    }

    public Customer(String customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }
}
