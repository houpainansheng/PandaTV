package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.constants.ShouYeHttpParams;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 樊康 on 2017/3/28.
 */

public class PandaActApi {

    private static  PandaActApiService mApiService;

    public static  PandaActApiService getApiService(){
        if (mApiService == null){
            initService();
        }
        return  mApiService;
    }

    private static void initService() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ShouYeHttpParams.PENDA_STAR_HOST)
                .build();

        mApiService =  retrofit.create(PandaActApiService.class);
    }
}
