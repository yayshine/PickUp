package com.mobile.pickup.View.CustomerSide.Menu;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuAdapter;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;
import com.mobile.pickup.Model.FoodItem;
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
        text_price.setText(Float.toString(foodItem.getPrice()));

        Integer[] quants = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        ArrayAdapter<Integer> quantAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, quants);
        spinner_quantity.setAdapter(quantAdapter);
        spinner_quantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int quantity = (int)parent.getSelectedItem();
                if(quantity > 0) {
                    OrderActivity.mOrder.getFoodItemQuantityPair().put(foodItem.getFoodItemID(), quantity);
                }else{
                    OrderActivity.mOrder.getFoodItemQuantityPair().remove(foodItem.getFoodItemID());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}