package com.mobile.pickup.Model.CustomerSide.VendorList;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListItem {
    public int id = -1;
    public String name;
    public int waitTime;

    public VendorListItem(){
    }

    public VendorListItem(int _id, String name, int waitTime){
        this.id = _id;
        this.name = name;
        this.waitTime = waitTime;
    }
}
