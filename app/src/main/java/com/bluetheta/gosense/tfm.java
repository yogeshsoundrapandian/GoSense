package com.bluetheta.gosense;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

/**
 * Created by yogesh on 21/08/2016.
 */
public class tfm extends Activity {
    public TextView op1,op2;
    int n=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tfm);
        op1=(TextView)findViewById(R.id.op1);
        op2=(TextView)findViewById(R.id.op2);
    }
    public boolean dispatchKeyEvent(KeyEvent e)
    {
        int a=e.getAction();
        int c=e.getKeyCode();
        if(c==KeyEvent.KEYCODE_VOLUME_DOWN)
            if(a==KeyEvent.ACTION_DOWN)
            {
                if(n>2)
                    n=0;
                n=n+1;
                if(n==1)
                {
                    op1.setText(String.valueOf("|"));
                    op2.setText(String.valueOf(""));
                }
                if(n==2)
                {
                    op1.setText(String.valueOf(""));
                    op2.setText(String.valueOf("|"));
                }
            }
        if(c==KeyEvent.KEYCODE_VOLUME_UP)
            if(a==KeyEvent.ACTION_DOWN)
            {
                option();
            }
        return true;
    }

    private void option() {
        if(n==1)
        {
            Intent i=new Intent(tfm.this,tfmcall.class);
            startActivity(i);
        }
        if(n==2)
        {
        }
    }
}
