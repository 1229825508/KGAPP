package com.example.administrator.kgapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.kgapp.activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
/*
http://www.51mtw.com/UploadFiles/2011-07/admin/2011072915120063928.jpg

http://www.51mtw.com/UploadFiles/2011-07/admin/2011070513151350980.jpg

http://pic3.nipic.com/20090608/2680146_074626099_2.jpg

https://i03picsos.sogoucdn.com/8543780ef64995f6
 */

public class MainActivity extends AppCompatActivity {
    private int it = 3;
//    @BindView(R.id.musimg)
//    ImageView musimg;
    @BindView(R.id.tv_hl)
    TextView tvHl;
//    private String imgUrl = "https://i03picsos.sogoucdn.com/8543780ef64995f6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        Glide.with(this).load(imgUrl).into(musimg);

        Message message = handler.obtainMessage(1);
        boolean b = handler.sendMessageDelayed(message, 1000);

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    it--;
                    tvHl.setText(""+it+"s");
                    if(it>0){
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message,1000);
                    }else if(it<=0){
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);

                    }
//                    else {
//                        tvHl.setVisibility(View.GONE);
//                    }
            }
        }
    };

}
