package com.example.hamburguesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    HomeFragment homeFragment = new HomeFragment();
    MenuFragment menuFragment = new MenuFragment();
    ServiceFragment serviceFragment = new ServiceFragment();
    RestaurantFragment restaurantFragment = new RestaurantFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(homeFragment);

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.logo_foreground);
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f6a33e")));


    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.homeFragment:
                    loadFragment(homeFragment);
                    return true;
                case R.id.menuFragment:
                    loadFragment(menuFragment);
                    return true;
                case R.id.serviceFragment:
                    loadFragment(serviceFragment);
                    return true;
                case R.id.restaurantFragment:
                    Toast.makeText(getApplicationContext(), "Se Añadirá Geolocalización", Toast.LENGTH_LONG).show();
                    loadFragment(restaurantFragment);
                    return true;
            }
            return false;
        }
    };



}