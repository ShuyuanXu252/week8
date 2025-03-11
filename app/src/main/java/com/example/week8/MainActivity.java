package com.example.week8;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputFirstNumber, inputSecondNumber;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);
        textResult = findViewById(R.id.textResult);

        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonMinus = findViewById(R.id.buttonMinus);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);

        buttonPlus.setOnClickListener(view -> calculate("+"));
        buttonMinus.setOnClickListener(view -> calculate("-"));
        buttonMultiply.setOnClickListener(view -> calculate("*"));
        buttonDivide.setOnClickListener(view -> calculate("/"));
    }

    private void calculate(String operator) {
        String firstNumStr = inputFirstNumber.getText().toString();
        String secondNumStr = inputSecondNumber.getText().toString();

        if (firstNumStr.isEmpty() || secondNumStr.isEmpty()) {
            textResult.setText("Input 2 numbers");
            return;
        }

        double num1 = Double.parseDouble(firstNumStr);
        double num2 = Double.parseDouble(secondNumStr);
        double result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    textResult.setText("Error");
                    return;
                }
                result = num1 / num2;
                break;
        }

        textResult.setText("Result: " + result);
    }
}