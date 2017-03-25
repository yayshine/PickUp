package com.mobile.pickup.View.CustomerSide.Review;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.R;

/**
 * Created by yayshin on 3/25/17.
 */

public class ReviewItemView extends FrameLayout {
    TextView text_name;
    TextView text_price;
    TextView text_quantity;

    public ReviewItemView(Context context){
        super(context);

        inflate(getContext(), R.layout.view_review_item, this);
        text_name = (TextView)findViewById(R.id.text_name);
        text_price = (TextView)findViewById(R.id.text_price);
        text_quantity = (TextView)findViewById(R.id.text_quantity);
    }

    public void setData(FoodItem foodItem, int quantity){
        text_name.setText(foodItem.getName());
        text_price.setText(Float.toString(foodItem.getPrice()));
        text_quantity.setText(Integer.toString(quantity));
    }
}