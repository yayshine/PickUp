package com.mobile.pickup.Controller.CustomerSide.Menu;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Controller.CustomerSide.Review.ReviewFragment;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListFragment;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;
import com.mobile.pickup.Model.Vendor;
import com.mobile.pickup.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    FoodItem[] mMenu;
    List<FoodItem> mFoodItemList = new ArrayList<>();
    private String passedMenuID = "";


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

        mFoodItemList.add(mMenu[0]);
        mFoodItemList.add(mMenu[1]);
        mFoodItemList.add(mMenu[2]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_menu);

        final MenuAdapter adapter = new MenuAdapter(mFoodItemList);

        // Yanqing - doesn't work yet
//        final DatabaseReference mDatabaseReference;
//        mDatabaseReference = FirebaseDatabase.getInstance().getReference(); // should be changed to a menuID passed in here
//
//        ValueEventListener menuListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                mFoodItemList.clear();
//                Menu menu = dataSnapshot.child("Menu").child(passedMenuID).getValue(Menu.class);
//                HashMap<String, Boolean> foodItemsIdList = menu.getFoodItemIDVisibilityMap();
//                List<String> foodItemsIdToDisplay = new ArrayList<>();
//                for (Map.Entry<String, Boolean> entry : foodItemsIdList.entrySet()) {
//                    String foodItemID = entry.getKey();
//                    boolean isDisplayed = entry.getValue();
//                    if (isDisplayed == true){
//                        foodItemsIdToDisplay.add(foodItemID);
//                    }
//                }
//
//                for (String foodItemID: foodItemsIdToDisplay) {
//                    FoodItem foodItem = dataSnapshot.child("FoodItem").child(foodItemID).getValue(FoodItem.class);
//                    mFoodItemList.add(foodItem);
//                    //please update the adapter;
//                    adapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.d("getMenu", "Display menu failed.");
//            }
//        };
//        mDatabaseReference.addValueEventListener(menuListener);

        listView.setAdapter(adapter);

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
