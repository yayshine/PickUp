package com.mobile.pickup.Controller.CustomerSide.Review;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.View.CustomerSide.Review.ReviewItemView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yayshin on 3/25/17.
 */

public class ReviewAdapter extends BaseAdapter {

    List<FoodItem> items = new ArrayList<>();

    public ReviewAdapter(Object[] foodItems){
        addItems(foodItems);
    }

    private void addItems(Object[] foodItems){
        // add foodtrucks
        for(int i = 0; i < foodItems.length; i++){
            items.add((FoodItem) foodItems[i]);
        }
        sortItems();
    }

    private void sortItems(){
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem o1, FoodItem o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ReviewItemView view;
        if(convertView != null && convertView instanceof ReviewItemView){
            view = (ReviewItemView)convertView;
        }else{
            view = new ReviewItemView(parent.getContext());
        }
        FoodItem foodItem = items.get(position);
        view.setData(foodItem, OrderActivity.mTempOrder.getFoodItemQuantMap().get(foodItem));
        return view;
    }
}
