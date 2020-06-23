package com.example.sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class sensor2 extends AppCompatActivity implements SensorEventListener {
private TextView tvalor;
private SensorManager sensorManager;
private Sensor sensor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor2);

        int position = getIntent().getIntExtra("position", 0);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        sensor = sensorList.get(position);
        tvalor = (TextView) findViewById(R.id.txtValor);
        super.onResume();
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
            StringBuffer sb = new StringBuffer();
            for (int i=0; i < sensorEvent.values.length; i++)
            {
                sb.append(i).append(": ").append(sensorEvent.values[i]).append("\n");
            }
            tvalor.setText(sb.toString());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
