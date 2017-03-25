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

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorListFragment extends Fragment {

    Vendor[] mVendorList;

    public VendorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dummy data for now
        mVendorList = new Vendor[3];
        mVendorList[0] = new Vendor("a", "Uncle Luoyang", "aa", "9 AM - 5 PM", true);
        mVendorList[1] = new Vendor("b", "Aunt HongKong", "bb", "9 AM - 5 PM", true);
        mVendorList[2] = new Vendor("c", "Granpa Macao", "cc", "9 AM - 5 PM", true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vendor_list, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_vendor);

        final VendorListAdapter adapter = new VendorListAdapter(mVendorList);

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
