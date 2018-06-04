package com.example.administrator.kgapp.utils;

import com.example.administrator.kgapp.bean.YinYTBean;
import retrofit2.http.GET;
import rx.Observable;

public interface ApiServer {
    @GET("song_search_v2?callback=jcallback")
    Observable<YinYTBean> getHome();
}
