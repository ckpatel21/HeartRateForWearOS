package com.example.heartratewearos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;

import com.example.heartratewearos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensor;

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        init();
    }
    private void init() {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BODY_SENSORS},5);
        }

        sensorManager = (SensorManager) getSystemService(getApplicationContext().SENSOR_SERVICE);

        if(sensorManager != null){
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_HEART_RATE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(sensor!=null){
        }
    }
}