package com.example.administrator.kgapp.presenter.p1;

import java.io.IOException;

public interface IPLogin {
    void onLogin(String mobile,String password);
    void onEorr(String e);
    void onSuccess(Object o);
    void onDistroy();

}
