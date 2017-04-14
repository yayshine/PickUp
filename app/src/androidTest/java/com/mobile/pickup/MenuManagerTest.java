package com.mobile.pickup;

import android.provider.ContactsContract;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;
import com.mobile.pickup.Model.Vendor;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by Yanqing on 4/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class MenuManagerTest {
    // test addMenu() after using addVendor() from VendorManager Module
    // and getters from Menu and Vendor class
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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");
        DatabaseReference vendorRef = database.getReference("Vendor");
        menuRef.child(tMenu.getID()).removeValue();
        vendorRef.child(tVendor.getID()).removeValue();
    }

    // test updateVendorID() after using addVendor() and getters from Menu and Vendor class
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

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");
        DatabaseReference vendorRef = database.getReference("Vendor");
        menuRef.child(tMenu.getID()).removeValue();
        vendorRef.child(tVendor.getID()).removeValue();
        vendorRef.child(tVendor1.getID()).removeValue();
    }

    // test addFoodItem() using all above methods and getters
    @Test
    public void addFoodItem() throws Exception {
        VendorManager tVendorManager = new VendorManager();
        Vendor tVendor = tVendorManager.addVendor("tFoodTruck", null, "test hour", true);
        HashMap<String, Boolean> tFoodItemIDList = new HashMap<>();
        FoodItem tFoodItem1 = FoodItemManager.addFoodItem("tFoodItem", 2.3f, "tDesc");
        tFoodItemIDList.put(tFoodItem1.getID(), true);
        MenuManager tMenuManager = new MenuManager();
        Menu tMenu = tMenuManager.addMenu(tVendor.getID(), tFoodItemIDList);
        FoodItem tFoodItem = FoodItemManager.addFoodItem("tFoodItem1", 2.4f, "tDesc1");
        tMenuManager.addFoodItem(tMenu.getID(), tFoodItem.getID());

        assert (tMenu.getFoodItemIDVisibilityMap().containsKey(tFoodItem.getID()) == true);
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == true);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");
        DatabaseReference vendorRef = database.getReference("Vendor");
        DatabaseReference foodItemRef = database.getReference("FoodItem");
        menuRef.child(tMenu.getID()).removeValue();
        vendorRef.child(tVendor.getID()).removeValue();
        foodItemRef.child(tFoodItem.getID()).removeValue();
        foodItemRef.child(tFoodItem1.getID()).removeValue();
    }

    // testing deleteFoodItem() and activateFoodItem()
    // by deleting first and then add back
    @Test
    public void activateAndDeleteFoodItem() throws Exception {
        VendorManager tVendorManager = new VendorManager();
        Vendor tVendor = tVendorManager.addVendor("tFoodTruck", null, "test hour", true);
        HashMap<String, Boolean> tFoodItemIDList = new HashMap<>();
        FoodItem tFoodItem1 = FoodItemManager.addFoodItem("tFoodItem", 2.3f, "tDesc");
        tFoodItemIDList.put(tFoodItem1.getID(), true);
        MenuManager tMenuManager = new MenuManager();
        Menu tMenu = tMenuManager.addMenu(tVendor.getID(), tFoodItemIDList);
        FoodItem tFoodItem = FoodItemManager.addFoodItem("tFoodItem1", 2.4f, "tDesc1");
        tMenuManager.addFoodItem(tMenu.getID(), tFoodItem.getID());

        tMenuManager.deleteFoodItem(tMenu.getID(), tFoodItem.getID());
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == false);

        tMenuManager.activateFoodItem(tMenu.getID(), tFoodItem.getID());
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == true);

        tMenuManager.deleteFoodItem(tMenu.getID(), tFoodItem.getID());
        assert (tMenu.getFoodItemIDVisibilityMap().get(tFoodItem.getID()) == false);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference menuRef = database.getReference("Menu");
        DatabaseReference vendorRef = database.getReference("Vendor");
        DatabaseReference foodItemRef = database.getReference("FoodItem");
        menuRef.child(tMenu.getID()).removeValue();
        vendorRef.child(tVendor.getID()).removeValue();
        foodItemRef.child(tFoodItem.getID()).removeValue();
        foodItemRef.child(tFoodItem1.getID()).removeValue();

    }

}