package com.lovehome.lovehomeapp.db;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2016/8/13.
 */
public class UserInfo_Db extends Activity {
    SQLiteDatabase db;
    public UserInfo_Db(Context context) {
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getReadableDatabase();
    }
    public void saveUserMsg(String userAccount,String userPwd){
        String sql="insert into user_tb(user_account,user_pwd) values('"+userAccount+"','"+userPwd+"')";
        db.execSQL(sql);
    }

    public boolean isUser(String userAccount,String userPwd){
        boolean flag=false;
        String sql="select * from user_tb where user_account='"+userAccount+"' and user_pwd='"+userPwd+"'";
        Cursor cr=db.rawQuery(sql,null);
        flag=cr.moveToNext();
        if (flag){
            return true;
        }else{
            return false;
        }
    }

    public  void deleteData(String userAccount){
        String sql="delete from user_tb where user_account='"+userAccount+"'";
        db.execSQL(sql);
    }

    public boolean resetPwd(String userAccount,String userPwd){
        String sql="update user_tb set user_pwd='"+userPwd+"' where user_account='"+userAccount+"'";
        db.execSQL(sql);
        return true;
    }

    public  boolean isuserExist(String userAccount){
        boolean flag=false;
        String sql="select * from user_tb where user_account='"+userAccount+"'";
        Cursor cr=db.rawQuery(sql,null);
        flag=cr.moveToNext();
        if (flag){
            return true;
        }else{
            return false;
        }
    }
}

