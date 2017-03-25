package com.mobile.pickup.Controller.CustomerSide.VendorList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mobile.pickup.model.CustomerSide.VendorList.VendorListHeader;
import com.mobile.pickup.model.CustomerSide.VendorList.VendorListItem;
import com.mobile.pickup.View.CustomerSide.VendorList.VendorListHeaderView;
import com.mobile.pickup.View.CustomerSide.VendorList.VendorListItemView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_HEADER = 1;

    List<VendorListItem> items = new ArrayList<>();

    public VendorListAdapter(VendorListItem[] foodtrucks){
        addItems(foodtrucks);
    }

    private void addItems(VendorListItem[] foodtrucks){
        // add foodtrucks
        for(int i = 0; i < foodtrucks.length; i++){
            items.add(foodtrucks[i]);
        }
        sortItems();
    }

    public void addHeaderItem(VendorListHeader header){
        items.add(header);
        sortItems();
    }

    private void sortItems(){
        Collections.sort(items, new Comparator<VendorListItem>() {
            @Override
            public int compare(VendorListItem o1, VendorListItem o2) {
                if(o1 instanceof VendorListHeader && o2 instanceof VendorListHeader) {
                    return ((VendorListHeader)o1).nameLabel.compareTo(((VendorListHeader)o2).nameLabel);
                }
                if(o1 instanceof VendorListHeader){
                    return -1;
                }
                if(o2 instanceof VendorListHeader){
                    return 1;
                }
                return o1.name.compareTo(o2.name);
            }
        });

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        VendorListItem item = items.get(position);
        if(item instanceof VendorListHeader){
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

    public String getVendorId(int position){
        return items.get(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch(getItemViewType(position)){
            // header
            case TYPE_HEADER:
                VendorListHeaderView headerView;
                if(convertView != null && convertView instanceof VendorListHeaderView){
                    headerView = (VendorListHeaderView)convertView;
                }else{
                    headerView = new VendorListHeaderView(parent.getContext());
                }
                headerView.setData((VendorListHeader) items.get(position));
                return headerView;
            // item
            case TYPE_ITEM:
            default:
                VendorListItemView itemView;
                if(convertView != null && convertView instanceof VendorListItemView){
                    itemView = (VendorListItemView)convertView;
                }else{
                    itemView = new VendorListItemView(parent.getContext());
                }
                itemView.setData(items.get(position));
                return itemView;
        }
    }
}
