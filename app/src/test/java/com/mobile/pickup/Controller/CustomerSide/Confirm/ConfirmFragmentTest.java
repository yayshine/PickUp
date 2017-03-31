package com.mobile.pickup.Controller.CustomerSide.Confirm;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yayshin on 3/30/17.
 */
public class ConfirmFragmentTest {
    ConfirmFragment fragment;

    public ConfirmFragmentTest(){
        super();
        fragment = new ConfirmFragment();
    }

    @Test
    public void genFormattedTimeString() throws Exception {
        long milliseconds = 1490924722488l;
        String expected = "09:45 PM";
        assertEquals(fragment.genFormattedTimeString(milliseconds), expected);
    }
}