package com.mobile.pickup.model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Vendor {

    private int vendorID;
    private String foodTruckName;
    private int menuID;
    private OperatingHours operatingHours;

    public Vendor() {
    }

    public Vendor(int vendorID, String foodTruckName, int menuID, OperatingHours operatingHours) {
        this.vendorID = vendorID;
        this.foodTruckName = foodTruckName;
        this.menuID = menuID;
        this.operatingHours = operatingHours;
    }

    public int getVendorID() {
        return vendorID;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public int getMenuID() {
        return menuID;
    }

    public OperatingHours getOperatingHours() {
        return operatingHours;
    }
}
