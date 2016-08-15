package com.lovehome.lovehomeapp.userM.other_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lovehome.lovehomeapp.R;

public class ChangeUName extends Activity {
    ImageView back_imge;
    EditText Uname;
    FrameLayout affirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_uname);
        back_imge= (ImageView) findViewById(R.id.back_imge);
        Uname= (EditText) findViewById(R.id.u_name);
        //确认修改按钮
        affirm= (FrameLayout) findViewById(R.id.affirm);
        back_imge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        affirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg=Uname.getText().toString();
                Intent it=new Intent();
                it.putExtra("userName",msg);
                setResult(RESULT_OK,it);
                finish();
            }
        });

    }
}