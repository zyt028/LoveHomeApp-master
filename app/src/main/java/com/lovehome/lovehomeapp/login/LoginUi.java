
package com.lovehome.lovehomeapp.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.lovehome.lovehomeapp.MainActivity;
import com.lovehome.lovehomeapp.R;
import com.lovehome.lovehomeapp.db.UserInfo_Db;

public class LoginUi extends Activity {
    ImageView backBtm;
    String msg1,msg2;
    EditText editText1,editText2;
    SpannableString span;
    Drawable d;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);
        backBtm= (ImageView) findViewById(R.id.login_img1);
        backBtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        editText1=(EditText)findViewById(R.id.login_edit1_1);
        editText2=(EditText)findViewById(R.id.login_edit1_2);

        findViewById(R.id.login_text1_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(LoginUi.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.login_text1_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(LoginUi.this,ForgetPwdActiivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.login_btn1_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg1=editText1.getText().toString();
                String s1=msg1+1;
                msg2=editText2.getText().toString();
                String s2=msg2+1;

                if (!s1.equals("1")){
                    if(!s2.equals("1")){
                        //  new UserInfo_Db(MainActivity.this).deleteData(msg1);
                        boolean f=   new UserInfo_Db(LoginUi.this).isUser(msg1,msg2);
                        if (f){
                            Intent it=new Intent();
                            it.putExtra("accunt",msg1);
                            setResult(200,it);
                            finish();
                        }else {
                            Toast.makeText(LoginUi.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(LoginUi.this, "请输入密码!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginUi.this, "请输入手机号!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
