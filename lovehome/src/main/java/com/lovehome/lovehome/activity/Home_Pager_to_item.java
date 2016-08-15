package com.lovehome.lovehome.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lovehome.lovehome.R;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_Pager_to_item extends Activity{

    private TextView HomePager_item_layout_title,HomePager_item_layout_smalltitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_item_layout);

        initView();

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        HomePager_item_layout_title.setText(name);
        HomePager_item_layout_smalltitle.setText(name);
    }

    private void initView() {
        HomePager_item_layout_title= (TextView) findViewById(R.id.HomePager_item_layout_title);
        HomePager_item_layout_smalltitle= (TextView) findViewById(R.id.HomePager_item_layout_smalltitle);
    }
}
