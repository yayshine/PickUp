package com.mobile.pickup.Model;

import java.util.HashMap;

/**
 * Created by Yanqing on 3/24/17.
 */

public class Menu {
    private String id;
    private String vendorID;
    private HashMap<String, Boolean> foodItemIDVisibilityMap;

    public Menu() {
    }

    public Menu(String id, String vendorID, HashMap<String, Boolean> foodItemIDVisibilityMap) {
        this.id = id;
        this.vendorID = vendorID;
        this.foodItemIDVisibilityMap = foodItemIDVisibilityMap;
    }

    public String getID() {
        return id;
    }

    public String getVendorID() {
        return vendorID;
    }

    public HashMap<String, Boolean> getFoodItemIDVisibilityMap() {
        return foodItemIDVisibilityMap;
    }
}
