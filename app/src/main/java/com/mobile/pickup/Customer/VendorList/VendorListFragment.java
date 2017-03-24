package com.mobile.pickup.Customer.VendorList;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobile.pickup.Customer.Menu.MenuFragment;
import com.mobile.pickup.Customer.OrderActivity;
import com.mobile.pickup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class VendorListFragment extends Fragment {

    VendorListItem[] mFTList;

    public VendorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Dummy data for now
        mFTList = new VendorListItem[3];
        mFTList[0] = new VendorListItem(0, "Uncle Luoyang", 10);
        mFTList[1] = new VendorListItem(1, "Aunt HongKong", 15);
        mFTList[2] = new VendorListItem(2, "Granpa Macao", 20);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vendor_list, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_vendor);

        VendorListAdapter adapter = new VendorListAdapter(mFTList);
        adapter.addHeaderItem(new VendorListHeader("name", "wait time"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // navigate to next fragment
                ((OrderActivity) getActivity()).mFragmentManager.beginTransaction()
                        .replace(R.id.container, new MenuFragment())
                        .commit();
            }
        });

        return rootView;
    }

}
