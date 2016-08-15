package com.lovehome.lovehome.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Jerry Mouse on 2016/8/10.
 */
public class Home_pager_LunBo_ViewPager_adapter extends PagerAdapter {

    private Context content;
    private int[] image;

    public Home_pager_LunBo_ViewPager_adapter(Context content,int[] image) {
        this.content = content;
        this.image=image;
    }

    @Override
    public int getCount() {
        return 1000;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view=new ImageView(content);
        view.setImageResource(image[position%image.length]);
        view.setScaleType(ImageView.ScaleType.FIT_XY);
        container.addView(view);
        view.setOnClickListener(new ViewPageClick());
        return view;
    }

    private class ViewPageClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.baidu.com"));
            content.startActivity(intent);
        }
    }
}
