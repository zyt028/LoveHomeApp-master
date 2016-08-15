package com.lovehome.lovehomeapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/8/13.
 */
public class DBOpenHelper extends SQLiteOpenHelper {


    public DBOpenHelper(Context context) {
        super(context,"userinfo.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="create table user_tb(" +
                "user_id integer primary key autoincrement,"+
                "user_account varchar(100),"+
                "user_pwd varchar(100),"+
                "user_name varchar(100),"+
                "user_add varchar(100),"+
                "user_tel varchar(100),"+
                "user_img varchar(100))";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
