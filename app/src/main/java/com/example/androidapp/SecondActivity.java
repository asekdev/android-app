package com.example.androidapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private ListView numberArray;
    String[] values = new String[]{"Andy", "James", "Billy"};


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



        numberArray = findViewById(R.id.numbersList);
        final ArrayAdapter<String> numberAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, values);

        numberArray.setAdapter(numberAdapter);

        numberArray.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String pressedInput = values[position].toString();

                passListViewData(pressedInput);

            }
        });


        if(lightVal) {
            lightStatus = "ON";
        } else {
            lightStatus = "OFF";
        }

        lightText.setText("Light status: " + lightStatus);
        rngText.setText("Number value:" + rngValue);

    }

    private void passListViewData(String value) {

        Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);

        Bundle b = new Bundle();

        b.putString("item", value);

        intent.putExtras(b);
        startActivity(intent);

    }
}
