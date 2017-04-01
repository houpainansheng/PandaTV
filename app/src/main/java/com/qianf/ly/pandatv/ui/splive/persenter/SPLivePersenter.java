package com.qianf.ly.pandatv.ui.splive.persenter;

import com.qianf.ly.pandatv.bean.PaGift;
import com.qianf.ly.pandatv.bean.PaItemGift;
import com.qianf.ly.pandatv.ui.splive.contrat.SPLiveContrat;

import rx.Observer;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SPLivePersenter extends SPLiveContrat.Presenter{


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

    }
}
