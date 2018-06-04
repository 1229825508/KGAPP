package com.example.administrator.kgapp.presenter.p1;

public interface IPRegister {
    void onRegiister(String mobile,String password);
    void onEorr(String e);
    void onSuccess(Object o);
    void onDistroy();
}
