package com.mobile.pickup.Controller.CustomerSide.Review;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListAdapter;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListFragment;
import com.mobile.pickup.Model.CustomerSide.TempOrder;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Order;
import com.mobile.pickup.Model.Vendor;
import com.mobile.pickup.OrderManager;
import com.mobile.pickup.R;

import java.util.HashMap;

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

        Button btn_pay = (Button)rootView.findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TempOrder tempOrder = OrderActivity.mTempOrder;
                Vendor vendor = tempOrder.getVendor();
                HashMap<String, Integer> foodItemIDQuantMap = new HashMap<>();
                for(FoodItem foodItem : tempOrder.getFoodItemQuantMap().keySet()){
                    foodItemIDQuantMap.put(foodItem.getID(), tempOrder.getFoodItemQuantMap().get(foodItem));
                }
                long currentTime = System.currentTimeMillis();

                OrderManager.addOrder("customer", vendor.getID(), foodItemIDQuantMap, 20, currentTime); // dummy data for now

                ((OrderActivity) getActivity()).mFragmentManager.popBackStack(OrderActivity.TAG_VENDOR_LIST, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                ((OrderActivity) getActivity()).mFragmentManager.beginTransaction()
                        .replace(R.id.container, new VendorListFragment())
                        .commit();
            }
        });

        return rootView;
    }

}
