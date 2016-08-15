package com.lovehome.lovehomeapp.userM.other_activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lovehome.lovehomeapp.R;

public class ChangeUAddress extends Activity {
    ImageView back_imge;
    EditText UAddress;
    FrameLayout affirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_uaddress);
        back_imge= (ImageView) findViewById(R.id.back_imge);
        UAddress= (EditText) findViewById(R.id.u_name);
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
                Intent it=new Intent();
                it.putExtra("uadd",UAddress.getText().toString());
                setResult(RESULT_OK,it);
                finish();
            }
        });
    }
}
