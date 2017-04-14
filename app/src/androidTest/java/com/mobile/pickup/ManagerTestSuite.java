package com.mobile.pickup;
import com.mobile.pickup.CustomerManagerTest;
import com.mobile.pickup.FoodItemManagerTest;
import com.mobile.pickup.MenuManagerTest;
import com.mobile.pickup.OrderManagerTest;
import com.mobile.pickup.VendorManagerTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Yanqing on 4/6/17.
 */

// runs all database tests
@RunWith(Suite.class)
@Suite.SuiteClasses({CustomerManagerTest.class,
        FoodItemManagerTest.class, MenuManagerTest.class,
        OrderManagerTest.class, VendorManagerTest.class})
public class ManagerTestSuite {
}
