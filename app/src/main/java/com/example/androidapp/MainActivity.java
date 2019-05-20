package com.example.androidapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidapp.Objects.RNG;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private boolean isOn;
    final RNG randomNo = new RNG(1, 20);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Top half
        constraintLayout = findViewById(R.id.layout);
        final TextView text = findViewById(R.id.text1);
        final Button button = findViewById(R.id.button1);
        isOn = false;

        //Bottom half
        final TextView rngHeader = findViewById(R.id.rngHeader);
        final Button generate = findViewById(R.id.generateBtn);
        final TextView generatedNumber = findViewById(R.id.randomNumber);


        //Navigation
        final Button navigate = findViewById(R.id.navigateBtn);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOn) {
                    text.setText("Lights out");
                    text.setTextColor(Color.WHITE);
                    rngHeader.setTextColor(Color.WHITE);
                    generatedNumber.setTextColor(Color.WHITE);
                    button.setText("Turn on");
                    constraintLayout.setBackgroundColor(Color.BLACK);
                    isOn = false;
                    return;
                }

                text.setText("Let there be light!");
                text.setTextColor(Color.BLACK);
                rngHeader.setTextColor(Color.BLACK);
                generatedNumber.setTextColor(Color.BLACK);
                button.setText("Turn off");
                constraintLayout.setBackgroundColor(Color.YELLOW);
                isOn = true;

            }
        });

        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rngNumber = Integer.toString(randomNo.generate());
                randomNo.setNumber(Integer.parseInt(rngNumber));
                generatedNumber.setText(rngNumber);

            }
        });

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               passData();
            }
        });

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        //Essentially overrides the onCreate() method, as it's called after it
//        constraintLayout.setBackgroundColor(Color.GRAY);
//    }

    private void passData() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        Bundle b = new Bundle();

        b.putInt("RNG", randomNo.getNumber());
        b.putBoolean("LIGHT", isOn);

        intent.putExtras(b);
        startActivity(intent);
    }

}
