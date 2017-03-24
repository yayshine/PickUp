package com.mobile.pickup.Controller.CustomerSide.Menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.View.CustomerSide.Menu.FoodItemView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yayshin on 3/24/17.
 */

public class MenuAdapter extends BaseAdapter{

    List<FoodItem> items = new ArrayList<>();

    public MenuAdapter(FoodItem[] foodItems){
        addItems(foodItems);
    }

    private void addItems(FoodItem[] foodItems){
        // add foodItems
        for(int i = 0; i < foodItems.length; i++){
            items.add(foodItems[i]);
        }
        sortItems();
    }

    private void sortItems(){
        Collections.sort(items, new Comparator<FoodItem>() {
            @Override
            public int compare(FoodItem o1, FoodItem o2) {
                return o1.getFoodItemID() - o2.getFoodItemID();
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
        FoodItemView view;
        if(convertView != null && convertView instanceof FoodItemView){
            view = (FoodItemView) convertView;
        }else{
            view = new FoodItemView(parent.getContext());
        }
        view.setData(items.get(position));
        return view;

    }
}
