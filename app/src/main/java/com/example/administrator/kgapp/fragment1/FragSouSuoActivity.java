package com.example.administrator.kgapp.fragment1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.kgapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragSouSuoActivity extends AppCompatActivity {
    @BindView(R.id.fanhui)
    ImageView fanhui;
    @BindView(R.id.ss)
    EditText ss;
    @BindView(R.id.lishi)
    TextView lishi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.fanhui,R.id.sos})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.fanhui:
                finish();
            break;
            case R.id.sos:
                String sou = ss.getText().toString();
                String[] sou1=sou.split("\\n"+"\n");
                lishi.setText(""+sou1[0]+"\n");
                break;
        }
    }
}
