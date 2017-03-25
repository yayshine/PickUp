package com.mobile.pickup.Controller.CustomerSide;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListFragment;
import com.mobile.pickup.Model.CustomerSide.TempOrder;
import com.mobile.pickup.R;

public class OrderActivity extends AppCompatActivity {
    public static final String TAG_VENDOR_LIST = "VENDOR_LIST";
    public static final String TAG_MENU = "MENU";

    public FragmentManager mFragmentManager;
    public static TempOrder mTempOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        mTempOrder = new TempOrder();

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.container, new VendorListFragment())
                .commit();
    }

}
