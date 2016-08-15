package com.lovehome.lovehomeapp.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.lovehome.lovehomeapp.R;
import com.lovehome.lovehomeapp.db.UserInfo_Db;

public class ResetPwdActivity extends Activity {
    String msg1,msg2;
    EditText editText1,editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        findViewById(R.id.login_img4_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        editText1= (EditText) findViewById(R.id.login_edit4_1);
        editText2= (EditText) findViewById(R.id.login_edit4_2);
        findViewById(R.id.login_btn4_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg1=editText1.getText().toString();
                String s1=msg1+1;
                msg2=editText2.getText().toString();
                String s2=msg2+1;

                if (!s1.equals("1")){
                    if (!s2.equals("1")){
                        if (msg1.equals(msg2)){
                            String phone=getIntent().getStringExtra("phone");
                            Log.v("Tag",phone);
                            new UserInfo_Db(ResetPwdActivity.this).resetPwd(phone,msg1);
                            Toast.makeText(ResetPwdActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(ResetPwdActivity.this,LoginUi.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(ResetPwdActivity.this, "两次输入的密码不一致", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(ResetPwdActivity.this, "请输入确认密码", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(ResetPwdActivity.this, "请输入没密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
