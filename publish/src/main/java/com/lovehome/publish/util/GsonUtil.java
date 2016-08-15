package com.lovehome.publish.util;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.lovehome.publish.entity.Release_pager_entity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class GsonUtil {
    public static ArrayList<Release_pager_entity> Gson(JSONObject jsonObject){
    ArrayList<Release_pager_entity> list=new ArrayList<>();

    try{
        if(jsonObject.getString("msg").equalsIgnoreCase("success")){
            Gson gson=new Gson();
            //获取当前全部的list下的信息
            String msg=jsonObject.getString("list");
            //将list下的信息按需求封装好
            list=gson.fromJson(msg,new TypeToken<ArrayList<Release_pager_entity>>(){}.getType());
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    return list;
}

}

