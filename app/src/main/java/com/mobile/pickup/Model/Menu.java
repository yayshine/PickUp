package com.mobile.pickup.Model;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Menu {
    private String menuID;
    private String vendorID;
    private HashMap<String, Boolean> foodItemIDVisibilityMap;

    public Menu() {
    }

    public Menu(String menuID, String vendorID, HashMap<String, Boolean> foodItemIDVisibilityMap) {
        this.menuID = menuID;
        this.vendorID = vendorID;
        this.foodItemIDVisibilityMap = foodItemIDVisibilityMap;
    }

    public String getMenuID() {
        return menuID;
    }

    public String getVendorID() {
        return vendorID;
    }

    public HashMap<String, Boolean> getFoodItemIDVisibilityMap() {
        return foodItemIDVisibilityMap;
    }
}
