package com.mobile.pickup.Model.CustomerSide.VendorList;

/**
 * Created by yayshin on 3/23/17.
 */

public class VendorListHeader extends VendorListItem {
    public int id = -1;
    public String nameLabel;
    public String waitTimeLabel;

    public VendorListHeader(String nameLabel, String waitTimeLabel) {
        super();
        this.nameLabel = nameLabel;
        this.waitTimeLabel = waitTimeLabel;
    }
}
