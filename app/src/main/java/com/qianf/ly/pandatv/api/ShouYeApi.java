package com.qianf.ly.pandatv.api;

import com.qianf.ly.pandatv.constants.ShouYeHttpParams;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class ShouYeApi {

    private static ShouYeApiService apiService;

    public static ShouYeApiService getApiService(){
        if (apiService == null){
            initApiService();
        }
        return  apiService;
    }

    private static void initApiService() {

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ShouYeHttpParams.HOST_URL)
                .build();

        apiService =  retrofit.create(ShouYeApiService.class);
    }
}
