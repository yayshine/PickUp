package com.mobile.pickup.View.CustomerSide.Menu;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;
import com.mobile.pickup.Model.Vendor;
import com.mobile.pickup.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;


import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.internal.util.Checks.checkNotNull;
import static org.hamcrest.EasyMock2Matchers.equalTo;
import static org.hamcrest.Matchers.allOf;

import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by yayshin on 4/7/17.
 */
@RunWith(AndroidJUnit4.class)
public class FoodItemViewTest {
    private Vendor mVendor;
    private final String foodItemName = "Pork Bun";

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            OrderActivity.class);

    @Before
    public void createVendorObject(){
        // creating a vendor profile for Uncle Luoyang
        mVendor = new Vendor("-Kfz4012r7qbR08higRA", "Uncle Luoyang", "-Kg1ftYLPH-D9m4hZcoy", "10:00AM - 6:00PM", true);
    }

    @Test
    public void addEmptySelectionToPreOrder(){
        OrderActivity.mTempOrder.setVendor(mVendor);

        ((OrderActivity)mActivityRule.getActivity()).mFragmentManager.beginTransaction()
                .replace(R.id.container, new MenuFragment())
                .commit();

        waitForSeconds(3000);

        onData(is(instanceOf(FoodItem.class))).inAdapterView(withId(R.id.list_menu))
                .atPosition(0)
                .onChildView(withId(R.id.spinner_quantity))
                .perform(click());

        onData(anything())
                .inRoot(isPlatformPopup())
                .atPosition(0)
                .perform(click());

        onView(withId(R.id.btn_checkout)).perform(click());

        assertEquals(OrderActivity.mTempOrder.getFoodItemQuantMap().isEmpty(), true);
    }

    @Test
    public void addSelectionToPreOrder(){
        OrderActivity.mTempOrder.setVendor(mVendor);

        ((OrderActivity)mActivityRule.getActivity()).mFragmentManager.beginTransaction()
                .replace(R.id.container, new MenuFragment())
                .commit();

        waitForSeconds(3000);

        onData(is(instanceOf(FoodItem.class))).inAdapterView(withId(R.id.list_menu))
                .atPosition(0)
                .onChildView(withId(R.id.spinner_quantity))
                .perform(click());

        int quantity = 5;

        onData(anything())
                .inRoot(isPlatformPopup())
                .atPosition(quantity)
                .perform(click());

        onView(withId(R.id.btn_checkout)).perform(click());

        assertEquals(OrderActivity.mTempOrder.getFoodItemQuantMap().isEmpty(), false);
        assertEquals(OrderActivity.mTempOrder.getFoodItemQuantMap().containsValue(quantity), true);
    }


    private void waitForSeconds(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}