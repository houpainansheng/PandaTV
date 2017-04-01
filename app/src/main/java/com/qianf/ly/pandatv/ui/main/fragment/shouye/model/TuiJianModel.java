package com.qianf.ly.pandatv.ui.main.fragment.shouye.model;

import android.util.Log;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.qianf.ly.pandatv.api.PendaStarApi;
import com.qianf.ly.pandatv.api.SYHeadViewApi;
import com.qianf.ly.pandatv.bean.PendaStarDataBean;
import com.qianf.ly.pandatv.bean.ShouYeDataModel;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.LunBoListBean;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.contract.ShouYeContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import java.util.HashMap;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class TuiJianModel implements ShouYeContract.ShouYeModel {

    public static final String TAG = TuiJianModel.class.getSimpleName();

//    @Override
//    public Observable<ShouYeDataModel> loadShouYeModelListData() {
//
//        Map<String, String> map = new HashMap<>();
//        map.put("method","card.list");
//        map.put("cate","index");
//        map.put("version","3.0.2.3057");
//        map.put("plat","android");
//        map.put("channel","oppo");
//
//        Log.e(TAG, "loadShouYeModelListData: 返回被订阅者的对象" );
//      return ShouYeApi.getApiService().getShow(map).compose(new AndroidIOToMain.IOToMainTransformer<ShouYeDataModel>());
//    }


    @Override
    public void loadShouYeModelListData(final Subscriber Subscriber) {

        HttpUtil.getStringAsync("http://api.m.panda.tv/?method=card.list&cate=index&__version=3.0.2.3057&__plat=android&__channel=oppo0", new RequestCallback() {
            @Override
            public void onSucceed(String result) {

                Logger.e(result);
                Gson gson = new Gson();
                final ShouYeDataModel shouYeDataModel = gson.fromJson(result, ShouYeDataModel.class);


                Observable.create(new Observable.OnSubscribe<ShouYeDataModel>() {
                    @Override
                    public void call(Subscriber<? super ShouYeDataModel> subscriber) {
                        subscriber.onNext(shouYeDataModel);
                    }
                }).subscribe(Subscriber);

            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onPrepare() {

            }

            @Override
            public void onLoadFinish() {

            }
        });
    }

    @Override
    public Observable<PendaStarDataBean> loadPendaStarData() {


        HashMap<String, String> map1 = new HashMap<>();
        map1.put("version","3.0.2.3057");
        map1.put("plat","android");
        map1.put("channel","oppo");

        Log.e(TAG, "loadPendaStarData: 返回熊猫的数据" );


        return PendaStarApi.getApiService().getList(map1).compose(new  AndroidIOToMain.IOToMainTransformer<PendaStarDataBean>());
    }


}








