package com.lovehome.lovehome.adapter;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lovehome.lovehome.R;
import com.lovehome.lovehome.model.Home_pager_BusinessDetails_entity;
import com.lovehome.lovehome.model.Home_pager_bussinessImage_entity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by ZhouZhicheng on 2016/8/10.
 */
public class Home_laoxianghui_listview_adapter extends BaseAdapter {

    private int now;

    private ArrayList<Home_pager_BusinessDetails_entity> data;
    private ArrayList<Home_pager_bussinessImage_entity> image;
    private Context context;

    public Home_laoxianghui_listview_adapter(ArrayList<Home_pager_BusinessDetails_entity> data, ArrayList<Home_pager_bussinessImage_entity> image, Context context) {
        this.data = data;
        this.context = context;
        this.image=image;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        now = i;
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.home_laoxianghui_layout_item, null);
            holder = new ViewHolder();
            holder.imageview_dianjia = (ImageView) view.findViewById(R.id.Home_laoxianghui_list_image);
            holder.textview_dianming = (TextView) view.findViewById(R.id.Home_laoxianghui_list_StoreName);
            holder.textview_jiage = (TextView) view.findViewById(R.id.Home_laoxianghui_list_Price);
            holder.textview_didian = (TextView) view.findViewById(R.id.Home_laoxianghui_list_dizhi);
            holder.textview_shijian1 = (TextView) view.findViewById(R.id.Home_laoxianghui_list_Time);
            holder.Home_laoxianghui_list_call = (ImageButton) view.findViewById(R.id.Home_laoxianghui_list_call);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(image.get(i).getImg_url()).into(holder.imageview_dianjia);
        holder.textview_dianming.setText(data.get(i).getMerchant_name());
        holder.textview_jiage.setText("￥ " + data.get(i).getPer_capita_consumption()+"/"+data.get(i).getMeasure_unit());
        holder.textview_didian.setText(data.get(i).getBusiness_location());
        holder.textview_shijian1.setText(data.get(i).getOpening_time() + "-" + data.get(i).getClosing_time());

        holder.Home_laoxianghui_list_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("确定要拨打：" + data.get(now).getPhone());
                builder.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + data.get(now).getPhone()));
                        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;
                        }
                        context.startActivity(intent);
                    }
                });
                builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.create().show();
            }
        });
        return view;
    }

    private class ViewHolder {
        public ImageView imageview_dianjia;
        private ImageButton Home_laoxianghui_list_call;
        public TextView textview_dianming,textview_jiage,textview_didian,textview_shijian1;

    }
}
