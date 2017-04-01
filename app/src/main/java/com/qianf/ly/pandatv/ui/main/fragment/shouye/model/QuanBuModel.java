package com.qianf.ly.pandatv.ui.main.fragment.shouye.model;

import com.qianf.ly.pandatv.api.QuanBuFragApi;
import com.qianf.ly.pandatv.bean.QuanBuFragDataBean;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.contract.QuanBuContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import java.util.HashMap;

import rx.Observable;

/**
 * Created by 樊康 on 2017/3/30.
 */

public class QuanBuModel implements QuanBuContract.QuanBuModel {

    /**
     * http://api.m.panda.tv/ajax_live_lists?
     * pageno=1&
     * pagenum=20&
     * status=2&
     * order=person_num
     * &sproom=1&
     * __version=3.0.2.3057
     * &__plat=android&
     * __channel=oppo&
     * banner=1
     */
    @Override
    public Observable<QuanBuFragDataBean> loadQuanBuFragData() {

        HashMap<String, String> map = new HashMap<>();

         map.put("pageno","1");
        map.put("pagenum","20");
        map.put("status","2");
        map.put("order","person_num");
        map.put("sproom","1");
        map.put("version","3.0.2.3057");
        map.put("plat","android");
        map.put("channel","oppo");
        map.put("banner","1");

        return QuanBuFragApi.getApiService().getList(map).compose(new AndroidIOToMain.IOToMainTransformer<QuanBuFragDataBean>());
    }

    @Override
    public Observable<QuanBuFragDataBean> loadQuanBuFragPageData(int page) {

        HashMap<String, String> map = new HashMap<>();

        map.put("pageno",String.valueOf(page));
        map.put("pagenum","20");
        map.put("status","2");
        map.put("order","person_num");
        map.put("sproom","1");
        map.put("version","3.0.2.3057");
        map.put("plat","android");
        map.put("channel","oppo");
        map.put("banner","1");

        return QuanBuFragApi.getApiService().getList(map).compose(new AndroidIOToMain.IOToMainTransformer<QuanBuFragDataBean>());
    }
}
