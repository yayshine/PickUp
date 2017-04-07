package com.mobile.pickup.Controller.CustomerSide.Review;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.CustomerManager;
import com.mobile.pickup.Model.Customer;
import com.mobile.pickup.Model.CustomerSide.TempOrder;
import com.mobile.pickup.Model.Order;
import com.mobile.pickup.Model.Vendor;
import com.mobile.pickup.PropertyManager;
import com.mobile.pickup.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by yayshin on 4/7/17.
 */
@RunWith(AndroidJUnit4.class)
public class ReviewFragmentInstrumentationTest {
    private Vendor mVendor;

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            OrderActivity.class);

    @Before
    public void createNewCustomer(){
        String username = "Yay Shin";
        Customer customer = CustomerManager.addCustomer(username);
        PropertyManager propertyManager = PropertyManager.getInstance();
        propertyManager.setUsername(customer.getCustomerName());
        propertyManager.setID(customer.getID());
    }

    @Before
    public void createVendorObject(){
        // creating a vendor profile for Uncle Luoyang
        mVendor = new Vendor("-Kfz4012r7qbR08higRA", "Uncle Luoyang", "-Kg1ftYLPH-D9m4hZcoy", "10:00AM - 6:00PM", true);
    }

    @Test
    public void generateOrderWithoutSelection(){
        ((OrderActivity)mActivityRule.getActivity()).mFragmentManager.beginTransaction()
                .replace(R.id.container, new ReviewFragment())
                .addToBackStack(OrderActivity.TAG_MENU)
                .commit();

        TempOrder tempOrder = new TempOrder();
        tempOrder.setVendor(mVendor);
        OrderActivity.mTempOrder = tempOrder;

        onView(withId(R.id.btn_pay)).perform(click());
        Order order = OrderActivity.mOrder;
        assert(order.getID() != null);
        assertEquals(order.getCustomerID(), PropertyManager.getInstance().getID());
        assertEquals(order.getVendorID(), mVendor.getID());
        assert(order.getFoodItemIDQuantMap().isEmpty());
    }

    public void generateOrderWithSelection(){

    }
}