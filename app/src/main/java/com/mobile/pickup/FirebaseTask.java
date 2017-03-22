package com.mobile.pickup;

import com.firebase.client.Firebase;

/**
 * Created by Yanqing on 3/21/17.
 */

public class FirebaseTask {
    private final String FIREBASE_URL = "https://pickup-64523.firebaseio.com/";

    public void addCustomer(){
        Firebase ref = new Firebase(FIREBASE_URL);
        ref.child("customer").setValue("codeCustomer");
    }

}
