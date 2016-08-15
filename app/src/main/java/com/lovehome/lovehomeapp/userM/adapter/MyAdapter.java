package com.lovehome.lovehomeapp.userM.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lovehome.lovehomeapp.R;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    int[] myimg={R.mipmap.img_my_fragment_release_left, R.mipmap.img_my_fragment_draft_left,R.mipmap.img_my_fragment_collection_left
            ,R.mipmap.img_my_fragment_msg_left,R.mipmap.img_my_fragment_stament_left,R.mipmap.img_my_fragment_about_left
            ,R.mipmap.img_my_fragment_share_left,R.mipmap.img_my_fragment_password_left,R.mipmap.img_my_fragment_buffer_left};
    String[] option={"我的发布","我的草稿","我的收藏","我的消息","平台声明","关于“爱家乡”","分享软件","修改密码","清除缓存"};
   public MyAdapter(Context context){
       this.context=context;
   }
    @Override
    public int getCount() {
        return myimg.length;
    }

    @Override
    public Object getItem(int i) {
        return option[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       /* ViewHolder holder=null;
        if(view==null){
            view= LayoutInflater.from(context).inflate(R.layout.my_option_item,null);
            holder.imgView= (ImageView) view.findViewById(R.id.myimg);
            holder.textView= (TextView) view.findViewById(R.id.mytex);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        holder.imgView.setImageResource(img[i]);
        holder.textView.setText(option[i]);
        return view;
    }
    static  class ViewHolder{
        ImageView imgView;
        TextView textView;
    }*/
        view= LayoutInflater.from(context).inflate(R.layout.my_option_item,null);
        ImageView img= (ImageView) view.findViewById(R.id.myimg);
        img.setImageResource(myimg[i]);
        TextView tex= (TextView) view.findViewById(R.id.mytex);
        tex.setText(option[i]);
        if(i==4){
            view= LayoutInflater.from(context).inflate(R.layout.list_virw_line,null);
        }
        return view;
    }
}
