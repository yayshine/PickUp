package com.mobile.pickup.Controller.CustomerSide.Confirm;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mobile.pickup.Controller.CustomerSide.ConfirmActivity;
import com.mobile.pickup.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_c_confirm, container, false);

        long estimatedTime = getArguments().getLong(ConfirmActivity.TAG_ESTIMATED_TIME);
        String estimatedTimeFormatted = genFormattedTimeString(estimatedTime);

        TextView text_estimated_time = (TextView) rootView.findViewById(R.id.text_estimated_time);
        text_estimated_time.setText(estimatedTimeFormatted);

        return rootView;
    }

    String genFormattedTimeString(long timeInMillisecs){
        Date time = new Date(timeInMillisecs);
        DateFormat formatter = new SimpleDateFormat("hh:mm a");
        formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        return formatter.format(time);
    }
}
