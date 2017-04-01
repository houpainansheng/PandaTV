package com.qianf.ly.pandatv.ui.main.contract;

import com.qianf.ly.pandatv.bean.AllVideoDataBean;
import com.qianf.ly.pandatv.bean.AllVideoModelBean;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import java.util.List;

import rx.Observable;

/**
 * Created by 樊康 on 2017/3/28.
 */

public interface MainContract  {

    // 定义Presenter
    public abstract class Presenter extends BasePresenter<MainModel,MainView> {


        public abstract void initData(String cate);

        public abstract void initPageData(int page);





    }

    // 定义Model
    interface MainModel extends BaseModel {

      Observable<AllVideoDataBean> getData(String cate);

      Observable<AllVideoDataBean> getPageData(int page);


    }

    // 定义View
    public interface MainView extends BaseView {

        void  getAllVideoData(List<AllVideoModelBean> data);

        void  getAllVideoPageData(List<AllVideoModelBean> data);
    };
}
