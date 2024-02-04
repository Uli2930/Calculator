package com.geeks.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnDestroy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String resultFromMain = getIntent().getStringExtra("key");
        tvResult = findViewById(R.id.tv_result);
        btnDestroy = findViewById(R.id.btn_next);
        tvResult.setText(resultFromMain);

        btnDestroy.setOnClickListener(v -> {
            finishAffinity();


        });


        }
        }


