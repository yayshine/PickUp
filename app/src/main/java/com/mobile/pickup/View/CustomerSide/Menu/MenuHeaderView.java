package com.mobile.pickup.View.CustomerSide.Menu;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mobile.pickup.Model.CustomerSide.Menu.MenuHeader;
import com.mobile.pickup.R;

/**
 * Created by yayshin on 3/25/17.
 */

public class MenuHeaderView extends FrameLayout {
    TextView text_text;

    public MenuHeaderView(Context context){
        super(context);

        inflate(getContext(), R.layout.view_menu_header, this);
        text_text = (TextView)findViewById(R.id.text_text);
    }

    public void setData(MenuHeader header){
        text_text.setText(header.getText());
    }
}