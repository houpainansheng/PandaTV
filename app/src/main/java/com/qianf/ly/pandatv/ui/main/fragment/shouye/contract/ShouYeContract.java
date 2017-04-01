package com.qianf.ly.pandatv.ui.main.fragment.shouye.contract;

import com.qianf.ly.pandatv.bean.PendaStarDataBean;
import com.qianf.ly.pandatv.bean.QuanBuFragListBean;
import com.qianf.ly.pandatv.bean.ShouYeModelListBean;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.callback.PendaCallBack;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 *
 */

public interface ShouYeContract {

    //定义Presenter
    public   abstract  class  ShouYePresenter extends BasePresenter<ShouYeModel,ShouYeView>{

    //  分页加载

        // 定义的加载数据的方法
        public abstract void initLoadData();
        public abstract void initLoadStarData(PendaCallBack callBacks);



    }


    //定义Model
    interface  ShouYeModel  extends BaseModel{

         //获取首页的推荐页面的lsitVIew的数据
//        Observable<ShouYeDataModel> loadShouYeModlListData();

        void loadShouYeModelListData(Subscriber Subscriber);

        //获取熊猫星颜的数据
         Observable<PendaStarDataBean> loadPendaStarData();


    }

    //定义推荐首页页面的View
    public interface ShouYeView extends BaseView{

        //获得推荐页面的数据
        void returnTuijianData( List<ShouYeModelListBean> data);

    }

    //定义推荐首页页面的View
    public interface QuanBuView extends BaseView{

        //返回了首页第三个fragment的数据
        void  returnQuanBuFragData(QuanBuFragListBean data);
    }

}

