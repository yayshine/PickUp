package com.mobile.pickup;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by yayshin on 3/30/17.
 */

public class PropertyManager {
    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private static PropertyManager instance;
    public static PropertyManager getInstance(){
        if(instance == null){
            instance = new PropertyManager();
        }
        return instance;
    }

    private PropertyManager(){
        mPrefs = PreferenceManager.getDefaultSharedPreferences(PickUpApplication.getContext());
        mEditor = mPrefs.edit();
    }

    private static final String KEY_ID = "ID";
    private static final String KEY_USERNAME = "USERNAME";

    public void setID(String id){
        mEditor.putString(KEY_ID, id);
        mEditor.commit();
    }

    public String getID(){
        return mPrefs.getString(KEY_ID, "");
    }

    public void setUsername(String username){
        mEditor.putString(KEY_USERNAME, username);
        mEditor.commit();
    }

    public String getUsername(){
        return mPrefs.getString(KEY_USERNAME, "");
    }

    public void logout(){
        setID("");
        setUsername("");
        mEditor.commit();
    }
}
