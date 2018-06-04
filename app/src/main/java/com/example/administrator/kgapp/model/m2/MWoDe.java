package com.example.administrator.kgapp.model.m2;

import com.example.administrator.kgapp.bean.YinYTBean;
import com.example.administrator.kgapp.utils.Api;
import com.example.administrator.kgapp.utils.ApiServer;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MWoDe implements IMWoDe{
    @Override
    public void getData(final HomeSet homeSet) {
        Observable<YinYTBean> home = RetroFcun.build(Api.MUSICNAME).getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<YinYTBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(YinYTBean yinYTBean) {
                        homeSet.doSet(yinYTBean);
                    }
                });
    }
}
