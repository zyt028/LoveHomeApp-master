package com.lovehome.publish.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lovehome.publish.R;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Release_Currency_Activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_currency_layout);

        Bundle bundle=getIntent().getExtras();
        String message=bundle.getString("message");
        TextView tv=(TextView) findViewById(R.id.child_classify_text);
        tv.setText(message);
    }
}
