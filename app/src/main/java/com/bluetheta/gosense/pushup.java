package com.bluetheta.gosense;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by yogesh on 21/08/2016.
 */
public class pushup extends Activity implements SensorEventListener {
    public TextView c1,c2,c3;
    SensorManager sm;
    Sensor ps;
    int z=0,n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pushup);
        c1=(TextView)findViewById(R.id.c1);
        c2=(TextView)findViewById(R.id.c2);
        c3=(TextView)findViewById(R.id.c3);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        ps=sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this,ps,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        z++;
        if((z%2)==0)
        {
            n++;
            count(n);
        }
    }
    private void count(int n) {
        int count1,count2,count3 = 0;
        count1=n%10;
        count2=n/10;
        if (n>100)
        count3=n/100;
        c1.setText(String.valueOf(count1));
        c2.setText(String.valueOf(count2));
        c3.setText(String.valueOf(count3));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
