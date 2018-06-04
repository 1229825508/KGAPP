package com.example.administrator.kgapp.presenter.p1;

import com.example.administrator.kgapp.bean.LoginBean;
import com.example.administrator.kgapp.model.m1.IMLogin;
import com.example.administrator.kgapp.model.m1.MLogin;
import com.example.administrator.kgapp.view.v1.IVLogin;
import com.google.gson.Gson;

public class PLogin implements IPLogin {
    private IMLogin imLogin;
    private IVLogin ivLogin;

    public PLogin(IVLogin ivLogin) {
        this.ivLogin = ivLogin;
        this.imLogin = new MLogin();
    }

    @Override
    public void onLogin(String mobile, String password) {
        imLogin.onLogin(mobile,password,this);
    }

    @Override
    public void onEorr(String e) {
        if (ivLogin == null){
            return;
        }
        ivLogin.onEorr(e);
    }


    @Override
    public void onSuccess(Object o) {
        if (ivLogin == null){
            return;
        }
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(o.toString(), LoginBean.class);
        String code = loginBean.getCode();
        if ("0".equals(code)){
            ivLogin.onSuccess(loginBean.getMsg());
        }else {
            ivLogin.onEorr(loginBean.getMsg());
        }
    }

    @Override
    public void onDistroy() {
        if (ivLogin != null){
            ivLogin = null;
        }
    }
}
