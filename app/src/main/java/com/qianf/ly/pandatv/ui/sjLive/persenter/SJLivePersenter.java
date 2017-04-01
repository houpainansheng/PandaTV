package com.qianf.ly.pandatv.ui.sjLive.persenter;

import com.qianf.ly.pandatv.bean.PaGift;
import com.qianf.ly.pandatv.bean.PaItemGift;
import com.qianf.ly.pandatv.bean.PaPerson;
import com.qianf.ly.pandatv.bean.paSJMsg;
import com.qianf.ly.pandatv.ui.sjLive.contract.SJLiveContract;

import rx.Observer;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SJLivePersenter extends SJLiveContract.Presenter {


    @Override
    public void initItemData() {

        mModel.loadGiftData(new Observer<PaGift>() {
            @Override
                public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PaGift gifts) {


                mView.returngiftData(gifts.getGifts());
            }
        });

        mModel.loaditemGiftData(new Observer<PaItemGift>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PaItemGift itemGifts) {

                mView.returnitemGiftData(itemGifts.getItemGifts());
            }
        });

        mModel.loadMsgData(new Observer<paSJMsg>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(paSJMsg sjMsgs) {

                mView.returnMsgData(sjMsgs.getSjMsgs());
            }
        });

        mModel.loadPerData(new Observer<PaPerson>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(PaPerson persons) {

                mView.returnPerData(persons.getPersons());
            }
        });

    }
}
