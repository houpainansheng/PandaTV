package com.qianf.ly.pandatv.ui.main.fragment.shouye.presenter;

import android.util.Log;

import com.qianf.ly.pandatv.bean.QuanBuFragDataBean;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.contract.QuanBuContract;

import rx.Observer;

/**
 * Created by 樊康 on 2017/3/30.
 */

public class QuanBuPresenter extends QuanBuContract.QuanBuPresenter {

     public static final String AA="ss";

    @Override
    public void initLoadQuaBuFragData() {

        mModel.loadQuanBuFragData().subscribe(new Observer<QuanBuFragDataBean>() {
            @Override
            public void onCompleted() {
                Log.e(AA, "onCompleted: 全部的页面加载数据成功 " );
            }

            @Override
            public void onError(Throwable e) {

                Log.e(AA, "onError: 全部的页面加载数据失败 " );
            }

            @Override
            public void onNext(QuanBuFragDataBean quanBuFragDataBean) {

                Log.e(AA, "onNext: 数据为:"+ quanBuFragDataBean);
                 mView.returnQuanBuFragData(quanBuFragDataBean.getData());
            }
        });

    }

    @Override
    public void initLoadQuaBuFragPage(int page) {
        mModel.loadQuanBuFragPageData(page).subscribe(new Observer<QuanBuFragDataBean>() {
            @Override
            public void onCompleted() {
                Log.e(AA, "onCompleted: 全部的页面加载数据成功 " );
            }

            @Override
            public void onError(Throwable e) {

                Log.e(AA, "onError: 全部的页面加载数据失败 " );
            }

            @Override
            public void onNext(QuanBuFragDataBean quanBuFragDataBean) {

                Log.e(AA, "onNext: 数据为:"+ quanBuFragDataBean);
                mView.returnQuanBuFragPageData(quanBuFragDataBean.getData());
            }
        });
    }
}
