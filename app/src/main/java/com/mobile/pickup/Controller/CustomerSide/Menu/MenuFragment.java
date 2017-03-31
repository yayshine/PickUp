package com.mobile.pickup.Controller.CustomerSide.Menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.Review.ReviewFragment;
import com.mobile.pickup.MenuManager;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    List<FoodItem> mMenu = new ArrayList<>();

    MenuAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String menuID = OrderActivity.mTempOrder.getVendor().getMenuID();

        // reading from Firebase server
        MenuManager manager = new MenuManager();
        mMenu = manager.getAllFoodItems(menuID);

        mAdapter = new MenuAdapter(mMenu);
        manager.setOnFoodItemsReadListener(new MenuManager.OnFoodItemsReadListener() {
            @Override
            public void onFinish() {
                mAdapter.update();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_c_menu, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_menu);

        listView.setAdapter(mAdapter);

        Button btn_checkout = (Button)rootView.findViewById(R.id.btn_checkout);
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // customer selection is stored to mTempOrder by FoodItemView

                // navigate to next fragment
                ((OrderActivity) getActivity()).mFragmentManager.beginTransaction()
                        .replace(R.id.container, new ReviewFragment())
                        .addToBackStack(OrderActivity.TAG_MENU)
                        .commit();
            }
        });

        return rootView;
    }
}
