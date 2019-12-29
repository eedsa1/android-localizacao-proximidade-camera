package com.eric.aula_ufc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximityActivity extends AppCompatActivity implements SensorEventListener {

    private TextView lblProximidade;
    private SensorManager sensorManager;
    private Sensor proximitySensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);

        lblProximidade = (TextView)findViewById(R.id.lblProximidade);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor.getType() == Sensor.TYPE_PROXIMITY){
            lblProximidade.setText(""+sensorEvent.values[0]);

            if(sensorEvent.values[0]<proximitySensor.getMaximumRange()){
                getWindow().getDecorView().setBackgroundColor(Color.RED);
            }
            else{
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, proximitySensor, sensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
