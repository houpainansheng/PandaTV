package com.qianf.ly.pandatv.ui.main.fragment.shouye.presenter;

import android.util.Log;

import com.qianf.ly.pandatv.bean.PendaStarDataBean;
import com.qianf.ly.pandatv.bean.ShouYeDataModel;
import com.qianf.ly.pandatv.bean.ShouYeModelListBean;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.callback.PendaCallBack;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.contract.ShouYeContract;

import java.util.List;

import rx.Observer;
import rx.Subscriber;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class TuiJianPresenter extends ShouYeContract.ShouYePresenter {

    private static final String TAG = TuiJianPresenter.class.getSimpleName();


    private PendaCallBack callBack;


    @Override
    public void initLoadData() {

        mModel.loadShouYeModelListData(new Subscriber<ShouYeDataModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ShouYeDataModel shouYeDataModel) {

                Log.e(TAG, "onNext: " + shouYeDataModel.getErrno());
                List<ShouYeModelListBean> data = shouYeDataModel.getData();

                Log.e(TAG, "onNext: 得到所有的数据" );
                for (int i = 0; i < data.size(); i++) {
                    if (data.get(i).getCard_title().equals("猜你喜欢")) {
                        data.remove(i);
                    }
                }
                Log.e(TAG, "onNext: "+data.size() );
                mView.returnTuijianData(data);

            }

        });

    }

    @Override
    public void initLoadStarData(PendaCallBack callBacks) {

        this.callBack=callBacks;
        mModel.loadPendaStarData().subscribe(new Observer<PendaStarDataBean>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: 加载出了数据");
            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG, "onError: 加载数据失败");
            }

            @Override
            public void onNext(PendaStarDataBean data) {

             callBack.retuenData(data);

            }

        });
    }




}
