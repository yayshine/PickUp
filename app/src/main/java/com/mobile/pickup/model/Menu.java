package com.mobile.pickup2.model;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Menu {
    private String menuID;
    private String vendorID;
    private HashMap<String, Boolean> foodItemIDList;

    public Menu() {
    }

    public Menu(String menuID, String vendorID, HashMap<String, Boolean> foodItemIDList) {
        this.menuID = menuID;
        this.vendorID = vendorID;
        this.foodItemIDList = foodItemIDList;
    }

    public String getMenuID() {
        return menuID;
    }

    public String getVendorID() {
        return vendorID;
    }

    public HashMap<String, Boolean> getFoodItemIDList() {
        return foodItemIDList;
    }
}
