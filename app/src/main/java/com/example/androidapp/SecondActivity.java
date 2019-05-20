package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        final TextView lightText = findViewById(R.id.lightResult);
        final TextView rngText = findViewById(R.id.rngResult);

        String lightStatus;
        boolean lightVal = b.getBoolean("LIGHT");
        String rngValue = Integer.toString(b.getInt("RNG"));


        if(lightVal) {
            lightStatus = "ON";
        } else {
            lightStatus = "OFF";
        }

        lightText.setText("Light status: " + lightStatus);
        rngText.setText("Number value:" + rngValue);


    }
}
