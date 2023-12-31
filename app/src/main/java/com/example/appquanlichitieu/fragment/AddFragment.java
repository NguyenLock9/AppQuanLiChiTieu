package com.example.appquanlichitieu.fragment;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appquanlichitieu.Add.AddViewPagerAdapter;
import com.example.appquanlichitieu.R;
import com.example.appquanlichitieu.widget.CustomViewPager;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {
    TabLayout tabLayout;
    CustomViewPager viewPager;
    View mView;

    public AddFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_add, container, false);
        tabLayout = mView.findViewById(R.id.tab_layout);
        viewPager = mView.findViewById(R.id.add_viewpager);
        AddViewPagerAdapter adapter = new AddViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        //tắt vuốt
        viewPager.setPadingEnable(true);
        tabLayout.setupWithViewPager(viewPager);


        return mView;
    }
}