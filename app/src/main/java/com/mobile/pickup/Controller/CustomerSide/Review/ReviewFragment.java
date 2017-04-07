package com.mobile.pickup.Controller.CustomerSide.Review;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.pickup.Controller.CustomerSide.ConfirmActivity;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListFragment;
import com.mobile.pickup.Model.CustomerSide.TempOrder;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Vendor;
import com.mobile.pickup.OrderManager;
import com.mobile.pickup.PropertyManager;
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
        View rootView = inflater.inflate(R.layout.fragment_c_review, container, false);

        final TempOrder tempOrder = OrderActivity.mTempOrder;

        TextView text_vendor_name = (TextView)rootView.findViewById(R.id.text_vendor_name);
        text_vendor_name.setText("Order from "+tempOrder.getVendor().getFoodTruckName());

        ListView listView = (ListView)rootView.findViewById(R.id.list_review);

        ReviewAdapter adapter = new ReviewAdapter(tempOrder.getFoodItemQuantMap().keySet().toArray());
        listView.setAdapter(adapter);

        TextView text_total_price = (TextView)rootView.findViewById(R.id.text_total_price);
        text_total_price.setText("$ "+ adapter.getTotalPrice());

        Button btn_pay = (Button)rootView.findViewById(R.id.btn_pay);
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String customerId = PropertyManager.getInstance().getID();

                Vendor vendor = tempOrder.getVendor();
                HashMap<String, Integer> foodItemIDQuantMap = new HashMap<>();
                for(FoodItem foodItem : tempOrder.getFoodItemQuantMap().keySet()){
                    foodItemIDQuantMap.put(foodItem.getID(), tempOrder.getFoodItemQuantMap().get(foodItem));
                }
                long currentTime = System.currentTimeMillis();
                int waitingTime = 20;

                OrderActivity.mOrder = OrderManager.addOrder(customerId, vendor.getID(), foodItemIDQuantMap, waitingTime, currentTime); // waiting time dummy data for now

                // navigate to VendorListFragment and reset TempOrder
                ((OrderActivity) getActivity()).mFragmentManager.popBackStack(OrderActivity.TAG_VENDOR_LIST, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                OrderActivity.mTempOrder = new TempOrder();
                ((OrderActivity) getActivity()).mFragmentManager.beginTransaction()
                        .replace(R.id.container, new VendorListFragment())
                        .commit();

                Intent intent = new Intent(getActivity(), ConfirmActivity.class);
                intent.putExtra(ConfirmActivity.TAG_ESTIMATED_TIME, genEstimatedTimeMillisecs(currentTime, waitingTime));
                intent.putExtra(ConfirmActivity.TAG_CURRENT_TIME, currentTime);
                startActivity(intent);

            }
        });

        return rootView;
    }

    long genEstimatedTimeMillisecs(long currentTime, int waitingTimeInMins){
        return currentTime + (waitingTimeInMins * 60000);
    }

}
