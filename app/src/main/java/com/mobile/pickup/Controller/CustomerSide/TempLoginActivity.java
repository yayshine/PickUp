package com.mobile.pickup.Controller.CustomerSide;


import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mobile.pickup.Controller.SignInSignUpActivity;
import com.mobile.pickup.CustomerManager;
import com.mobile.pickup.Model.Customer;
import com.mobile.pickup.PropertyManager;
import com.mobile.pickup.R;


public class TempLoginActivity extends SignInSignUpActivity implements View.OnClickListener
{

    @Override
    public void updateUI(FirebaseUser user) {
        super.updateUI(user);
        if (user != null) {

            findViewById(R.id.email_password_buttons).setVisibility(View.GONE);
            findViewById(R.id.email_password_fields).setVisibility(View.GONE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.VISIBLE);

            findViewById(R.id.verify_email_button).setEnabled(!user.isEmailVerified());

            Customer customer = CustomerManager.setCustomer(user.getUid(), user.getEmail());

            PropertyManager propertyManager = PropertyManager.getInstance();
            propertyManager.setUsername(customer.getCustomerName());
            propertyManager.setID(customer.getID());

            Intent intent = new Intent(TempLoginActivity.this, OrderActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        } else {
            findViewById(R.id.email_password_buttons).setVisibility(View.VISIBLE);
            findViewById(R.id.email_password_fields).setVisibility(View.VISIBLE);
            findViewById(R.id.signed_in_buttons).setVisibility(View.GONE);
        }
    }
}