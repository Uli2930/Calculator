package com.geeks.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button switchButton;
    private Double firstOperand, secondOperand;
    private Boolean isOperationClick;
    private String ulan = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        switchButton = findViewById(R.id.btn_next_activity);

        switchButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("key", textView.getText().toString());
            startActivity(intent);


        });
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
        if (view.getId() == R.id.btn_equal) {
            switchButton.setVisibility(View.VISIBLE);
        } else if (view.getId() == R.id.btn_plus) {
            firstOperand = Double.valueOf(currentText);
            ulan = "+";
        } else if (view.getId() == R.id.btn_minus) {
            firstOperand = Double.valueOf(currentText);
            ulan = "-";
        } else if (view.getId() == R.id.btn_division) {
            firstOperand = Double.valueOf(currentText);
            ulan = "/";
        } else if (view.getId() == R.id.btn_multiplication) {
            firstOperand = Double.valueOf(currentText);
            ulan = "*";
        } else if (view.getId() == R.id.btn_equal) {
            secondOperand = Double.valueOf(currentText);
            double result = calculateResult(firstOperand, secondOperand, ulan);
            textView.setText(String.valueOf(result));
            isOperationClick = false;
        }

    }

    private double calculateResult(double firstOperand, double secondOperand, String operator) {
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

    public String cancelDouble(Double number) {
        String text = number.toString();
        if (text.substring(text.length() - 2).equals(".0")) {
            return text.substring(0, textView.length() - 2);
        } else {
            return number.toString();

        }
    }

}