package com.mobile.pickup;

import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mobile.pickup.Model.FoodItem;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Yanqing on 4/5/17.
 */
@RunWith(AndroidJUnit4.class)
public class FoodItemManagerTest {
    // test addFoodItem() and getters of FoodItem class
    @Test
    public void addFoodItem() throws Exception {
        FoodItem tFoodItem = FoodItemManager.addFoodItem("testFood", 2.3f, "test desc");
        assert (tFoodItem.getID() != null);
        assert (tFoodItem.getName().equals("testFood"));
        assert (tFoodItem.getPrice() == 2.3f);
        assert (tFoodItem.getDesc().equals("test desc"));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference foodItemRef = database.getReference("FoodItem");
        foodItemRef.child(tFoodItem.getID()).removeValue();
    }

    // test updateFoodItem() after using addFoodItem() and getters
    @Test
    public void updateFoodItem() throws Exception {
        FoodItem tFoodItem = FoodItemManager.addFoodItem("testFood", 2.3f, "test desc");
        FoodItemManager.updateFoodItem(tFoodItem.getID(), "updatedFoodName", 2.4f, "updated desc");
        assert (tFoodItem.getName().equals("updatedFoodName"));
        assert (tFoodItem.getPrice() == 2.4f);
        assert (tFoodItem.getDesc().equals("updated desc"));

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference foodItemRef = database.getReference("FoodItem");
        foodItemRef.child(tFoodItem.getID()).removeValue();
    }

}