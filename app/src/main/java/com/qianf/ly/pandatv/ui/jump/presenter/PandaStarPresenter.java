package com.qianf.ly.pandatv.ui.jump.presenter;

import android.util.Log;

import com.qianf.ly.pandatv.bean.PandaStarActivityDataBean;
import com.qianf.ly.pandatv.ui.jump.Contract.PandaActContract;

import rx.Observer;

/**
 * Created by 樊康 on 2017/3/31.
 */

public class PandaStarPresenter extends PandaActContract.Presenter {



    @Override
    public void loadData() {

        mModel.returnData().subscribe(new Observer<PandaStarActivityDataBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {

                Log.e("sssssssssssssssss", "onError: 错啦 " );
            }

            @Override
            public void onNext(PandaStarActivityDataBean dataBean) {

                mView.returnData(dataBean);
            }
        });
    }
}
