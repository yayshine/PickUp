package com.mobile.pickup.model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Vendor {

    private String vendorID;
    private String foodTruckName;
    private String menuID;
    private String operatingHours;
    private boolean isOpen;

    public Vendor() {
    }

    public Vendor(String vendorID, String foodTruckName, String menuID, String operatingHours, boolean isOpen) {
        this.vendorID = vendorID;
        this.foodTruckName = foodTruckName;
        this.menuID = menuID;
        this.operatingHours = operatingHours;
        this.isOpen = isOpen;
    }

    public String getVendorID() {
        return vendorID;
    }

    public String getFoodTruckName() {
        return foodTruckName;
    }

    public String getMenuID() {
        return menuID;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public boolean isOpen() {
        return isOpen;
    }
}
