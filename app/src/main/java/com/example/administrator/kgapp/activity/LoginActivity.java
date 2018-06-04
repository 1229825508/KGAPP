package com.example.administrator.kgapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.kgapp.R;
import com.example.administrator.kgapp.presenter.p1.PLogin;
import com.example.administrator.kgapp.view.v1.IVLogin;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements IVLogin {
    @BindView(R.id.img_show)
    ImageView imgShow;
    private String imgUrl = "https://goss.veer.com/creative/vcg/veer/800water/veer-123640555.jpg";
    @BindView(R.id.logName)
    EditText logName;
    @BindView(R.id.logPass)
    EditText logPass;
    private PLogin pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        pg = new PLogin(this);
        Glide.with(this).load(imgUrl).into(imgShow);
    }

    public void logClick(View v) {
        String logm = logName.getText().toString();
        String logp = logPass.getText().toString();
        pg.onLogin(logm, logp);
    }

    public void regClick(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onSuccess(Object o) {
        Toast.makeText(LoginActivity.this, o.toString(), Toast.LENGTH_SHORT).show();

        if(o.toString().equals("登录成功")){
            Intent intent = new Intent(LoginActivity.this, MusicActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onEorr(String e) {
        Toast.makeText(LoginActivity.this, e, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pg.onDistroy();
    }
}
