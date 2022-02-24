package com.example.parthmodilab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button Accelero;
    private Button Gyro;
    private Button Proxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Accelero = findViewById(R.id.button);
        Gyro = findViewById(R.id.button2);
        Proxi = findViewById(R.id.button3);

        Accelero.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Accelerometer.class);
                startActivity(intent);
            }
        });



        Gyro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Gyroscope.class);
                startActivity(intent);
            }
        });


        Proxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Proximity.class);
                startActivity(intent);
            }
        });
    }
}