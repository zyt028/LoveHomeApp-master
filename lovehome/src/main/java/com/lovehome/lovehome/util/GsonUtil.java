package com.lovehome.lovehome.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.lovehome.lovehome.model.Home_pager_BusinessDetails_entity;
import com.lovehome.lovehome.model.Home_pager_bussinessImage_entity;
import com.lovehome.lovehome.model.Home_pager_item_entity;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class GsonUtil {

    public static ArrayList<Home_pager_item_entity>  Gson(JSONObject jsonObject){
        ArrayList<Home_pager_item_entity> list=new ArrayList<>();
        try{
            if(jsonObject.getString("msg").equalsIgnoreCase("success")){

                Gson gson=new Gson();

                //获取当前全部的list下的信息
                String msg=jsonObject.getString("list");

                //将list下的信息按需求封装好
                list=gson.fromJson(msg,new TypeToken<ArrayList<Home_pager_item_entity>>(){}.getType());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Home_pager_BusinessDetails_entity> Gson1(JSONObject jsonObject){
        ArrayList<Home_pager_BusinessDetails_entity> list=new ArrayList<>();

        try{
            if(jsonObject.getString("msg").equalsIgnoreCase("success")){

                Gson gson=new Gson();

                //获取当前全部的list下的信息
                String msg=jsonObject.getString("list");

                //将list下的信息按需求封装好
                list=gson.fromJson(msg,new TypeToken<ArrayList<Home_pager_BusinessDetails_entity>>(){}.getType());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Home_pager_bussinessImage_entity> GsonImage(JSONObject jsonObject){
        ArrayList<Home_pager_bussinessImage_entity> list=new ArrayList<>();
        try{
            if(jsonObject.getString("msg").equals("success")){
                //获取当前全部的list下的信息
                for (int i = 0; i < jsonObject.getJSONArray("list").length(); i++) {
                    String msg = jsonObject.getJSONArray("list").getJSONObject(i)
                            .getJSONArray("imgUrlList").getJSONObject(0).getString("img_url");
                    Home_pager_bussinessImage_entity image=new Home_pager_bussinessImage_entity();
                    image.setImg_url(msg);
                    list.add(image);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
