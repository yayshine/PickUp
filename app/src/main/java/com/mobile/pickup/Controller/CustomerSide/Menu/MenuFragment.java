package com.mobile.pickup.Controller.CustomerSide.Menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListAdapter;
import com.mobile.pickup.Model.CustomerSide.VendorList.VendorListHeader;
import com.mobile.pickup.Model.FoodItem;
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
        mMenu[0] = new FoodItem(0, "삼계탕", 20, "맛있는 삼계탕");
        mMenu[1] = new FoodItem(1, "갈비탕", 20, "맛있는 갈비탕");
        mMenu[2] = new FoodItem(2, "게국지", 20, "보글보글 게국지");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_menu);

        MenuAdapter adapter = new MenuAdapter(mMenu);

        listView.setAdapter(adapter);

        return rootView;
    }

}
