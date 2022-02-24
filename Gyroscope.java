package com.example.parthmodilab2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import java.lang.Math;
import java.sql.Timestamp;

public class Gyroscope extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Gyroscope";
    private SensorManager sensorManager3;
    private Sensor sensor3;
    private long last_update;
    private double sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope);

        sensorManager3 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor3 = sensorManager3.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        sensorManager3.registerListener(Gyroscope.this, sensor3, SensorManager.SENSOR_DELAY_UI);

        last_update = System.currentTimeMillis();
    }
    protected void onPause() {
        super.onPause();
        sensorManager3.unregisterListener(this);
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

        long actual_time;
        long time_elapsed;
        double rotation_degree;
        if(sum>0 && sensorEvent.values[2]<-0.2) sum = 0;
        if(sum<0 && sensorEvent.values[2]>0.2) sum = 0;

        actual_time = System.currentTimeMillis();

        if(sensorEvent.values[2]>0.1 || sensorEvent.values[2]<-0.1){

            time_elapsed = actual_time-last_update;
            rotation_degree = sensorEvent.values[2]*time_elapsed;
            sum += rotation_degree;
            last_update = actual_time;
            Log.d(TAG, "onSensorChanged: rotation: " + sum);
            return;
        }




        if (sum>-500 && sum<500 )
        {
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(true);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);
        }
        if(sum<-500 && sum > -1400){
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(false);
            button7.setChecked(false);

        }
        if(sum<-1400 && sum>-1900){
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(true);
            button7.setChecked(false);

        }
        if(sum<-1900){
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(true);
            button7.setChecked(true);

        }
        if(sum>500 && sum<1400){
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);

        }
        if(sum>1400 && sum<1900){
            button1.setChecked(false);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);

        }
        if(sum>1900){
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);

        }


        last_update = System.currentTimeMillis();



    }
}