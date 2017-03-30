package com.mobile.pickup;

import android.app.Application;
import android.content.Context;

/**
 * Created by yayshin on 3/30/17.
 */

public class PickUpApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}


