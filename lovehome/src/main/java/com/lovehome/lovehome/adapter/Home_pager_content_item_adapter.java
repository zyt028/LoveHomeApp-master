package com.lovehome.lovehome.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.lovehome.lovehome.activity.Home_Pager_to_item;
import com.lovehome.lovehome.model.Home_pager_item_entity;

import java.util.ArrayList;

/*
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_content_item_adapter extends PagerAdapter {

    private Context context;
    private ArrayList<Home_pager_item_entity> list;
    private LinearLayout ll;
    public static int page;

    public Home_pager_content_item_adapter(ArrayList<Home_pager_item_entity> list, Context context, LinearLayout ll) {
        this.list = list;
        this.context = context;
        this.ll = ll;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        GridView view = new GridView(context);
        view.setAdapter(new Home_pager_content_gridview_adapter(context, list, position));
        view.setNumColumns(4);
        container.addView(view);
        view.setOnItemClickListener(new ItemOnClick());
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return (list.size() / 8) + 1;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private class ItemOnClick implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(context, Home_Pager_to_item.class);
            if (page > 0) {
                intent.putExtra("name", list.get(i + 8).getParent_cate_name());
            } else {
                intent.putExtra("name", list.get(i).getParent_cate_name());
            }
            context.startActivity(intent);
        }
    }
}
