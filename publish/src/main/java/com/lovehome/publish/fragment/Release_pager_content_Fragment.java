package com.lovehome.publish.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;

import com.lovehome.publish.R;
import com.lovehome.publish.activity.Release_Bianming_Activity;
import com.lovehome.publish.activity.Release_Currency_Activity;
import com.lovehome.publish.activity.Release_Fangchan_Activity;
import com.lovehome.publish.activity.Release_Fangchan_Zuping_Activity;
import com.lovehome.publish.activity.Release_Gongzuo_Activity;
import com.lovehome.publish.activity.Release_Laoxianghui_Activity;
import com.lovehome.publish.activity.Release_Meishi_Activity;
import com.lovehome.publish.activity.Release_Tiaozao_Activity;
import com.lovehome.publish.adapter.MainActivity_Release_Adapter;
import com.lovehome.publish.entity.Release_pager_entity;
import com.lovehome.publish.util.GsonUtil;
import com.lovehome.publish.util.HttpUtil;

import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/8/10 0010.
 */

public class Release_pager_content_Fragment extends Fragment{
    //int k;
    //String[] parentc;
    private View view2;
    private View view3;
    private GridView gridview;//gridview的点击事件
    private ListView list;//listview的点击事件
    private ImageView error_btn;
    PopupWindow pop;
    String [][] msg={{"酒店","饭店","西点","夜宵","外卖","茶馆","零食特产","其他","小吃"},
                     {"KTV","电影","酒吧","宾馆","足底按摩","其他"},
                     {"买卖","租赁","其他"},
                     {"买卖","租赁","代驾","学车","修理","其他"},
                     {"礼仪庆典","婚车","摄影","鲜花","其他"},
                     {"家/公装","建材家居","装修工人","其他"},
                     {"学校","培训","家教","其他"},
                     {"全职","兼职","钟点工","临时工","其他"},
                     {"手机","服装","食品","酒水","数码电器","母婴玩具","美容美发","珠宝配饰","办公耗材","家居家纺","日用品","其他"},
                     {"家具电器","服装箱包","手表珠宝","办公设施","其他"},
                     {"投资担保","咨询顾问","演出会展","其他"},
                     {"便民","其他"},
                     {"老乡会公告"},
                     {"兰州拉面","沙县小吃","过桥米线","水煮活鱼","黄焖鸡米饭","衡阳螺蛳粉","其他"},
                     {"家政","信息","旅游","运动","医疗","丧事","其他"}};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view2=inflater.inflate(R.layout.release_pager_content_layout,null);
        initView();
        initData();
        return view2;
    }

    //PopupWindow
    private void ShowPopupWindow(){
        pop = new PopupWindow(view3, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        pop.setBackgroundDrawable(new BitmapDrawable());//设置背景....
        pop.setFocusable(true);//调焦
        pop.setOutsideTouchable(true);//触摸
        pop.showAtLocation(view2,Gravity.BOTTOM,0,0);//距离控件位置
    }

    int childct;
    private void initView(){
        gridview =(GridView)view2.findViewById(R.id.release_gridview);
        //GridView中的数据的点击事件
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                view3 = LayoutInflater.from(getActivity(

                )).inflate(R.layout.release_popupwindow_list_layout, null);
                list=(ListView) view3.findViewById(R.id.PopupWindow_listview);
                list.setAdapter(new popInfo(getActivity(),msg,i));
                ShowPopupWindow();
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view,final int j, long l) {
                        childct=j;
                        /*
                        for (k=0;k<msg[i].length;k++){
                            parentc=msg[i];
                            Log.e("TAGG","HAHAH:"+parentc[k]);
                        }*/
                        Bundle bundle = new Bundle();
                        //bundle.putString("parentct", parentc[k]);
                        bundle.putString("message", msg[i][childct]);
                        Intent intent = new Intent();
                        intent.putExtras(bundle);
                        if(i==0||i==13){
                            intent.setClass(getActivity(), Release_Meishi_Activity.class);
                        }else if (i==1||i==3||i==4||i==5||i==6||i==8||i==10||i==14){
                            intent.setClass(getActivity(), Release_Currency_Activity.class);
                        }else if (i==2){
                            if (j!=1){
                                intent.setClass(getActivity(),Release_Fangchan_Activity.class);
                            }
                        }else if (i==7){
                            intent.setClass(getActivity(), Release_Gongzuo_Activity.class);
                        }else if (i==9){
                            intent.setClass(getActivity(), Release_Tiaozao_Activity.class);
                        }else if (i==11){
                            intent.setClass(getActivity(), Release_Bianming_Activity.class);
                        }else if (i==12){
                            intent.setClass(getActivity(), Release_Laoxianghui_Activity.class);
                        }else if (i==2&&j==1){
                            intent.setClass(getActivity(), Release_Fangchan_Zuping_Activity.class);
                        }
                        startActivity(intent);
                    }
                });

                error_btn=(ImageView)view3.findViewById(R.id.pop_error);
                error_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop.dismiss();
                    }
                });
            }
        });

    }

    //为获取数据做操作
    public void initData() {
        HttpUtil.getURLData().getItem(new JsonHttpResponseHandler() {
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                //数据进行封装
                ArrayList<Release_pager_entity> date = GsonUtil.Gson(response);
                //数据填充至Gridview
                gridview.setAdapter(new MainActivity_Release_Adapter(getContext(),date));
            }
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }

    //点击Gridview所展示布局的适配
    private class popInfo extends BaseAdapter{

        private String[][] info;
        private int group;
        private Context context;

        public popInfo(Context context,String[][] info,int i) {
            this.info = info;
            this.group=i;
            this.context=context;
        }
        @Override
        public int getCount() {return info[group].length;}
        @Override
        public Object getItem(int i) {return info[group][i];}
        @Override
        public long getItemId(int i) {return i;}
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder=null;
            if(view==null){
                holder=new ViewHolder();
                view=LayoutInflater.from(getActivity()).inflate(R.layout.release_popupwindow_list_content_layout,null);
                holder.PopupWindow_listview_text= (TextView) view.findViewById(R.id.PopupWindow_listview_text);
                view.setTag(holder);
            }else{
                holder= (ViewHolder) view.getTag();
            }
            holder.PopupWindow_listview_text.setText(info[group][i]);
            return view;
        }
    }

    private class ViewHolder{
        TextView PopupWindow_listview_text;
    }

}
