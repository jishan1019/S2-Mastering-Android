package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharePrefActivity extends AppCompatActivity {

    EditText edText;
    Button btnSave,btnShow;
    TextView textView;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_pref);

        edText= findViewById(R.id.edText);
        btnSave= findViewById(R.id.btnSave);
        btnShow= findViewById(R.id.btnShow);
        textView= findViewById(R.id.tvDisplay);

        sharedPreferences = getSharedPreferences(""+ getString(R.string.app_name),MODE_PRIVATE );
        editor = sharedPreferences.edit();


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputValue = edText.getText().toString();
                editor.putString("name", inputValue);
                editor.apply();

            }
        });


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = sharedPreferences.getString("name", "0");

                textView.setText(""+ name);
            }
        });





    }
}