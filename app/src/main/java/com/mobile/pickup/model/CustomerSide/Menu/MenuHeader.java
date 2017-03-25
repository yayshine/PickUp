package com.mobile.pickup.Model.CustomerSide.Menu;

import com.mobile.pickup.Model.FoodItem;

/**
 * Created by yayshin on 3/25/17.
 */

public class MenuHeader extends FoodItem {
    public String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
