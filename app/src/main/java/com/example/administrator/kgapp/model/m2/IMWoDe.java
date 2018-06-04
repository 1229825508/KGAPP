package com.example.administrator.kgapp.model.m2;

import com.example.administrator.kgapp.bean.YinYTBean;

public interface IMWoDe {
    void getData(HomeSet homeSet);
    public interface HomeSet{
        void doSet(YinYTBean yinYTBean);
    }
}
