package com.example.appquanlichitieu.Add;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class AddViewHistoryAdapter extends FragmentStatePagerAdapter {


    public AddViewHistoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new HistoryFragmentChi();
            case 1:
                return new HistoryFragmentThu();
            default:
                return new HistoryFragmentChi();
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
                return "Giao Dịch Thu";
            case 1:
                return "Giao Dịch Chi";
            default:
                return "Giao Dịch Thu";

        }
    }
}