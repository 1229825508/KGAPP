package com.example.administrator.kgapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrator.kgapp.R;
import com.example.administrator.kgapp.presenter.p1.PRegister;
import com.example.administrator.kgapp.view.v1.IVRegister;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity implements IVRegister {
    @BindView(R.id.reg_img)
    ImageView regImg;
    private String regUrl = "http://pic.58pic.com/58pic/15/95/42/05E58PICuYv_1024.jpg";
    @BindView(R.id.regName)
    EditText regName;
    @BindView(R.id.regPass)
    EditText regPass;
    private PRegister ipr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        ipr = new PRegister(this);
        Glide.with(this).load(regUrl).into(regImg);
    }

    public void fanhui(View v) {
        finish();
    }

    public void rgClick(View v) {
        String regm = regName.getText().toString();
        String regp = regPass.getText().toString();
        ipr.onRegiister(regm, regp);
    }

    @Override
    public void onEorr(String e) {
        Toast.makeText(RegisterActivity.this, e, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(Object o) {
        Toast.makeText(RegisterActivity.this, o.toString(), Toast.LENGTH_SHORT).show();
    }
}
