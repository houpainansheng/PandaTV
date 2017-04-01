package com.qianf.ly.pandatv.ui.main.fragment.game.model;

import com.qianf.ly.pandatv.ui.main.fragment.game.bean.fenlei.FenLeiList;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.other.ZhuanQuListBean;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.LunBoListBean;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by Administrator on 2017/3/27.
 */
public interface ApiService {
    /**
     * http://api.m.panda.tv/index.php?method=category.gamelist&__version=3.0.1.3028&__plat=android&__channel=guanwang
     *
     * http://api.m.panda.tv/?method=card.list&cate=game_hot&__version=3.0.2.3057&__plat=android&__channel=guanwang&pt_time=1490607416&pt_sign=dd2b2ae0121b6ab26d3cb754866a6e85
     */

    @GET("/index.php?")
    Call<FenLeiList> getFenLeiList(@QueryMap Map<String,String> map);

    @GET("/?")
    Call<ZhuanQuListBean> getZhuanQuListBean(@QueryMap Map<String,String> map);

    @GET("/?")
    Call<LunBoListBean> getLunBoListBean(@QueryMap Map<String,String> map);


}
