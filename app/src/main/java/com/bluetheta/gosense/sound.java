package com.bluetheta.gosense;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.media.MediaRecorder;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by yogesh on 21/08/2016.
 */
public class sound extends Activity implements View.OnClickListener{
    public Button start,stop;
    public EditText ph;
    SoundMeter sm=new SoundMeter();
    private Handler mh=new Handler();
    private Runnable rm= new Runnable()
    {
        @Override
        public void run() {
            sm.start();
            double amp=sm.getAmplitude();
            if(amp>8)
                alert();
            mh.postDelayed(rm,300);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sound);
        start=(Button)findViewById(R.id.start);
        stop=(Button)findViewById(R.id.stop) ;
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        ph=(EditText)findViewById(R.id.phone);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.start)
        {
            mh.postDelayed(rm,300);
        }
        if(v.getId()==R.id.stop)
        {
            sm.stop();
        }
    }

    public class SoundMeter {
        private MediaRecorder mRecorder = null;
        public void start() {
            if (mRecorder == null) {
                mRecorder = new MediaRecorder();
                mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                mRecorder.setOutputFile("/dev/null");
                try {
                    mRecorder.prepare();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mRecorder.start();
            }
        }
        public void stop() {
            if (mRecorder != null) {
                mRecorder.stop();
                mRecorder.release();
                mRecorder = null;
            }
        }
        public double getAmplitude() {
            if (mRecorder != null)
                return  (mRecorder.getMaxAmplitude()/2700.0);
            else
                return 0;
        }
    }
    public void alert()
    {
        sm.stop();
        Toast.makeText(getApplicationContext(),"NOISE DETECTED",Toast.LENGTH_LONG).show();
        String num=ph.getText().toString();
        Intent call=new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse("tel:"+num));
        startActivity(call);
    }
}
