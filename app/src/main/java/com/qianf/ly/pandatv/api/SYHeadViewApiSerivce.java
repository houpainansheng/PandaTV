package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.LunBoListBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by 樊康 on 2017/3/30.
 */

public interface SYHeadViewApiSerivce {

    /**
     *   http://api.m.panda.tv/?
     *   method=slider.cate&
     *   cate=index
     *   &__version=3.0.2.3057&
     *   __plat=android
     *   &__channel=oppo
     */
   @GET("?")
    Observable<LunBoListBean>  getList(@QueryMap Map<String,String> map);
}
