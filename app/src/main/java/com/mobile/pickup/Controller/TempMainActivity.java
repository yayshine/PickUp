package com.mobile.pickup.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.mobile.pickup.Controller.CustomerSide.TempLoginActivity;
import com.mobile.pickup.Controller.VendorSide.MainActivity;
import com.mobile.pickup.R;

public class TempMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_main);

        Button btn_customer = (Button)findViewById(R.id.btn_customer);
        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TempMainActivity.this, TempLoginActivity.class);
                startActivity(intent);
            }
        });

        Button btn_vendor = (Button)findViewById(R.id.btn_vendor);
        btn_vendor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TempMainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
