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
import com.mobile.pickup.model.CustomerSide.VendorList.VendorListHeader;
import com.mobile.pickup.model.CustomerSide.VendorList.VendorListItem;
import com.mobile.pickup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorListFragment extends Fragment {

    VendorListItem[] mVendorList;

    public VendorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dummy data for now
        mVendorList = new VendorListItem[3];
        mVendorList[0] = new VendorListItem("a", "Uncle Luoyang", 10);
        mVendorList[1] = new VendorListItem("b", "Aunt HongKong", 15);
        mVendorList[2] = new VendorListItem("c", "Granpa Macao", 20);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vendor_list, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_vendor);

        final VendorListAdapter adapter = new VendorListAdapter(mVendorList);
        adapter.addHeaderItem(new VendorListHeader("name", "wait time"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                OrderActivity.mOrder.setVendorID(((VendorListItem)adapter.getItem(position)).id);

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
