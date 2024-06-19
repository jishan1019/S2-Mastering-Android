package com.example.masteringandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EnvenActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enven);


        editText = findViewById(R.id.edNumberInput);
        textView = findViewById(R.id.tvOutput);


        findViewById(R.id.calculate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText("");

                // Get the input number of terms
                String input = editText.getText().toString();
                if (input.isEmpty()) {
                    textView.setText("Please enter a number");
                    return;
                }

                int n = Integer.parseInt(input);
                int sum = 0;
                StringBuilder evenNumbers = new StringBuilder("The even numbers are: ");

                // Calculate even numbers and sum
                for (int i = 1; i <= n; i++) {
                    int evenNumber = 2 * i;
                    evenNumbers.append(evenNumber).append(" ");
                    sum += evenNumber;
                }

                // Display the results
                textView.append(evenNumbers.toString() + "\n");
                textView.append("The Sum of even Natural Numbers up to " + n + " terms: " + sum);

            }
        });
    }
}