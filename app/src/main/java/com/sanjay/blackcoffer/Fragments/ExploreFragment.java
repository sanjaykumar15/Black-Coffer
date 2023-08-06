package com.sanjay.blackcoffer.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.sanjay.blackcoffer.Adapter.TabAdapter;
import com.sanjay.blackcoffer.R;

public class ExploreFragment extends Fragment {

    TabLayout exploreTabs;
    ViewPager exploreVP;
    TabAdapter tabAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_explore, container, false);

        exploreTabs = view.findViewById(R.id.exploreTabs);
        exploreVP = view.findViewById(R.id.exploreVP);

        tabAdapter = new TabAdapter(getActivity().getSupportFragmentManager());
        exploreVP.setAdapter(tabAdapter);
        exploreTabs.setupWithViewPager(exploreVP);

        return view;
    }
}
