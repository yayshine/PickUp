package com.mobile.pickup.Model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Vendor {
    private String id;
    private String foodTruckName;
    private String menuID;
    private String operatingHours;
    private boolean isOpen;

    public Vendor() {
    }

    public Vendor(String id, String foodTruckName, String menuID, String operatingHours, boolean isOpen) {
        this.id = id;
        this.foodTruckName = foodTruckName;
        this.menuID = menuID;
        this.operatingHours = operatingHours;
        this.isOpen = isOpen;
    }

    public String getID() {
        return id;
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
