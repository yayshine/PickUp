package com.mobile.pickup.View.CustomerSide.VendorList;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mobile.pickup.model.CustomerSide.VendorList.VendorListHeader;
import com.mobile.pickup.R;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListHeaderView extends FrameLayout {
    TextView text_name_label;
    TextView text_wait_time_label;

    public VendorListHeaderView(Context context){
        super(context);

        inflate(getContext(), R.layout.view_vendor_list_header, this);
        text_name_label = (TextView)findViewById(R.id.text_name_label);
        text_wait_time_label = (TextView)findViewById(R.id.text_wait_time_label);
    }

    public void setData(VendorListHeader foodtruck){
        text_name_label.setText(foodtruck.nameLabel);
        text_wait_time_label.setText(foodtruck.waitTimeLabel);
    }
}
