package com.lovehome.publish.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lovehome.publish.R;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Release_Fangchan_Activity  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_fangchan_layout);

        Bundle bundle=getIntent().getExtras();
        String message=bundle.getString("message");
        //String parentct=bundle.getString("parentct");
        TextView tv=(TextView) findViewById(R.id.child_classify_text);
        //TextView pct=(TextView) findViewById(R.id.parent_classify_text);
        tv.setText(message);
        //pct.setText(parentct);
    }
}