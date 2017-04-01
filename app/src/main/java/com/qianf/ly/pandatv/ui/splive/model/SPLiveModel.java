package com.qianf.ly.pandatv.ui.splive.model;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.Gift;
import com.qianf.ly.pandatv.bean.ItemGift;
import com.qianf.ly.pandatv.bean.PaGift;
import com.qianf.ly.pandatv.bean.PaItemGift;
import com.qianf.ly.pandatv.ui.splive.contrat.SPLiveContrat;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



/**
 * Created by baisaikele on 2017/3/25.
 */

public class SPLiveModel implements SPLiveContrat.Model {

    Activity activity;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {

            switch (msg.what) {
                case 2:
                    loadGiftData(observer);

                    break;
            }

            return false;
        }
    });
    private Observer<PaGift> observer;
    private List<ItemGift> allItemGifts;

    public SPLiveModel() {


        allItemGifts = new ArrayList<>();

        Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_anni);
        allItemGifts.add(new ItemGift(bitmap, 100, "安妮"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_dema);
        allItemGifts.add(new ItemGift(bitmap, 300, "德玛"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_elas);
        allItemGifts.add(new ItemGift(bitmap, 500, "泽拉斯"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_ez);
        allItemGifts.add(new ItemGift(bitmap, 777, "ez"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_guanhui);
        allItemGifts.add(new ItemGift(bitmap, 888, "关辉"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_houzi);
        allItemGifts.add(new ItemGift(bitmap, 999, "猴子"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_huli);
        allItemGifts.add(new ItemGift(bitmap, 11111, "狐狸"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_hunan);
        allItemGifts.add(new ItemGift(bitmap, 22222, "火男"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_jians);
        allItemGifts.add(new ItemGift(bitmap, 33333, "剑圣"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_jiqiren);
        allItemGifts.add(new ItemGift(bitmap, 44444, "机器人"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_kapai);
        allItemGifts.add(new ItemGift(bitmap, 55555, "卡牌"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_nvjin);
        allItemGifts.add(new ItemGift(bitmap, 66666, "女警"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_xiazi);
        allItemGifts.add(new ItemGift(bitmap, 77777, "瞎子"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_ruiwen);
        allItemGifts.add(new ItemGift(bitmap, 88888, "瑞文"));
        bitmap = BitmapFactory.decodeResource(activity.getResources(), R.mipmap.lol_timo);
        allItemGifts.add(new ItemGift(bitmap, 99999, "提莫"));

    }

    public SPLiveModel(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void loaditemGiftData(Observer<PaItemGift> observer) {

        Observable.create(new Observable.OnSubscribe<PaItemGift>() {

            @Override
            public void call(Subscriber<? super PaItemGift> subscriber) {



                subscriber.onNext(new PaItemGift(allItemGifts));


            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    @Override
    public void loadGiftData(Observer<PaGift> observer) {


        this.observer = observer;
        Observable.create(new Observable.OnSubscribe<PaGift>() {
            @Override
            public void call(Subscriber<? super PaGift> subscriber) {

                handler.sendEmptyMessageDelayed(2, 2000);
                if (allItemGifts == null) {
                    return;
                }

                List<Gift> Gifts = new ArrayList<>();
                int x = (int) (Math.random() * allItemGifts.size());
                int i = (int) (Math.random() * 4);
                int num = (int) (Math.random() * 100);

                Gifts.add(new Gift(allItemGifts.get(x), "刘洋" + i, num));


                subscriber.onNext(new PaGift(Gifts));


            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
}
