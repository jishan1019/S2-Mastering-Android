package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ArrActivity extends AppCompatActivity {


    String[] Name = {"Jishan", "Rohim", "Korim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arr);

        TextView textView = findViewById(R.id.tvOutput);


        for (int x = 0 ; x<Name.length ; x++){
            textView.append(""+ Name[x]);
        }


    }
}