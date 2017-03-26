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
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.Model.Menu;
import com.mobile.pickup.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    FoodItem[] mMenu;
    List<FoodItem> mFoodItemList = new ArrayList<>();
    private String passedMenuID = OrderActivity.mTempOrder.getVendor().getMenuID();


    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_menu);

        final MenuAdapter adapter = new MenuAdapter(mFoodItemList);

        final DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

        ValueEventListener menuListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Menu menu = dataSnapshot.child("Menu").child(passedMenuID).getValue(Menu.class);

                Set<String> foodItemIDList = menu.getFoodItemIDVisibilityMap().keySet();
                for(String foodItemID : foodItemIDList){
                    if(menu.getFoodItemIDVisibilityMap().get(foodItemID) == true){
                        FoodItem foodItem = dataSnapshot.child("FoodItem").child(foodItemID).getValue(FoodItem.class);
                        mFoodItemList.add(foodItem);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("getMenu", "Display menu failed.");
            }
        };
        mDatabaseReference.addValueEventListener(menuListener);

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
