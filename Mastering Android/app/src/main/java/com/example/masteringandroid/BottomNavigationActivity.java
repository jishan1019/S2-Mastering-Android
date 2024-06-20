package com.example.masteringandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);


        bottomNavigationView = findViewById(R.id.bottomNavItem);

        bottomNavigationView.getOrCreateBadge(R.id.notification).setNumber(100);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if(item.getItemId() == R.id.home){
                    Toast.makeText(BottomNavigationActivity.this, "This is home", Toast.LENGTH_SHORT).show();
                }else if(item.getItemId() == R.id.notification){
                    Toast.makeText(BottomNavigationActivity.this, "This is notification", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
    }
}