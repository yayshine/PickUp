package com.mobile.pickup.Controller.CustomerSide.Menu;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mobile.pickup.Model.CustomerSide.Menu.MenuHeader;
import com.mobile.pickup.Model.FoodItem;

import com.mobile.pickup.View.CustomerSide.Menu.FoodItemView;
import com.mobile.pickup.View.CustomerSide.Menu.MenuHeaderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yayshin on 3/24/17.
 */

public class MenuAdapter extends BaseAdapter{

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    List<FoodItem> items = new ArrayList<>();

    public MenuAdapter(List<FoodItem> menuList){
        items = menuList;
    }

    public void addHeaderItem(MenuHeader header){
        items.add(header);
        update();
    }

    public void update(){
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        FoodItem item = items.get(position);
        if(item instanceof MenuHeader){
            return TYPE_HEADER;
        }else{
            return TYPE_ITEM;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
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
        switch(getItemViewType(position)){
            // header
            case TYPE_HEADER:
                MenuHeaderView headerView;
                if(convertView != null && convertView instanceof MenuHeaderView){
                    headerView = (MenuHeaderView)convertView;
                }else{
                    headerView = new MenuHeaderView(parent.getContext());
                }
                headerView.setData((MenuHeader) items.get(position));
                return headerView;
            // item
            case TYPE_ITEM:
            default:
                FoodItemView itemView;
                if(convertView != null && convertView instanceof FoodItemView){
                    itemView = (FoodItemView)convertView;
                }else{
                    itemView = new FoodItemView(parent.getContext());
                }
                itemView.setData(items.get(position));
                return itemView;
        }
    }
}
