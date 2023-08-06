package com.sanjay.blackcoffer.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sanjay.blackcoffer.Fragments.Business;
import com.sanjay.blackcoffer.Fragments.Merchant;
import com.sanjay.blackcoffer.Fragments.Personal;

public class TabAdapter extends FragmentPagerAdapter {

    private String[] tabTitles = {"Personal","Business","Merchant"};
    public TabAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Personal();
        } else if (position == 1) {
            return new Business();
        } else {
            return new Merchant();
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int pos) {
        return tabTitles[pos];
    }

}
