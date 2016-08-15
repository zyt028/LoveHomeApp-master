package com.lovehome.lovehome.util;

import java.net.HttpURLConnection;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class URL {


    //全局的请求网址头
    public static String BASE_URL="http://123.206.87.139/LoveHomeTownServer";

    //获取城市名称
    public static String CITY_INFO=BASE_URL+"/printCity";

    //获取分类信息，适用于在首页的item以及发布中的item和popwindow
    public static String MENU_INFO=BASE_URL+"/printCategory";

    //获取网络商铺所有信息
    public static String ALL_StoreInfo=BASE_URL+"/detailInfo?is_approve=1";

    public URL(String s) {
    }

    public HttpURLConnection openConnection() {
        return null;
    }

}
