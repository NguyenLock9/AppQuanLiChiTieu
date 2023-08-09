package com.example.appquanlichitieu.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.appquanlichitieu.Add.AddViewHistoryAdapter;
import com.example.appquanlichitieu.Add.AddViewPagerAdapter;
import com.example.appquanlichitieu.R;
import com.example.appquanlichitieu.widget.CustomViewPager;
import com.google.android.material.tabs.TabLayout;

public class AddFragmentHistory extends Fragment {
    TabLayout tabLayout;
    CustomViewPager viewPager;
    View mView;

    public AddFragmentHistory() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_addhistory, container, false);
        tabLayout = mView.findViewById(R.id.tab_layouth);
        viewPager = mView.findViewById(R.id.add_viewpagerh);
        AddViewHistoryAdapter adapter = new AddViewHistoryAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        //tắt vuốt
        viewPager.setPadingEnable(true);
        tabLayout.setupWithViewPager(viewPager);

        return mView;
    }
}
