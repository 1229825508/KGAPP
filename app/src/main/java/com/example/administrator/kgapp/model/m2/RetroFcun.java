package com.example.administrator.kgapp.model.m2;

import com.example.administrator.kgapp.utils.ApiServer;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFcun {
    public static ApiServer build(String path){
        //创建OkHttpClient
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new LoopeHttpUrl()).connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .build();
        //创建Retrofit
        ApiServer builder = new Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(ApiServer.class);
        return builder;
    }
}
