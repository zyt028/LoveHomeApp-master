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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lovehome.lovehomeapp.R;
import com.lovehome.lovehomeapp.db.UserInfo_Db;
import com.lovehome.lovehomeapp.utils.TelephoneNumberManager;

import java.util.Timer;
import java.util.TimerTask;

public class RegisterActivity extends Activity {
    Timer timer=new Timer();
    EditText editText1,editText2,editText3,editText4;
    String msg1,msg2,msg3,msg4;
    TextView textView;
    Button btn1,btn2;
    String code;
    int count;
    CheckBox checkBox;
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
        setContentView(R.layout.activity_register);
        init();
        event();
    }

    public void  init(){
        editText1= (EditText) findViewById(R.id.login_edit2_1);
        editText2= (EditText) findViewById(R.id.login_edit2_2);
        editText3= (EditText) findViewById(R.id.login_edit2_3);
        editText4= (EditText) findViewById(R.id.login_edit2_4);
        btn1= (Button) findViewById(R.id.login_btn2_1);
        btn2= (Button) findViewById(R.id.login_btn2_2);
        textView= (TextView) findViewById(R.id.login_text2_1);
        checkBox= (CheckBox) findViewById(R.id.login_checkbox);
    }

    public void event(){
        findViewById(R.id.login_img2_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(RegisterActivity.this, "被点击了", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(RegisterActivity.this,ProvisionActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count=60;
                msg1=editText1.getText().toString();
                Log.v("Tag",msg1);
                if(!TelephoneNumberManager.isPhoneNumberValid(msg1)){
                    Toast.makeText(RegisterActivity.this, "手机号码不正确，请重新输入", Toast.LENGTH_SHORT).show();
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
                    Log.v("Tag",code);

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msg1=editText1.getText().toString();
                String s1=msg1+1;
                msg2=editText2.getText().toString();
                String s2=msg2+1;
                msg3=editText3.getText().toString();
                String s3=msg3+1;
                msg4=editText4.getText().toString();
                String s4=msg4+1;
                if (!s1.equals("1")&&TelephoneNumberManager.isPhoneNumberValid(msg1)){
                    if (!new UserInfo_Db(RegisterActivity.this).isuserExist(msg1)) {
                        if (!s2.equals("1")) {
                            //  if (msg2.equals(code)) {
                            if (!s3.equals("1")) {
                                if (!s4.equals("1")) {
                                    if (checkBox.isChecked()) {
                                        if (msg3.equals(msg4)) {
                                            new UserInfo_Db(RegisterActivity.this).saveUserMsg(msg1, msg3);
                                            Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "密码前后不一致", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "请同意注册协议", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(RegisterActivity.this, "请输入确认密码", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                            }
//                       }else {
//                           Toast.makeText(RegisterActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
//                       }
                        } else {
                            Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(RegisterActivity.this, "该账号已存在！", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(RegisterActivity.this, "手机号不正确，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
