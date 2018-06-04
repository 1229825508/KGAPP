package com.example.administrator.kgapp.presenter.p1;

import com.example.administrator.kgapp.bean.REGBean;
import com.example.administrator.kgapp.model.m1.IMRegister;
import com.example.administrator.kgapp.model.m1.MRegister;
import com.example.administrator.kgapp.view.v1.IVRegister;
import com.google.gson.Gson;

public class PRegister implements IPRegister {
    private IVRegister ivRegister;
    private IMRegister imRegister;

    public PRegister(IVRegister ivRegister) {
        this.ivRegister = ivRegister;
        this.imRegister = new MRegister();
    }

    @Override
    public void onRegiister(String mobile, String password) {
        imRegister.onRegiister(mobile,password,this);
    }

    @Override
    public void onEorr(String e) {
        if (ivRegister == null){
            return;
        }
        ivRegister.onEorr(e);
    }

    @Override
    public void onSuccess(Object o) {
        if (ivRegister == null){
            return;
        }
        Gson gson = new Gson();
        REGBean regBean = gson.fromJson(o.toString(), REGBean.class);
        String code = regBean.getCode();
        if ("0".equals(code)){
            ivRegister.onSuccess(regBean.getMsg());
        }else {
            ivRegister.onEorr(regBean.getMsg());
        }
    }

    @Override
    public void onDistroy() {
        if (ivRegister != null){
            ivRegister = null;
        }
    }
}
