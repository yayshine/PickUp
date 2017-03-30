package com.mobile.pickup.Controller.CustomerSide;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.mobile.pickup.Controller.CustomerSide.Confirm.ConfirmFragment;
import com.mobile.pickup.Controller.CustomerSide.VendorList.VendorListFragment;
import com.mobile.pickup.Model.CustomerSide.TempOrder;
import com.mobile.pickup.Model.Order;
import com.mobile.pickup.R;

public class ConfirmActivity extends AppCompatActivity {

    public static final String TAG_ESTIMATED_TIME = "ESTIMATED TIME";
    public static final String TAG_CURRENT_TIME = "CURRENT TIME";

    public FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Intent intent = getIntent();
        long estimatedTime = intent.getLongExtra(TAG_ESTIMATED_TIME, -1);
        long currentTime = intent.getLongExtra(TAG_CURRENT_TIME, -1);

        Bundle bundle = new Bundle();
        bundle.putLong(TAG_ESTIMATED_TIME, estimatedTime);
        bundle.putLong(TAG_CURRENT_TIME, currentTime);
        ConfirmFragment fragment = new ConfirmFragment();
        fragment.setArguments(bundle);

        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();

        Button btn_exit = (Button)findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
