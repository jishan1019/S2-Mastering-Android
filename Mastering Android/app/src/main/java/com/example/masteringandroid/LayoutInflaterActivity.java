package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LayoutInflaterActivity extends AppCompatActivity {

    LinearLayout inflateLayout;
    LayoutInflater layoutInflater;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_inflater);

        inflateLayout = findViewById(R.id.inflateLayout);
        layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        sharedPreferences = getSharedPreferences(getString(R.string.app_name), MODE_PRIVATE);
        editor = sharedPreferences.edit();


        editor.putString("key", "value");
        editor.apply();
        String name = sharedPreferences.getString("key", "default value");

         View myView =layoutInflater.inflate(R.layout.profile, inflateLayout);
        TextView tvProfile = myView.findViewById(R.id.tvProfile);

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvProfile.setText("Helllo ami programitaclly text........");
            }
        });


    }
}