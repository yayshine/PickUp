package com.mobile.pickup.Controller.CustomerSide.Menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.Review.ReviewFragment;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListAdapter;
import com.mobile.pickup.Model.CustomerSide.VendorList.VendorListHeader;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Order;
import com.mobile.pickup.R;
import com.mobile.pickup.View.CustomerSide.Menu.FoodItemView;

import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    int mVendorId;
    FoodItem[] mMenu;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dummy data for now

        mVendorId = 0;

        mMenu = new FoodItem[3];
        mMenu[0] = new FoodItem(0, "Hot and Sour Soup", 3.45f, "Spicy");
        mMenu[1] = new FoodItem(1, "Minced Beef Chowder", 10.95f, "Minced Beef Chowder");
        mMenu[2] = new FoodItem(2, "Tomato with Egg Drop Soup", 10.50f, "Tomato with Egg Drop Soup");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        final ListView listView = (ListView)rootView.findViewById(R.id.list_menu);

        final MenuAdapter adapter = new MenuAdapter(mMenu);

        listView.setAdapter(adapter);

        Button btn_checkout = (Button)rootView.findViewById(R.id.btn_checkout);
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderActivity.mOrder.setVendorID(mVendorId);

                // navigate to next fragment
                ((OrderActivity) getActivity()).mFragmentManager.beginTransaction()
                        .addToBackStack(OrderActivity.TAG_MENU)
                        .replace(R.id.container, new ReviewFragment())
                        .commit();
            }
        });

        return rootView;
    }
}
