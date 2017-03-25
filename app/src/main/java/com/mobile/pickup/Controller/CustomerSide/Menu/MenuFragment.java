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
import com.mobile.pickup.model.FoodItem;
import com.mobile.pickup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    FoodItem[] mMenu;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dummy data for now
        mMenu = new FoodItem[3];
        mMenu[0] = new FoodItem("a", "Hot and Sour Soup", 3.45f, "Spicy");
        mMenu[1] = new FoodItem("b", "Minced Beef Chowder", 10.95f, "Minced Beef Chowder");
        mMenu[2] = new FoodItem("c", "Tomato with Egg Drop Soup", 10.50f, "Tomato with Egg Drop Soup");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_menu);

        MenuAdapter adapter = new MenuAdapter(mMenu);

        listView.setAdapter(adapter);

        Button btn_checkout = (Button)rootView.findViewById(R.id.btn_checkout);
        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
