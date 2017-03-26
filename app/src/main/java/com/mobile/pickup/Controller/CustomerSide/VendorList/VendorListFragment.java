package com.mobile.pickup.Controller.CustomerSide.VendorList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mobile.pickup.Controller.CustomerSide.Menu.MenuFragment;
import com.mobile.pickup.Controller.CustomerSide.OrderActivity;

import com.mobile.pickup.Model.Vendor;

import com.mobile.pickup.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorListFragment extends Fragment {

    Vendor[] mVendorList;
    List<Vendor> mVendorListList = new ArrayList<>();

    public VendorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dummy data for now
//        mVendorList = new Vendor[3];
//        mVendorList[0] = new Vendor("a", "Uncle Luoyang", "aa", "9 AM - 5 PM", true);
//        mVendorList[1] = new Vendor("b", "Aunt HongKong", "bb", "9 AM - 5 PM", true);
//        mVendorList[2] = new Vendor("c", "Granpa Macao", "cc", "9 AM - 5 PM", true);
//
//        mVendorListList.add(mVendorList[0]);
//        mVendorListList.add(mVendorList[1]);
//        mVendorListList.add(mVendorList[2]);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vendor_list, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_vendor);

        final VendorListAdapter adapter = new VendorListAdapter(mVendorListList);
//        listView.setAdapter(adapter);

        // yanqing
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Vendor");

        ValueEventListener vendorListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mVendorListList.clear();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Vendor vendor = child.getValue(Vendor.class);
                    mVendorListList.add(vendor);
                    //please update the adapter;
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("getVendors", "Your getAllVendors() failed.");
            }
        };
        mDatabase.addValueEventListener(vendorListener);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrderActivity.mTempOrder.setVendor(((Vendor)adapter.getItem(position)));

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