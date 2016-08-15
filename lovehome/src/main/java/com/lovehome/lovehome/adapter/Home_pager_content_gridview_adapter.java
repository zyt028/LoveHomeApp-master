package com.lovehome.lovehome.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lovehome.lovehome.R;
import com.lovehome.lovehome.model.Home_pager_item_entity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_content_gridview_adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Home_pager_item_entity> list;
    private int page;
    Home_pager_item_entity info;

    public Home_pager_content_gridview_adapter(Context context, ArrayList<Home_pager_item_entity> list, int page) {
        this.context = context;
        this.list = list;
        this.page = page;
    }


    @Override
    public int getCount() {
        if (page == 0) {
            return 8;
        } else {
            return 7;
        }
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.home_pager_content_gridvie_item, null);
            holder.image = (ImageView) view.findViewById(R.id.HomePager_content_GridView_item_image);
            holder.text = (TextView) view.findViewById(R.id.HomePager_content_GridView_item_text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        switch (page) {
            case 0: {
                info = list.get(i);
                Picasso.with(context).load(info.getParent_cate_img_url()).into(holder.image);
                holder.text.setText(info.getParent_cate_name());
            }
            break;
            case 1: {
                int s = i + 8;
                if (s < 15) {
                    info = list.get(s);
                    Picasso.with(context).load(info.getParent_cate_img_url()).into(holder.image);
                    holder.text.setText(info.getParent_cate_name());
                }
            }
            break;
        }
        return view;
    }

    private class ViewHolder {
        private TextView text;
        private ImageView image;
    }
}
