package com.mobile.pickup.Controller.CustomerSide;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListFragment;

import com.mobile.pickup.Model.CustomerSide.TempOrder;

import com.mobile.pickup.Model.Order;
import com.mobile.pickup.R;

public class OrderActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    NavigationView naviView;

    public static final String TAG_VENDOR_LIST = "VENDOR_LIST";
    public static final String TAG_MENU = "MENU";

    public FragmentManager mFragmentManager;
    public static TempOrder mTempOrder;
    public static Order mOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_order);

        mTempOrder = new TempOrder();

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.container, new VendorListFragment())
                .commit();

        naviView = (NavigationView)findViewById(R.id.navi);
        naviView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        Fragment current = mFragmentManager.findFragmentById(R.id.container);

        // clears temp order information if exited out of vendor's menu
        if(current instanceof MenuFragment){
            mTempOrder = new TempOrder();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch(menuItem.getItemId()) {
            case R.id.menu_item1 :
            case R.id.menu_item2 :
            case R.id.menu_item3 :
                menuItem.setChecked(true);
                Toast.makeText(this, "Check Item Select : " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_sub1 :
            case R.id.menu_sub2 :
                Toast.makeText(this, "Sub Item Click : " + menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
