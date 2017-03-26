package com.mobile.pickup.Controller.CustomerSide.VendorList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mobile.pickup.Model.Vendor;

import com.mobile.pickup.View.CustomerSide.VendorList.VendorListItemView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListAdapter extends BaseAdapter {

    List<Vendor> items = new ArrayList<>();

    public VendorListAdapter(List<Vendor> vendors){
        items = vendors;
    }

//    private void addItems(Vendor[] foodtrucks){
//        // add foodtrucks
//        for(int i = 0; i < foodtrucks.length; i++){
//            items.add(foodtrucks[i]);
//        }
//        sortItems();
//    }
//
//    private void sortItems(){
//        Collections.sort(items, new Comparator<Vendor>() {
//            @Override
//            public int compare(Vendor o1, Vendor o2) {
//                return o1.getID().compareTo(o2.getID());
//            }
//        });
//
//        notifyDataSetChanged();
//    }

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
        VendorListItemView view;
        if(convertView != null && convertView instanceof VendorListItemView){
            view = (VendorListItemView)convertView;
        }else{
            view = new VendorListItemView(parent.getContext());
        }
        view.setData(items.get(position));
        return view;
    }
}