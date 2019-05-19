package com.example.androidapp;

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
        final RNG randomNo = new RNG(1, 20);


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
                generatedNumber.setText(rngNumber);

            }
        });

    }
}
