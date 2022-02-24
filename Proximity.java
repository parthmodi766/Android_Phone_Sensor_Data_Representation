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

public class Proximity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "Proximity";
    private SensorManager sensorManager2;
    private Sensor sensor2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        sensorManager2 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor2 = sensorManager2.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sensorManager2.registerListener(Proximity.this, sensor2, SensorManager.SENSOR_DELAY_NORMAL);

    }

    protected void onPause() {
        super.onPause();
        sensorManager2.unregisterListener(this);
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

        if(sensorEvent.values[0] == 5.0){
            button1.setChecked(false);
            button2.setChecked(false);
            button3.setChecked(false);
            button4.setChecked(false);
            button5.setChecked(false);
            button6.setChecked(false);
            button7.setChecked(false);
        }

        if(sensorEvent.values[0] == 0.0){
            button1.setChecked(true);
            button2.setChecked(true);
            button3.setChecked(true);
            button4.setChecked(true);
            button5.setChecked(true);
            button6.setChecked(true);
            button7.setChecked(true);
        }

        Log.d(TAG, "onSensorChanged: Value: " + sensorEvent.values[0] );

    }

}