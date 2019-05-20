package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        final TextView passedValue = findViewById(R.id.listValue);

        Intent intent = getIntent();

        String valueFromSecondActivity = intent.getStringExtra("item");

        passedValue.setText(valueFromSecondActivity);


    }
}
