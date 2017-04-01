package com.qianf.ly.pandatv.ui.main.presenter;

import android.util.Log;

import com.qianf.ly.pandatv.bean.AllVideoDataBean;
import com.qianf.ly.pandatv.bean.AllVideoModelBean;
import com.qianf.ly.pandatv.ui.main.contract.MainContract;

import java.util.List;

import rx.Observer;

/**
 * Created by Administrator on 2017/3/25.
 */

public class MainPresenter extends MainContract.Presenter {

    private static final String TAG = MainPresenter.class.getSimpleName();


    @Override
    public void initData(String cate) {

        mModel.getData(cate).subscribe(new Observer<AllVideoDataBean>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: 已成功 " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: 失败了" );
            }

            @Override
            public void onNext(AllVideoDataBean dataBean) {


                List<AllVideoModelBean> items = dataBean.getData().getItems();
                mView.getAllVideoData(items);
                Log.e(TAG, "onNext: 长度为:"+items.size());
            }
        });
    }

    @Override
    public void initPageData(int page) {
        mModel.getPageData(page).subscribe(new Observer<AllVideoDataBean>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: 已成功 " );
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: 失败了" );
            }

            @Override
            public void onNext(AllVideoDataBean dataBean) {


                List<AllVideoModelBean> items = dataBean.getData().getItems();
                mView.getAllVideoPageData(items);
                Log.e(TAG, "onNext: 长度为:"+items.size());
            }
        });
    }


}
