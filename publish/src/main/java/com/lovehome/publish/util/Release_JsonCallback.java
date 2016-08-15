package com.lovehome.publish.util;

import android.content.Context;
import android.widget.Toast;

import org.xutils.common.Callback;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class Release_JsonCallback  implements Callback.CommonCallback<String> {
    public Context context;
    public void  Release_JsonCallback(Context context){
        this.context=context;
    }
    @Override
    public   void onSuccess(String result) {
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        //Toast.makeText(context, "网络异常", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancelled(Callback.CancelledException cex) {}
    @Override
    public void onFinished() {}
}
