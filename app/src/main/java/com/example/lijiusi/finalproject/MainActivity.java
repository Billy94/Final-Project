package com.example.lijiusi.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView restaurantTextView = findViewById(R.id.restaurantTextView);
        Button randomBotton = findViewById(R.id.randomBotton);
        randomBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                restaurantTextView.setText(RestaurantArr.generateRandom().getName());
            }
        });
    }
}
