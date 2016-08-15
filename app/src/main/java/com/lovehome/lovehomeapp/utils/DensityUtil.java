package com.lovehome.lovehomeapp.utils;

import android.content.Context;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class DensityUtil {

    /*
     * 根据手机分辨率从dip的单位转换成px（像素）
     */
    public static int dip2px(Context context, float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /*
     * 根据手机分辨率从px(像素)的单位转换成dp
     */
    public static int px2dip(Context context,float dpValue){
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue / scale + 0.5f);
    }

}
