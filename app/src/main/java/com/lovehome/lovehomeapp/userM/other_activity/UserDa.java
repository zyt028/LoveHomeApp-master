package com.lovehome.lovehomeapp.userM.other_activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.lovehome.lovehomeapp.R;

import java.io.File;

public class UserDa extends Activity {
    ImageView imgBack;
    ImageView imhces;
    LinearLayout userP;
    LinearLayout userName;
    LinearLayout user_phone;
    LinearLayout user_addresss;
    TextView tex_user_name;
    TextView tex_user_phone;
    TextView tex_user_address;
    View main_view;
    private File sdcardTempFile;
    private File uploadFile;
    private ImageView index_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main_view= LayoutInflater.from(this).inflate(R.layout.activity_user_da,null);
        setContentView(main_view);
        imhces= (ImageView) findViewById(R.id.imgces);
        imgBack= (ImageView) findViewById(R.id.imgBtn1);
        userP= (LinearLayout) findViewById(R.id.user_photo);
        //修改用户信息的点击对象
        userName = (LinearLayout) findViewById(R.id.user_name);
        user_phone= (LinearLayout) findViewById(R.id.user_phone);
        user_addresss= (LinearLayout) findViewById(R.id.user_addresss);
        //用户信息填充对象
        tex_user_name= (TextView) findViewById(R.id.tex_user_name);
        tex_user_phone= (TextView) findViewById(R.id.tex_user_phone);
        tex_user_address= (TextView) findViewById(R.id.tex_user_add);
        //修改用户头像的点击对象
        index_photo= (ImageView) findViewById(R.id.index_photo);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        userP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final PopupWindow pop=new PopupWindow(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT);
                View v= LayoutInflater.from(UserDa.this).inflate(R.layout.user_de_pop,null);
//                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f,310.0f,0.0f);
//                translateAnimation.setDuration(500);
//                translateAnimation.setFillAfter(true);
//                v.startAnimation(translateAnimation);
                pop.setAnimationStyle(R.style.PopupAnimation);
                pop.setContentView(v);
                pop.setFocusable(true);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.showAtLocation(main_view, Gravity.BOTTOM,0,0);
                v.findViewById(R.id.camera).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //打开相机
                        Intent it1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(it1,1000);
                        pop.dismiss();
                    }
                });
                v.findViewById(R.id.off).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop.dismiss();
                    }
                });


                sdcardTempFile = new File("/mnt/sdcard/", "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg");
                //打开图库
                v.findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        Intent it2 = new Intent(Intent.ACTION_PICK , MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                        startActivityForResult(it2 , 1001);
                        Intent intent1 = new Intent("android.intent.action.PICK");
                        intent1.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                        intent1.putExtra("output", Uri.fromFile(sdcardTempFile));
                        intent1.putExtra("crop", "true");
                        intent1.putExtra("aspectX", 1);// 裁剪框比例
                        intent1.putExtra("aspectY", 1);
                        intent1.putExtra("outputX", 200);// 输出图片大小
                        intent1.putExtra("outputY", 200);
                        startActivityForResult(intent1, 1001);
                        pop.dismiss();
                    }
                });
                //设置弹出窗口时背景变暗
                WindowManager.LayoutParams lp=getWindow().getAttributes();
                lp.alpha=0.6f;
                getWindow().setAttributes(lp);
                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams lp=getWindow().getAttributes();
                        lp.alpha=1f;
                        getWindow().setAttributes(lp);
                    }
                });
            }
        });
        userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(UserDa.this,ChangeUName.class);
                startActivityForResult(it,1003);
            }
        });
        user_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(UserDa.this,ChangeUPhoneNum.class);
                startActivityForResult(it,1004);
            }
        });
        user_addresss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it=new Intent(UserDa.this,ChangeUAddress.class);
                startActivityForResult(it,1005);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            switch (requestCode){
                case 1000:
                    Bundle b = data.getExtras();
                    Bitmap bmp = (Bitmap) b.get("data");
                    bmp=Bitmap.createScaledBitmap(bmp,200,200,true);
                    Bitmap bm2 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
                    Canvas canvas1 = new Canvas(bm2);
                    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Shader shader1 = new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                    paint1.setShader(shader1);
                    canvas1.drawCircle(100, 100, 100, paint1);
                    index_photo.setImageBitmap(bm2);
                    imhces.setImageBitmap(bmp);
                    break;
                case 1001:/*
                    Uri uri = data.getData();
                    //2.查询列：图片路径
                    String[] pro = {MediaStore.Images.Media.DATA};
                    Cursor c = getContentResolver().query(uri , pro , null , null , null);
                    c.moveToFirst();
                    //3.获取路径
                    String path = c.getString(0);
                    Log.e("TGA", path);
                    uploadFile = new File(path);
                    //4.获取图片的Bitmap对象
                    Bitmap bm = BitmapFactory.decodeFile(path);*/
                    Bitmap bm = BitmapFactory.decodeFile(sdcardTempFile.getAbsolutePath());
                    bm=Bitmap.createScaledBitmap(bm,200,200,true);
                    Bitmap bm1 = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(bm1);
                    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
                    Shader shader = new BitmapShader(bm, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
                    paint.setShader(shader);
                    canvas.drawCircle(100, 100, 100, paint);
                    index_photo.setImageBitmap(bm1);
                    imhces.setImageBitmap(bm);
                    break;
                case 1003:
                    String UsName=data.getStringExtra("userName");
                    if(UsName!=null){
                        tex_user_name.setText(UsName);
                        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                    } else {Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();}
                    break;
                case 1004:
                    String msge=data.getStringExtra("UphoneNum");
                    if(msge!=null){
                        tex_user_phone.setText(msge);
                        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                    } else {Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();}
                    break;
                case 1005:
                    String address=data.getStringExtra("uadd");
                    if(address!=null){
                        tex_user_address.setText(address);
                        Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
                    } else {Toast.makeText(this, "修改失败", Toast.LENGTH_SHORT).show();}
                    break;

            }
        }
    }
}
