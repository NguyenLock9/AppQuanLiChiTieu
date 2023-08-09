package com.example.appquanlichitieu.Add;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AddViewPagerAdapter extends FragmentStatePagerAdapter {


    public AddViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new KhoanThuFragment();
            case 1:
                return new KhoanChiFragment();
            default:
                return new KhoanThuFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Khoản Thu";
            case 1:
                return "Khoản Chi";
            default:
                return "Khoản Thu";

        }
    }
}
