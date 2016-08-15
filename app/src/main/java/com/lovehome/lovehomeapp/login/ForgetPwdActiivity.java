package com.lovehome.lovehomeapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.lovehome.lovehomeapp.R;
import com.lovehome.lovehomeapp.utils.TelephoneNumberManager;

import java.util.Timer;
import java.util.TimerTask;

public class ForgetPwdActiivity extends Activity {
    Timer timer=new Timer();
    Button btn1,btn2;
    EditText editText1,editTex2;
    int count;
    String  msg1,msg2;
    String code;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (count>0){
                btn1.setText(count+"秒后重发");
                btn1.setEnabled(false);
                count--;
            }else {
                btn1.setText("重新获取验证码");
                btn1.setEnabled(true);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd_actiivity);
        findViewById(R.id.login_img3_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btn1= (Button) findViewById(R.id.login_btn3_1);
        btn2= (Button) findViewById(R.id.login_btn3_2);
        editText1= (EditText) findViewById(R.id.login_edit3_1);
        editTex2= (EditText) findViewById(R.id.login_edit3_2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=60;

                msg1=editText1.getText().toString();
                Log.v("Tag",msg1);
                if(!TelephoneNumberManager.isPhoneNumberValid(msg1)){
                    Toast.makeText(ForgetPwdActiivity.this, "手机号码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }else{
                    code=TelephoneNumberManager.Codes();
                    String info="【爱家乡】验证码："+code+"您正在注册爱家乡账户，请勿将验证码告诉他人";

                    TelephoneNumberManager.sendSMS(msg1,info);
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            handler.sendEmptyMessage(0);
                        }

                    };
                    timer.schedule(timerTask,1 * 1000, 1* 1000);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                msg1=editText1.getText().toString();
                String s1=msg1+1;
                msg2=editTex2.getText().toString();
                String s2=msg2+1;
                if (!s1.equals("1")&&TelephoneNumberManager.isPhoneNumberValid(msg1)) {
                    if (!s2.equals("1")) {
                        //  if (msg2.equals(code)) {
                        Intent intent = new Intent(ForgetPwdActiivity.this, ResetPwdActivity.class);
                        intent.putExtra("phone",msg1);
                        startActivity(intent);
                        finish();
//                        } else {
//                            Toast.makeText(ForgetPwdActiivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
//                        }
                    } else {
                        Toast.makeText(ForgetPwdActiivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ForgetPwdActiivity.this, "手机号不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
