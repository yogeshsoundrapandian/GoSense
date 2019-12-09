package com.bluetheta.gosense;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

/**
 * Created by yogesh on 21/08/2016.
 */
public class tim extends Activity implements View.OnClickListener{
    public ImageButton lt,sp,sa,pu,help,au;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tim);
        lt=(ImageButton)findViewById(R.id.location);
        sp=(ImageButton)findViewById(R.id.shake);
        sa=(ImageButton)findViewById(R.id.sound);
        pu=(ImageButton)findViewById(R.id.pushup);
        help=(ImageButton)findViewById(R.id.help);
        au=(ImageButton)findViewById(R.id.aboutus);
        lt.setOnClickListener(this);
        sp.setOnClickListener(this);
        sa.setOnClickListener(this);
        pu.setOnClickListener(this);
        help.setOnClickListener(this);
        au.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.location)
        {
                Intent i =new Intent(tim.this,location.class);
            startActivity(i);
        }
        if(v.getId()==R.id.shake)
        {}
        if(v.getId()==R.id.sound)
        {
            Intent i=new Intent(tim.this,sound.class);
            startActivity(i);
        }
        if(v.getId()==R.id.pushup)
        {
            Intent i=new Intent(tim.this,pushup.class);
            startActivity(i);
        }
        if(v.getId()==R.id.help)
        {}
        if(v.getId()==R.id.aboutus)
        {}
    }
    public boolean dispatchKeyEvent(KeyEvent e)
    {
        int a=e.getAction();
        int c=e.getKeyCode();
        if(c==KeyEvent.KEYCODE_VOLUME_DOWN)
            if(a==KeyEvent.ACTION_DOWN)
            {
                Intent i = new Intent(tim.this,tfm.class);
                startActivity(i);
            }
        return true;
    }
}
