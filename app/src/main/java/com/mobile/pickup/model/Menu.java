package com.mobile.pickup.model;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Menu {
    private int menuID;
    private int vendorID;

    public Menu() {
    }

    public Menu(int menuID, int vendorID) {
        this.menuID = menuID;
        this.vendorID = vendorID;
    }

    public int getMenuID() {
        return menuID;
    }

    public int getVendorID() {
        return vendorID;
    }
}
