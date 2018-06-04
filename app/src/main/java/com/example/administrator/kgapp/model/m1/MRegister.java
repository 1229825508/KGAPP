package com.example.administrator.kgapp.model.m1;

import android.os.Handler;

import com.example.administrator.kgapp.presenter.p1.IPRegister;
import com.example.administrator.kgapp.utils.Api;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MRegister implements IMRegister {
    Handler handler = new Handler();
    @Override
    public void onRegiister(String mobile, String password, final IPRegister ipRegister) {
        String REGURL = Api.REGURL+"?mobile="+mobile+"&password="+password;
        OkHttpClient ok = new OkHttpClient();
        Request request = new Request.Builder()
                .url(REGURL)
                .build();
        Call call = ok.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                    ipRegister.onEorr(e.getMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()){
                    final String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            ipRegister.onSuccess(string);
                        }
                    });
                }

            }
        });
    }
}
