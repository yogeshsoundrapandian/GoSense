package com.bluetheta.gosense;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * Created by yogesh on 21/08/2016.
 */
public class tfmcall extends Activity {
    public TextView tv, tvnum;
    int n = -1, i = 0, t = 0, z;
    long m = 0;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tfmcm);
        tv = (TextView) findViewById(R.id.tvn);
        tvnum = (TextView) findViewById(R.id.tvnum);
    }

    @SuppressLint("MissingPermission")
    public boolean dispatchKeyEvent(KeyEvent e) {
        int a = e.getAction();
        int c = e.getKeyCode();
        if (c == KeyEvent.KEYCODE_VOLUME_DOWN)
            if (a == KeyEvent.ACTION_DOWN) {
                n = n + 1;
                if (n >= 10)
                    n = 0;
                tv.setText(String.valueOf(n));
                z = 0;
                timer();
            }
        if (c == KeyEvent.KEYCODE_VOLUME_UP)
            if (a == KeyEvent.ACTION_DOWN) {
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + number));
                startActivity(i);
                n=0;
                number=null;
            }
        return true;
    }

    public void assign()
    {
            if (i >=1)
            {
                m = (m * 10) + n;
                number = "" + m;
                n = 0;
            } else
            {
                m = n;
                number = "" + m;
                n = 0;
            }
            tvnum.setText(String.valueOf(number));
    }
    public void timer()
    {
        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(z<1)
                {
                    assign();
                    z++;
                    i++;
                }
            }
        },3000);
    }

}