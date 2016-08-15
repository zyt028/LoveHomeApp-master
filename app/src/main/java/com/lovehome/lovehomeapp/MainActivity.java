package com.lovehome.lovehomeapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lovehome.lovehome.fragment.Home_pager_content_Fragment;
import com.lovehome.lovehome.fragment.LoveHome;
import com.lovehome.lovehomeapp.userM.UserIndex;
import com.lovehome.lovehomeapp.utils.BlankFragment;
import com.lovehome.publish.fragment.Publish;
import com.lovehome.publish.fragment.Release_pager_content_Fragment;

public class MainActivity extends FragmentActivity {

    private SharedPreferences sp;
    private FragmentManager fm; //碎片管理器
    private FragmentTransaction ft;//碎片事务
    private ImageView HomePager_button_lovehome_image, HomePager_button_shared_image, HomePager_button_my_image;
    private LinearLayout HomePager_button_loveHome, HomePager_button_shared, HomePager_button_my;


    /**
     * 用于底部选项颜色的更改
     * @author Jerry Mouse
     * @time 2016/8/10 11:09
     * @effect
     */
    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            HomePager_button_lovehome_image.setImageResource(R.mipmap.home);
            HomePager_button_shared_image.setImageResource(R.mipmap.publish);
            HomePager_button_my_image.setImageResource(R.mipmap.wode);
            FragmentTransaction ft2 = fm.beginTransaction();
            switch (view.getId()) {
                case R.id.HomePager_button_loveHome: {
                    HomePager_button_lovehome_image.setImageResource(R.mipmap.home_press);
                    ft2.replace(R.id.HomePager_layout_title, new LoveHome());
                    ft2.replace(R.id.HomePager_layout_content, new Home_pager_content_Fragment());
                    ft2.commit();
                    break;
                }
                case R.id.HomePager_button_shared: {
                    HomePager_button_shared_image.setImageResource(R.mipmap.publish_press);
                    ft2.replace(R.id.HomePager_layout_title, new Publish());
                    ft2.replace(R.id.HomePager_layout_content,new Release_pager_content_Fragment());
                    ft2.commit();
                    break;
                }
                case R.id.HomePager_button_my: {
                    HomePager_button_my_image.setImageResource(R.mipmap.wode_press);
                    ft2.replace(R.id.HomePager_layout_title,new BlankFragment());
                    ft2.replace(R.id.HomePager_layout_content,new UserIndex());
                    ft2.commit();
                    break;
                }

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        sp = this.getSharedPreferences("userInfo", Activity.MODE_APPEND);
       SharedPreferences.Editor ed=sp.edit();
        ed.putString("accunt","NA");
        //初始化控件
        initView();


    }

    /**
     * 用来初始化控件
     * @author Jerry Mouse
     * @time 2016/8/9 2:28
     * @effect
     */
    private void initView() {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.replace(R.id.HomePager_layout_title, new LoveHome());
        ft.replace(R.id.HomePager_layout_content, new Home_pager_content_Fragment());
        ft.commit();

        HomePager_button_lovehome_image = (ImageView) findViewById(R.id.HomePager_button_lovehome_image);
        HomePager_button_shared_image = (ImageView) findViewById(R.id.HomePager_button_shared_image);
        HomePager_button_my_image = (ImageView) findViewById(R.id.HomePager_button_my_image);

        HomePager_button_loveHome = (LinearLayout) findViewById(R.id.HomePager_button_loveHome);
        HomePager_button_shared = (LinearLayout) findViewById(R.id.HomePager_button_shared);
        HomePager_button_my = (LinearLayout) findViewById(R.id.HomePager_button_my);
        HomePager_button_loveHome.setOnClickListener(click);
        HomePager_button_shared.setOnClickListener(click);
        HomePager_button_my.setOnClickListener(click);
        HomePager_button_lovehome_image.setImageResource(R.mipmap.home_press);

    }

}
