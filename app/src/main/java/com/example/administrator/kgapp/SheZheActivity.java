package com.example.administrator.kgapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SheZheActivity extends AppCompatActivity {

    @BindView(R.id.fanhui)
    ImageView fanhui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhe);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.fanhui)
    public void onViewClicked() {
        finish();
    }
}
