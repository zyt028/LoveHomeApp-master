package com.lovehome.lovehomeapp.userM;


import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lovehome.lovehomeapp.R;
import com.lovehome.lovehomeapp.login.ForgetPwdActiivity;
import com.lovehome.lovehomeapp.login.LoginUi;
import com.lovehome.lovehomeapp.userM.adapter.MyAdapter;
import com.lovehome.lovehomeapp.userM.other_activity.AsLoveHome;
import com.lovehome.lovehomeapp.userM.other_activity.MyCollect;
import com.lovehome.lovehomeapp.userM.other_activity.MyDraft;
import com.lovehome.lovehomeapp.userM.other_activity.MyNews;
import com.lovehome.lovehomeapp.userM.other_activity.MyPublish;
import com.lovehome.lovehomeapp.userM.other_activity.State;
import com.lovehome.lovehomeapp.userM.other_activity.UserDa;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserIndex extends Fragment {
    LinearLayout index;
    ListView list;
    Intent it;
    boolean isLogin=false;
    TextView accunt;
    String msg;
    boolean loginTab;
    AdapterView.OnItemClickListener login;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_user_index,null);
        list= (ListView) view.findViewById(R.id.list1);
        index= (LinearLayout) view.findViewById(R.id.user_index);
        accunt= (TextView) view.findViewById(R.id.accunt);
        msg=accunt.getText().toString();
        list.setAdapter(new MyAdapter(getActivity()));
        index.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(msg.equals("请点击登录")&isLogin==false){
                    it=new Intent(getActivity(), LoginUi.class);
                    startActivityForResult(it,500);
                }else {
                     it=new Intent(getActivity(), UserDa.class);
                    startActivityForResult(it,501);
                }
            }
        });
        //登陆前的list事件监听器
        AdapterView.OnItemClickListener loginAge=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        };
        login=new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent it=new Intent(getActivity(), MyPublish.class);
                        startActivity(it);
                        break;
                    case  1:
                        Intent it1=new Intent(getActivity(), MyDraft.class);
                        startActivity(it1);
                        break;
                    case 2:
                        Intent it3=new Intent(getActivity(), MyCollect.class);
                        startActivity(it3);
                        break;
                    case 3:
                        Intent it4=new Intent(getActivity(), MyNews.class);
                        startActivity(it4);
                        break;
                    case 4:
                        Intent it5=new Intent(getActivity() , State.class);
                        startActivity(it5);
                        break;
                    case 5:
                        Intent it6=new Intent(getActivity(), AsLoveHome.class);
                        startActivity(it6);
                        break;
                    case 6:

                        break;
                    case 7:
                        Intent it8=new Intent(getActivity(), ForgetPwdActiivity.class);
                        startActivity(it8);
                        break;
                    case 8:
                        final PopupWindow pop=new PopupWindow(650,350);
                        View pv=LayoutInflater.from(getActivity()).inflate(R.layout.pop_clear,null);
                        //                        Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f,310.0f,0.0f);
                        //                        translateAnimation.setDuration(500);
                        //                        translateAnimation.setFillAfter(true);
                        //                        pv.startAnimation(translateAnimation);
                        pop.setContentView(pv);
                        pop.setFocusable(true);
                        pop.setAnimationStyle(R.style.PopupAnimation2);
                        pop.setBackgroundDrawable(new BitmapDrawable());

                        pop.showAtLocation(view, Gravity.CENTER,0,0);
                        WindowManager.LayoutParams wp=getActivity().getWindow().getAttributes();
                        wp.alpha=0.6f;
                        getActivity().getWindow().setAttributes(wp);
                        pv.findViewById(R.id.ok_clear).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(), "清除成功", Toast.LENGTH_SHORT).show();
                                pop.dismiss();
                            }
                        });
                        pv.findViewById(R.id.no_clear).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(), "已取消", Toast.LENGTH_SHORT).show();
                                pop.dismiss();
                            }
                        });
                        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                            @Override
                            public void onDismiss() {
                                WindowManager.LayoutParams wp=getActivity().getWindow().getAttributes();
                                wp.alpha=1f;
                                getActivity().getWindow().setAttributes(wp);
                            }
                        });
                        break;

                }
            }
        };

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==200){
              switch (requestCode){
                  case 500:
                      String msg=data.getStringExtra("accunt");
                      accunt.setText(msg);
                      isLogin=true;
                      list.setOnItemClickListener(login);
                      Log.e("msg",msg);
                  case 5001:
              }
        }

    }
}
