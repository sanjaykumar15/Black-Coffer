package com.sanjay.blackcoffer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.sanjay.blackcoffer.Fragments.ExploreFragment;

public class ExploreScreen extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout refineIconLL;

    DrawerLayout drawerLayout;
    NavigationView navView;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_screen);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        refineIconLL = findViewById(R.id.refineIconLL);
        refineIconLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExploreScreen.this,RefineScreen.class);
                startActivity(intent);
            }
        });
        drawerLayout = findViewById(R.id.drawerLayout);
        navView = findViewById(R.id.navView);

        bottomNavigationView = findViewById(R.id.bottomNav);

        navView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ExploreFragment()).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int id = menuItem.getItemId();

                if (id == R.id.explore){
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ExploreFragment()).commit();
                } else if (id == R.id.network) {
                    Toast.makeText(ExploreScreen.this, "Network", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.chat) {
                    Toast.makeText(ExploreScreen.this, "Chat", Toast.LENGTH_SHORT).show();
                } else if (id == R.id.contacts) {
                    Toast.makeText(ExploreScreen.this, "Contacts", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ExploreScreen.this, "Groups", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
        
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}