package com.mobile.pickup;

import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;
import com.mobile.pickup.Model.Vendor;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Yanqing on 4/5/17.
 */
public class MenuManagerTest {
    @Test
    public void addMenu() throws Exception {
        VendorManager tVendorManager = new VendorManager();
        Vendor tVendor = tVendorManager.addVendor("tFoodTruck", null, "test hour", true);
        HashMap<String, Boolean> tFoodItemIDList = new HashMap<>();
        tFoodItemIDList.put(FoodItemManager.addFoodItem("tFoodItem", 2.3f, "tDesc").getID(), true);
        MenuManager tMenuManager = new MenuManager();
        Menu tMenu = tMenuManager.addMenu(tVendor.getID(), tFoodItemIDList);
        assert (tMenu.getID() != null);
        assert (tMenu.getVendorID().equals(tVendor.getID()));
        assert (tMenu.getFoodItemIDVisibilityMap().equals(tFoodItemIDList));
    }

    @Test
    public void updateVendorID() throws Exception {
        VendorManager tVendorManager = new VendorManager();
        Vendor tVendor = tVendorManager.addVendor("tFoodTruck", null, "test hour", true);
        Vendor tVendor1 = tVendorManager.addVendor("tFoodTruck1", null, "test hour", true);
        HashMap<String, Boolean> tFoodItemIDList = new HashMap<>();
        tFoodItemIDList.put(FoodItemManager.addFoodItem("tFoodItem", 2.3f, "tDesc").getID(), true);
        MenuManager tMenuManager = new MenuManager();
        Menu tMenu = tMenuManager.addMenu(tVendor.getID(), tFoodItemIDList);

        tMenuManager.updateVendorID(tMenu.getID(), tVendor1.getID());
        assert (tMenu.getVendorID().equals(tVendor1.getID()));
    }

    @Test
    public void addFoodItem() throws Exception {
        VendorManager tVendorManager = new VendorManager();
        Vendor tVendor = tVendorManager.addVendor("tFoodTruck", null, "test hour", true);
        Vendor tVendor1 = tVendorManager.addVendor("tFoodTruck1", null, "test hour", true);
        HashMap<String, Boolean> tFoodItemIDList = new HashMap<>();
        tFoodItemIDList.put(FoodItemManager.addFoodItem("tFoodItem", 2.3f, "tDesc").getID(), true);
        MenuManager tMenuManager = new MenuManager();
        Menu tMenu = tMenuManager.addMenu(tVendor.getID(), tFoodItemIDList);
        FoodItem tFoodItem = FoodItemManager.addFoodItem("tFoodItem1", 2.4f, "tDesc1");

        tMenuManager.addFoodItem(tMenu.getID(), tFoodItem.getID());
        assert (tMenu.getFoodItemIDVisibilityMap().containsKey(tFoodItem.getID()) == true);
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == true);
    }

    @Test
    public void activateAndDeleteFoodItem() throws Exception {
        VendorManager tVendorManager = new VendorManager();
        Vendor tVendor = tVendorManager.addVendor("tFoodTruck", null, "test hour", true);
        Vendor tVendor1 = tVendorManager.addVendor("tFoodTruck1", null, "test hour", true);
        HashMap<String, Boolean> tFoodItemIDList = new HashMap<>();
        tFoodItemIDList.put(FoodItemManager.addFoodItem("tFoodItem", 2.3f, "tDesc").getID(), true);
        MenuManager tMenuManager = new MenuManager();
        Menu tMenu = tMenuManager.addMenu(tVendor.getID(), tFoodItemIDList);
        FoodItem tFoodItem = FoodItemManager.addFoodItem("tFoodItem1", 2.4f, "tDesc1");
        tMenuManager.addFoodItem(tMenu.getID(), tFoodItem.getID());

        tMenuManager.deleteFoodItem(tMenu.getID(), tFoodItem.getID());
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == false);

        tMenuManager.activateFoodItem(tMenu.getID(), tFoodItem.getID());
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == true);
    }

}