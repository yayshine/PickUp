package com.mobile.pickup.Controller.CustomerSide.Review;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListAdapter;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Vendor;
import com.mobile.pickup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ReviewFragment extends Fragment {


    public ReviewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_review, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_review);

        ReviewAdapter adapter = new ReviewAdapter(OrderActivity.mTempOrder.getFoodItemQuantMap().keySet().toArray());
        listView.setAdapter(adapter);

        return rootView;
    }

}
