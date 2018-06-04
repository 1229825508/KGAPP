package com.example.administrator.kgapp.presenter.p2;

import com.example.administrator.kgapp.bean.YinYTBean;
import com.example.administrator.kgapp.model.m2.IMWoDe;
import com.example.administrator.kgapp.model.m2.MWoDe;
import com.example.administrator.kgapp.view.v2.IVWoDe;

public class WoDePresenter {
    private IVWoDe ivWoDe;
    private IMWoDe imWoDe;

    public WoDePresenter(IVWoDe ivWoDe) {
        this.ivWoDe = ivWoDe;
        this.imWoDe = new MWoDe();
    }
    public void HomeData(){
        imWoDe.getData(new IMWoDe.HomeSet() {
            @Override
            public void doSet(YinYTBean yinYTBean) {
                ivWoDe.setData(yinYTBean);
            }
        });
    }
    //解绑，将inRecView赋空并在MainActivity中回调此方法。
    public void onDestory(){
        if (ivWoDe != null){
            ivWoDe = null;
        }
    }
}