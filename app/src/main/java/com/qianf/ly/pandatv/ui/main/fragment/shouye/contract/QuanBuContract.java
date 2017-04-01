package com.qianf.ly.pandatv.ui.main.fragment.shouye.contract;

import com.qianf.ly.pandatv.bean.QuanBuFragDataBean;
import com.qianf.ly.pandatv.bean.QuanBuFragListBean;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by 樊康 on 2017/3/30.
 */

public interface QuanBuContract {

    //定义Presenter
    public   abstract  class  QuanBuPresenter extends BasePresenter<QuanBuContract.QuanBuModel,QuanBuContract.QuanBuView> {


        public abstract void initLoadQuaBuFragData();


        public abstract void initLoadQuaBuFragPage(int page);




    }


    //定义Model
    interface  QuanBuModel  extends BaseModel {



        //获取首页第三个Fragment的数据
        Observable<QuanBuFragDataBean>  loadQuanBuFragData();

        Observable<QuanBuFragDataBean>  loadQuanBuFragPageData(int page);

    }

    //定义推荐首页页面的View
    public interface QuanBuView extends BaseView{

        //返回了首页第三个fragment的数据
        void  returnQuanBuFragData(QuanBuFragListBean data);

        void  returnQuanBuFragPageData(QuanBuFragListBean data);

    }

}

