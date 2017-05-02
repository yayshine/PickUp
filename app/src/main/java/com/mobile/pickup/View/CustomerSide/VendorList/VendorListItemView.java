package com.mobile.pickup.View.CustomerSide.VendorList;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mobile.pickup.Model.Vendor;

import com.mobile.pickup.R;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListItemView extends FrameLayout {
    TextView text_name;
    TextView text_wait_time;

    public VendorListItemView(Context context){
        super(context);

        inflate(getContext(), R.layout.view_vendor_list_item, this);
        text_name = (TextView)findViewById(R.id.text_name);
        text_wait_time = (TextView)findViewById(R.id.text_wait_time);
    }

    public void setData(Vendor vendor){
        text_name.setText(vendor.getFoodTruckName());
        text_wait_time.setText("20 min"); // dummy wait time for now
    }
}
