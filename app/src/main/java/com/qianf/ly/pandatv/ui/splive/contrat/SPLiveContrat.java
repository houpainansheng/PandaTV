package com.qianf.ly.pandatv.ui.splive.contrat;

import com.qianf.ly.pandatv.bean.Gift;
import com.qianf.ly.pandatv.bean.ItemGift;
import com.qianf.ly.pandatv.bean.PaGift;
import com.qianf.ly.pandatv.bean.PaItemGift;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import java.util.List;

import rx.Observer;

/**
 * Created by baisaikele on 2017/3/29.
 */

public interface SPLiveContrat {


    // 定义Presenter
    public abstract class Presenter extends BasePresenter<Model,SPLiveView> {
        public abstract void initItemData();

    }

    // 定义Model
    public interface Model extends BaseModel {

        void  loaditemGiftData(Observer<PaItemGift> observer);
        void  loadGiftData(Observer<PaGift> observer);


    }

    // 定义View
    public interface SPLiveView extends BaseView {
        void returnitemGiftData(List<ItemGift> itemGifts);
        void returngiftData(List<Gift> gifts);


    }
}
