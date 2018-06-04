package com.example.administrator.kgapp.fragment1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.kgapp.R;
import com.example.administrator.kgapp.bean.YinYTBean;
import com.example.administrator.kgapp.presenter.p2.WoDePresenter;
import com.example.administrator.kgapp.view.v2.IVWoDe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragMindActivity extends Fragment implements IVWoDe {
    @BindView(R.id.RecWo)
    RecyclerView RecWo;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.activity_frag_mind, container, false);
        unbinder = ButterKnife.bind(this, view1);
        return view1;

    }
    /*
        onCreate方法
         */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WoDePresenter woDePresenter = new WoDePresenter(this);
        woDePresenter.HomeData();
    }
    /*
    实现的View方法
     */
    @Override
    public void setData(YinYTBean yinYTBean) {
//        RecWo.setLayoutManager(new GridLayoutManager(getActivity(),4));
//        YinYTBean.DataBean data = yinYTBean.getData();
    }
    /*
        注销方法
         */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
