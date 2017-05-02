package com.mobile.pickup.View.CustomerSide.Menu;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Model.FoodItem;
import com.mobile.pickup.PickUpApplication;
import com.mobile.pickup.R;

/**
 * Created by yayshin on 3/24/17.
 */

public class FoodItemView extends FrameLayout {
    TextView text_name;
    TextView text_price;
    Spinner spinner_quantity;

    public FoodItemView(Context context){
        super(context);

        inflate(getContext(), R.layout.view_food_item, this);
        text_name = (TextView)findViewById(R.id.text_name);
        text_price = (TextView)findViewById(R.id.text_price);
        spinner_quantity = (Spinner)findViewById(R.id.spinner_quantity);
    }

    public void setData(final FoodItem foodItem){
        text_name.setText(foodItem.getName());
        text_price.setText("$"+Float.toString(foodItem.getPrice()));

        Integer[] quants = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> quantAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, quants);
        spinner_quantity.setAdapter(quantAdapter);

        // selects previous selection
        if(OrderActivity.mTempOrder.getFoodItemQuantMap().containsKey(foodItem)){
            spinner_quantity.setSelection(OrderActivity.mTempOrder.getFoodItemQuantMap().get(foodItem));
        }

        spinner_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int quantity = (int)parent.getSelectedItem();
                if(quantity > 0) {
                    MenuFragment.btn_checkout.setClickable(true);
                    MenuFragment.btn_checkout.setBackgroundColor(ContextCompat.getColor(PickUpApplication.getContext(), R.color.colorPrimaryDark));
                    OrderActivity.mTempOrder.getFoodItemQuantMap().put(foodItem, quantity);
                }else{
                    OrderActivity.mTempOrder.getFoodItemQuantMap().remove(foodItem);
                    if(OrderActivity.mTempOrder.getFoodItemQuantMap().isEmpty()) {
                        MenuFragment.btn_checkout.setClickable(false);
                        MenuFragment.btn_checkout.setBackgroundColor(ContextCompat.getColor(PickUpApplication.getContext(), R.color.colorGrey));
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent){
            }
        });
    }
}