package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MultiplicationActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);

        editText = findViewById(R.id.edNamta);
        textView = findViewById(R.id.tvNamta);


        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Integer inputNamta = Integer.valueOf(editText.getText().toString());

                for (int i =0 ; i<=inputNamta ; i++){
                    if (i == 0) continue;
                    textView.append( inputNamta + "*" + i + " = " + inputNamta * i + "\n");
                    if (i == 10) break;
                }
            }
        });

    }
}