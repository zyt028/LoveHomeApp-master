package com.lovehome.lovehome.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.lovehome.lovehome.R;

/**
 * Created by Jerry Mouse on 2016/8/10.
 */
public class Home_Pager_MyNews extends Activity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_pager_mynews_layout);

        imageButton= (ImageButton) findViewById(R.id.HomePager_MyNews_back);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
