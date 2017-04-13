package com.mobile.pickup.Controller.CustomerSide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mobile.pickup.CustomerManager;
import com.mobile.pickup.Model.Customer;
import com.mobile.pickup.PropertyManager;
import com.mobile.pickup.R;

public class TempLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_temp_login);

        final EditText edit_username = (EditText)findViewById(R.id.edit_username);

        Button btn_login = (Button)findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edit_username.getText().toString();

                Customer customer = CustomerManager.addCustomer(username);
                PropertyManager propertyManager = PropertyManager.getInstance();
                propertyManager.setUsername(customer.getCustomerName());
                propertyManager.setID(customer.getID());

                Intent intent = new Intent(TempLoginActivity.this, OrderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


    }
}
