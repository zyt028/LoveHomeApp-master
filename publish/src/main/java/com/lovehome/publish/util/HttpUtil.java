package com.lovehome.publish.util;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class HttpUtil {

    private static HttpUtil instance;
    private AsyncHttpClient client;

    private HttpUtil() {
        client=new AsyncHttpClient();
        client.setTimeout(5000);
    }

    public static HttpUtil getURLData(){
        if(instance==null){
            instance=new HttpUtil();
        }
        return instance;
    }

    public void getItem(JsonHttpResponseHandler handler){
        try{
            String Url=URL.MENU_INFO;
            client.get(Url,handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllStoreInfo(JsonHttpResponseHandler handler){
        try{
            String Url=URL.ALL_StoreInfo;
            client.get(Url,handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
