package com.lovehome.publish.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lovehome.publish.R;
import com.lovehome.publish.entity.Release_pager_entity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class MainActivity_Release_Adapter extends BaseAdapter{
    private   Context context;
    private ArrayList<Release_pager_entity> list;


    public MainActivity_Release_Adapter(Context context,ArrayList<Release_pager_entity>list) {
        this.context = context;
        this.list=list;

    }
    @Override
    public int getCount() {

        return list.size();
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
            view = View.inflate(context, R.layout.release_gridview_page_layout, null);
            holder.image = (ImageView) view.findViewById(R.id.Release_content_GridView_Page_image);
            holder.text = (TextView) view.findViewById(R.id.Release_content_GridView_Page_text);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

                Release_pager_entity info = list.get(i);
                Picasso.with(context).load(info.getParent_cate_img_url()).into(holder.image);
                holder.text.setText(info.getParent_cate_name());



        return view;
    }

    private class ViewHolder {
        private TextView text;
        private ImageView image;
    }
}
