package com.mobile.pickup.Controller.CustomerSide.Review;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by yayshin on 3/30/17.
 */
public class ReviewFragmentTest {
    ReviewFragment fragment;

    public ReviewFragmentTest(){
        fragment = new ReviewFragment();
    }

    @Test
    public void genEstimatedTimeMillisecs() throws Exception {
        long currentTime = 1490924722488l;
        long estimatedTime = fragment.genEstimatedTimeMillisecs(currentTime, 20);
        Date time = new Date(estimatedTime);
        DateFormat format = new SimpleDateFormat("hh:mm");

        assertEquals(format.format(time), "10:05");
    }
}