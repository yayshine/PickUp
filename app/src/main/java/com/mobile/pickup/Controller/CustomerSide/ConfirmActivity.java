package com.mobile.pickup.Controller.CustomerSide;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mobile.pickup.Controller.CustomerSide.Confirm.ConfirmFragment;
import com.mobile.pickup.R;

public class ConfirmActivity extends AppCompatActivity {

    public static final String TAG_ESTIMATED_TIME = "ESTIMATED TIME";
    public static final String TAG_CURRENT_TIME = "CURRENT TIME";

    public FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_confirm);

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

        TextView btn_exit = (TextView)findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
