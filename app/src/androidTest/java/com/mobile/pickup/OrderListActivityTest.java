package com.mobile.pickup;

import android.os.SystemClock;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.mobile.pickup.Controller.CustomerSide.TempLoginActivity;
import com.mobile.pickup.Controller.VendorSide.OrderListActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Steven on 4/7/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class OrderListActivityTest
{
    @Rule public final ActivityRule<OrderListActivity> main = new ActivityRule<>(OrderListActivity.class);

    @Test
    public void launchMainScreen()
    {
        //onView(withId(R.id.ordersView)).check(matches(isDisplayed()));
        SystemClock.sleep(500);
        //onView(withId(R.id.done_button),withText("ef")).perform(click());
        //onView(allOf(withId(R.id.done_button), withText("Order#38: hi"))).perform(click());

        /*onData(withId(R.id.done_button))
                .onChildView(withText("Fried Chicken Slice x5"))
                .perform(click());

                //getting same error: Error performing 'load adapter data' on view 'Animations or transitions are enabled on the target devic
                */

        /*onData(withId(R.id.done_button))
                .inAdapterView(withId(R.id.order_list_view))
                .onChildView(withId(R.id.order_list_view_item))
                .atPosition(0)
                .perform(click());

                     //getting the same error as the commented block above this one
                     //Error performing 'load adapter data' on view 'Animations or transitions are enabled on the target devic

                */
        //onData(withId(R.id.done_button)).atPosition(0).perform(click());
    }
    //ListView{id=2131558559, res-name=order_list_view
    //ImageButton{id=2131558614, res-name=done_button
}
