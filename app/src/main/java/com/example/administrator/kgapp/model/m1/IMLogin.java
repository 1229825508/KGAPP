package com.example.administrator.kgapp.model.m1;

import com.example.administrator.kgapp.presenter.p1.IPLogin;

public interface IMLogin {
    void onLogin(String mobile, String password, IPLogin ipLogin);
}
