package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.bean.AllVideoDataBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 樊康 on 2017/3/28.
 */

public interface AllGameApiService {

    @GET("ajax_get_live_list_by_cate")
    Observable<AllVideoDataBean> getList(@QueryMap Map<String,String> map);

}
