package com.example.parthmodilab2;


import static java.util.logging.Logger.global;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import java.util.Arrays;
import java.util.Collections;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.util.Log;
import android.widget.RadioButton;
import java.lang.Math;

public class Accelerometer extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Accelerometer";
    private SensorManager sensorManager1;
    private Sensor sensor1;
    double result = 0;
    private double max;
    double result_prev;
    private long last_update;
    private int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        sensorManager1 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor1 = sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager1.registerListener(Accelerometer.this, sensor1, SensorManager.SENSOR_DELAY_UI);
        last_update = System.currentTimeMillis();

   }
    protected void onPause() {
        super.onPause();
        sensorManager1.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        RadioButton button1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton button2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton button3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton button4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton button5 = (RadioButton) findViewById(R.id.radioButton5);
        RadioButton button6 = (RadioButton) findViewById(R.id.radioButton6);
        RadioButton button7 = (RadioButton) findViewById(R.id.radioButton7);

        float xsquared;
        float ysquared;
        float zsquared;

        double acceleration;


        xsquared = sensorEvent.values[0] * sensorEvent.values[0];
        ysquared = sensorEvent.values[1] * sensorEvent.values[1];
        zsquared = sensorEvent.values[2] * sensorEvent.values[2];
        acceleration = Math.sqrt(xsquared + ysquared + zsquared);


        if(max>100 && acceleration<10 && count >= 75){max = 0; count = 0;}
        else count++;

        if(acceleration>35){
            max += acceleration;
            return;
        }

        if(acceleration<35){
            if (max<100)  {result = 0;}
            if (max>100 && max<175) {result = 1;}// if(result_prev<result) return;}
            if (max>175 && max<250) {result = 2;}// if(result_prev<result) return;}
            if (max>250 && max<325) {result = 3;}// if(result_prev<result) return;}
            if (max>325 && max<400) {result = 4;}// if(result_prev<result) return;}
            if (max>400 && max<475) {result = 5;}// if(result_prev<result) return;}
            if (max>475 && max<550) {result = 6;}// if(result_prev<result) return;}
            if (max>550) {result = 7;}// if(result_prev<result) return;}
        }

        if (result == 0) {
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(false);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);
        }
        if (result ==1) {
            button1.setChecked(true);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(false);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);

        }
        if (result == 2) {
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(false);
            button4.setChecked(false);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);
        }
        if (result == 3) {
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(false);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);
        }
        if (result == 4) {
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);
        }
        if (result == 5) {
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(false);
            button7.setChecked(false);
        }
        if (result == 6) {
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(true);
            button7.setChecked(false);
        }
        if (result == 7) {
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(true);
            button7.setChecked(true);
        }
        result_prev = result;
        Log.d(TAG, "onSensorChanged: Acceleration: " + count);
    }
}