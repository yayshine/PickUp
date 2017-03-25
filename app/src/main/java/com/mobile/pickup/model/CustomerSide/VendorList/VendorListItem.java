package com.mobile.pickup.model.CustomerSide.VendorList;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListItem {
    public String id;
    public String name;
    public int waitTime;

    public VendorListItem(){
    }

    public VendorListItem(String _id, String name, int waitTime){
        this.id = _id;
        this.name = name;
        this.waitTime = waitTime;
    }
}
