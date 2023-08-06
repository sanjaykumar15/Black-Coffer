package com.sanjay.blackcoffer.Fragments;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.sanjay.blackcoffer.Adapter.ExploreListAdapter;
import com.sanjay.blackcoffer.R;
public class Business extends Fragment {

    EditText businessSearch;
    ImageView businessFilter;
    RecyclerView businessRV;
    ExploreListAdapter adapter;
    TextView notesFABTV,jobsFABTV,groupFABTV,businessCardFABTV,buySellRentFABTV,matrimonyFABTV,datingFABTV;
    FloatingActionButton  addFloatBtn,notesFAB,jobsFAB,groupFAB,businessCardFAB,buySellRentFAB,matrimonyFAB,datingFAB;
    LinearLayout transparentLL;
    boolean fabVisible = false;
    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_business, container, false);

        businessSearch = view.findViewById(R.id.businessSearchET);
        businessFilter = view.findViewById(R.id.businessFilter);
        businessRV = view.findViewById(R.id.businessRV);

        businessRV.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ExploreListAdapter(getContext(),"Business");
        businessRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        notesFABTV = view.findViewById(R.id.notesFABTV);
        jobsFABTV = view.findViewById(R.id.jobsFABTV);
        groupFABTV = view.findViewById(R.id.groupFABTV);
        businessCardFABTV = view.findViewById(R.id.businessCardFABTV);
        buySellRentFABTV = view.findViewById(R.id.buySellRentFABTV);
        matrimonyFABTV = view.findViewById(R.id.matrimonyFABTV);
        datingFABTV = view.findViewById(R.id.datingFABTV);

        addFloatBtn = view.findViewById(R.id.addFloatBtn);
        notesFAB = view.findViewById(R.id.notesFAB);
        jobsFAB = view.findViewById(R.id.jobsFAB);
        groupFAB = view.findViewById(R.id.groupFAB);
        businessCardFAB = view.findViewById(R.id.businessCardFAB);
        buySellRentFAB = view.findViewById(R.id.buySellRentFAB);
        matrimonyFAB = view.findViewById(R.id.matrimonyFAB);
        datingFAB = view.findViewById(R.id.datingFAB);

        transparentLL = view.findViewById(R.id.transparentLL);
        transparentLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideFAB();
            }
        });

        addFloatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!fabVisible){
                    notesFAB.show();
                    jobsFAB.show();
                    groupFAB.show();
                    businessCardFAB.show();
                    buySellRentFAB.show();
                    matrimonyFAB.show();
                    datingFAB.show();
                    notesFABTV.setVisibility(View.VISIBLE);
                    jobsFABTV.setVisibility(View.VISIBLE);
                    groupFABTV.setVisibility(View.VISIBLE);
                    businessCardFABTV.setVisibility(View.VISIBLE);
                    buySellRentFABTV.setVisibility(View.VISIBLE);
                    matrimonyFABTV.setVisibility(View.VISIBLE);
                    datingFABTV.setVisibility(View.VISIBLE);
                    transparentLL.setVisibility(View.VISIBLE);
                    addFloatBtn.setImageDrawable(getResources().getDrawable(R.drawable.close));
                    fabVisible = true;
                } else {
                    hideFAB();
                }
            }
        });

        businessRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCREEN_STATE_ON){
                    addFloatBtn.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy>0 || dy<0 && addFloatBtn.isShown()){
                    addFloatBtn.hide();
                }
            }
        });

        businessFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getContext(), android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
                /*Theme_DeviceDefault_DialogWhenLarge_NoActionBar*/
                dialog.setContentView(R.layout.filter_screen);

                ImageView close = dialog.findViewById(R.id.close);
                Button filterApplyBtn = dialog.findViewById(R.id.filterApplyBtn);
                LinearLayout pucLL = dialog.findViewById(R.id.pucLL);
                LinearLayout perLocLL = dialog.findViewById(R.id.perLocLL);
                LinearLayout preferenceLL = dialog.findViewById(R.id.preferenceLL);
                LinearLayout yrOfExpLL = dialog.findViewById(R.id.yrOfExpLL);
                LinearLayout companyLL = dialog.findViewById(R.id.companyLL);
                LinearLayout professionLL = dialog.findViewById(R.id.professionLL);
                LinearLayout busLocLL = dialog.findViewById(R.id.busLocLL);
                LinearLayout categoryLL = dialog.findViewById(R.id.categoryLL);
                LinearLayout pcsLL = dialog.findViewById(R.id.pcsLL);
                LinearLayout purposeLL = dialog.findViewById(R.id.purposeLL);
                LinearLayout serviceTypeLL = dialog.findViewById(R.id.serviceTypeLL);

                TextView yrOfExpRangeTV = dialog.findViewById(R.id.yrOfExpRangeTV);
                SeekBar yrOfExpSB = dialog.findViewById(R.id.yrOfExpSB);
                TextView pcsRangeTV = dialog.findViewById(R.id.pcsRangeTV);
                SeekBar pcsSB = dialog.findViewById(R.id.pcsSB);

                pcsSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        pcsRangeTV.setText("0 - "+String.valueOf(i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                yrOfExpSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        yrOfExpRangeTV.setText("0 - "+String.valueOf(i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                pucLL.setVisibility(View.GONE);
                perLocLL.setVisibility(View.GONE);
                preferenceLL.setVisibility(View.GONE);
                yrOfExpLL.setVisibility(View.VISIBLE);
                companyLL.setVisibility(View.VISIBLE);
                professionLL.setVisibility(View.VISIBLE);
                busLocLL.setVisibility(View.VISIBLE);
                categoryLL.setVisibility(View.GONE);
                pcsLL.setVisibility(View.VISIBLE);
                purposeLL.setVisibility(View.GONE);
                serviceTypeLL.setVisibility(View.VISIBLE);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                filterApplyBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                String[] serviceOptions = {"Select service type","Business Services","Utility Services","Government Services","Medical Services","Religious Services",
                        "Academics","Educational Services","Defence Services","Banking Services","Social Volunteer","Others"};
                Spinner serviceSpn = dialog.findViewById(R.id.serviceTypeSpn);
                ArrayAdapter<String> serviceAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item,serviceOptions);
                serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                serviceSpn.setAdapter(serviceAdapter);

                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
                dialog.show();
            }
        });

        return view;
    }
    private void hideFAB() {
        notesFAB.hide();
        jobsFAB.hide();
        groupFAB.hide();
        businessCardFAB.hide();
        buySellRentFAB.hide();
        matrimonyFAB.hide();
        datingFAB.hide();
        notesFABTV.setVisibility(View.GONE);
        jobsFABTV.setVisibility(View.GONE);
        groupFABTV.setVisibility(View.GONE);
        businessCardFABTV.setVisibility(View.GONE);
        buySellRentFABTV.setVisibility(View.GONE);
        matrimonyFABTV.setVisibility(View.GONE);
        datingFABTV.setVisibility(View.GONE);
        transparentLL.setVisibility(View.GONE);
        addFloatBtn.setImageDrawable(getResources().getDrawable(R.drawable.add));
        fabVisible = false;
    }
}