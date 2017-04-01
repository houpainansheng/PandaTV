package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.bean.QuanBuFragDataBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 樊康 on 2017/3/30.
 */

public interface QuanBuApiService {


    @GET("ajax_live_lists")
    Observable<QuanBuFragDataBean> getList(@QueryMap Map<String,String> map);
}
