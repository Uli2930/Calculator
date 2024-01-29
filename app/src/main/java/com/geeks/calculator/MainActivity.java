package com.geeks.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer firstOperand, secondOperand;
    private Boolean isOperationClick;
    private String ulan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.btn_clear) {
            textView.setText("0");
        } else {
            String text = ((MaterialButton) view).getText().toString();

            if (textView.getText().toString().equals("0") || isOperationClick) {
                textView.setText(text);
            } else {
                textView.append(text);
            }


        }
        isOperationClick = false;

    }

    public void onOperation0nClick(View view) {
        String currentText = textView.getText().toString();
        isOperationClick = true;

        if (view.getId() == R.id.btn_plus) {
            firstOperand = Integer.valueOf(currentText);
            ulan = "+";
        } else if (view.getId() == R.id.btn_minus) {
            firstOperand = Integer.valueOf(currentText);
            ulan = "-";
        } else if (view.getId() == R.id.btn_division) {
            firstOperand = Integer.valueOf(currentText);
            ulan = "/";
        } else if (view.getId() == R.id.btn_multiplication) {
            firstOperand = Integer.valueOf(currentText);
            ulan = "*";
        } else if (view.getId() == R.id.btn_equal) {
            secondOperand = Integer.valueOf(currentText);
            int result = calculateResult(firstOperand, secondOperand, ulan);
            textView.setText(String.valueOf(result));
            isOperationClick = false;
        }

    }

    private int calculateResult(int firstOperand, int secondOperand, String operator) {
        switch (operator) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    return 0;
                }
            case "*":
                return firstOperand * secondOperand;
            default:
                return 0;

        }
    }
}