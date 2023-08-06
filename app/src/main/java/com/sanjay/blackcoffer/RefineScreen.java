package com.sanjay.blackcoffer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class RefineScreen extends AppCompatActivity {

    Toolbar toolbar;
    RelativeLayout toolBarRL;

    Spinner availabilitySpn;
    String[] availabilityOptions = {"Available | Hey Let US Connect","Away | Stay Discrete And Watch",
            "Busy | Do Not Disturb | Will Catch Up Later", "SOS | Emergency! Need Assistance! HELP"};

    TextView maxTV;
    SeekBar distanceSB;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refine_screen);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Refine");
        setSupportActionBar(toolbar);
        toolBarRL = findViewById(R.id.toolBarRL);
        toolBarRL.setVisibility(View.GONE);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        availabilitySpn = findViewById(R.id.availabilitySpn);
        ArrayAdapter<String> availabilityAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,availabilityOptions);
        availabilityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        availabilitySpn.setAdapter(availabilityAdapter);

        distanceSB = findViewById(R.id.distanceSB);
        maxTV = findViewById(R.id.maxTV);

        distanceSB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                maxTV.setText(String.valueOf(i)+" Km");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}