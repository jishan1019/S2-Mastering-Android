package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SumSeriesActivity extends AppCompatActivity {

    EditText editText, edNumberTrams;
    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_series);


        editText = findViewById(R.id.edNumberInput);
        textView = findViewById(R.id.tvOutput);



        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int n = Integer.parseInt(editText.getText().toString());
                int sum = 0;
                int term = 9;
                StringBuilder series = new StringBuilder();

                // Calculate the series and sum
                for (int i = 1; i <= n; i++) {
                    series.append(term).append(" ");
                    sum += term;
                    term = term * 10 + 9; // Generate the next term
                }

                // Display the results
                textView.append(series.toString() + "\n");
                textView.append("The sum of the series = " + sum);


            }
        });



    }
}