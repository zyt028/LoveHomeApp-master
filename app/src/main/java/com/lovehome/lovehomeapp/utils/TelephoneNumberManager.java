package com.lovehome.lovehomeapp.utils;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/8/13.
 */
public class TelephoneNumberManager {
    static Random rd=new Random();

    //验证手机号的正确性
    public static boolean isPhoneNumberValid(String phoneNumber) {
        Pattern p = Pattern.compile("^1(3\\d|5[012356789]|8[03456789])\\d{8}$");
        Matcher m = p.matcher(phoneNumber);
        if (m.matches()) {
            return true;
        } else{
            return false;
        }
    }
    //发送短信
    public static void sendSMS(String phoneNumber,String message){
        //获取短信管理器
        android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
        //拆分短信内容（手机短信长度限制）
        List<String> divideContents = smsManager.divideMessage(message);
        for (String text : divideContents) {
            smsManager.sendTextMessage(phoneNumber, null, text, null, null);
        }
    }

    //生成四位数验证码
    public static String Codes(){

        int i=rd.nextInt(9000)+1000;
        return i+"";
    }

}

