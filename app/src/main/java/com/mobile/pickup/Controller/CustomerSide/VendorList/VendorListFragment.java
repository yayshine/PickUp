package com.mobile.pickup.Controller.CustomerSide.VendorList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;

import com.mobile.pickup.Model.Vendor;

import com.mobile.pickup.R;
import com.mobile.pickup.VendorManager;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorListFragment extends Fragment {

    public static String key = "MENU_ID";

    List<Vendor> mVendorList;
    VendorListAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // reading from Firebase server
        VendorManager manager = new VendorManager();
        mVendorList = manager.getAllVendors();

        mAdapter = new VendorListAdapter(mVendorList);
        manager.setOnVendorReadListener(new VendorManager.OnVendorReadListener() {
            @Override
            public void onFinish() {
                mAdapter.update();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_c_vendor_list, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_vendor);

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrderActivity.mTempOrder.setVendor(((Vendor)mAdapter.getItem(position)));

                // navigate to next fragment
                ((OrderActivity) getActivity()).mFragmentManager.beginTransaction()
                        .replace(R.id.container, new MenuFragment())
                        .addToBackStack(OrderActivity.TAG_VENDOR_LIST)
                        .commit();
            }
        });

        return rootView;
    }

}