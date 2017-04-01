package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.bean.PendaStarDataBean;

import java.util.Map;

import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 樊康 on 2017/3/28.
 */

public interface PendaStarApiService {

    /**
     * http://m.api.xingyan.panda.tv/
     * room/index?
     * __version=3.0.2.3057&__plat=android&__channel=oppo
     */

    @POST("room/index?")
    Observable<PendaStarDataBean> getList(@QueryMap Map<String,String> map);
}
