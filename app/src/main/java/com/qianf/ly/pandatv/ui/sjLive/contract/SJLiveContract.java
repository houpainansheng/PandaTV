package com.qianf.ly.pandatv.ui.sjLive.contract;

import com.qianf.ly.pandatv.bean.Gift;
import com.qianf.ly.pandatv.bean.ItemGift;
import com.qianf.ly.pandatv.bean.PaGift;
import com.qianf.ly.pandatv.bean.PaItemGift;
import com.qianf.ly.pandatv.bean.PaPerson;
import com.qianf.ly.pandatv.bean.Person;
import com.qianf.ly.pandatv.bean.SjMsg;
import com.qianf.ly.pandatv.bean.paSJMsg;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import java.util.List;

import rx.Observer;

/**
 * Created by baisaikele on 2017/3/25.
 */

public interface SJLiveContract {


    // 定义Presenter
    public abstract class Presenter extends BasePresenter<Model,SJLiveView> {

      public abstract void initItemData();


    }

    // 定义Model
    interface Model extends BaseModel {

        void  loaditemGiftData(Observer<PaItemGift> observer);
        void  loadGiftData(Observer<PaGift> observer);
        void  loadMsgData(Observer<paSJMsg> obsever);
        void  loadPerData(Observer<PaPerson> observer);


    }

    // 定义View
    public interface SJLiveView extends BaseView {
       void returnitemGiftData(List<ItemGift> itemGifts);
       void returngiftData(List<Gift> gifts);
       void returnMsgData(List<SjMsg> sjMsgs);
        void returnPerData(List<Person> persons);


    };
}
