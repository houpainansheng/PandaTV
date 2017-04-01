package com.qianf.ly.pandatv.ui.main.model;

import android.util.Log;

import com.qianf.ly.pandatv.api.AllGameApi;
import com.qianf.ly.pandatv.bean.AllVideoDataBean;
import com.qianf.ly.pandatv.ui.main.contract.MainContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import java.util.HashMap;

import rx.Observable;

/**
 * Created by Administrator on 2017/3/25.
 */

public class MainModel implements MainContract.MainModel {

    private String name;
    @Override
    public Observable<AllVideoDataBean> getData(String cate) {

        HashMap<String, String> map = new HashMap<>();
        name = cate;
        map.put("cate", cate);
        map.put("pageno", "1");
        map.put("pagenum", "20");
        map.put("sproom", "1");
        map.put("version", "3.0.1.3028");
        map.put("plat", "android");
        map.put("channel", "oppo");

        return AllGameApi.getApiService().getList(map).compose(new AndroidIOToMain.IOToMainTransformer<AllVideoDataBean>());
    }

    @Override
    public Observable<AllVideoDataBean> getPageData( int page) {


        /**
         *http://api.m.panda.tv/ajax_get_live_list_by_cate?
         * cate=lol&
         * pageno=1&
         * pagenum=20&
         * sproom=1&
         * __version=3.0.1.3028&
         * __plat=android&
         * __channel=oppo&
         * pt_sign=676399d858e1eba037c38c7f2d33e85e&
         * pt_time=1490408251
         *
         */

        HashMap<String,String> map = new HashMap<>();
        map.put("cate", name);
        Log.e("tt", "getPageData: 能不能拿到数据呢"+ name );
        map.put("pageno", String.valueOf(page));
        Log.e("tt", "getData:我拿到的页数为 " + String.valueOf(page));
        map.put("pagenum", "20");
        map.put("sproom", "1");
        map.put("version", "3.0.1.3028");
        map.put("plat", "android");
        map.put("channel", "oppo");


        return AllGameApi.getApiService().getList(map).compose(new AndroidIOToMain.IOToMainTransformer<AllVideoDataBean>());
    }

}