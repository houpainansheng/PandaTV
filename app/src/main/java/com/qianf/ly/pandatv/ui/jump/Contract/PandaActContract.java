package com.qianf.ly.pandatv.ui.jump.Contract;

import com.qianf.ly.pandatv.bean.PandaStarActivityDataBean;
import com.rock.mvplibrary.base.BaseModel;
import com.rock.mvplibrary.base.BasePresenter;
import com.rock.mvplibrary.base.BaseView;

import rx.Observable;

/**
 * Created by 樊康 on 2017/3/31.
 */

public interface PandaActContract {


      //定义Presenter
    public abstract class Presenter extends BasePresenter<PandaActModel,PandaActView>{

           public abstract void loadData();



      }


    // 定义Model
    interface PandaActModel extends BaseModel {


         Observable<PandaStarActivityDataBean>  returnData();
    }


  //定义View
  public  interface PandaActView extends  BaseView{

       void returnData(PandaStarActivityDataBean dataBean);

  }
}