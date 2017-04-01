package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.bean.ShouYeDataModel;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 樊康 on 2017/3/27.
 */

public interface ShouYeApiService {
/**
 * http://api.m.panda.tv
 * /
 * ?method=card.list&cate=index&__version=3.0.2.3057&__plat=android&__channel=oppo
 */
    @POST("/")
    Observable<ShouYeDataModel> getShow(@QueryMap Map<String,String> map);

}
