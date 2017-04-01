package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.constants.ShouYeHttpParams;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 樊康 on 2017/3/28.
 */

public class AllGameApi {

    private static  AllGameApiService mApiService;

    public static  AllGameApiService getApiService(){
        if (mApiService == null){
            initService();
        }
        return  mApiService;
    }

    private static void initService() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ShouYeHttpParams.ALL_GAME_HOST)
                .build();

        mApiService =  retrofit.create(AllGameApiService.class);
    }
}
