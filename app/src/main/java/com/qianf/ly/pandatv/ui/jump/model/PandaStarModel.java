package com.qianf.ly.pandatv.ui.jump.model;

import com.qianf.ly.pandatv.api.PandaActApi;
import com.qianf.ly.pandatv.bean.PandaStarActivityDataBean;
import com.qianf.ly.pandatv.ui.jump.Contract.PandaActContract;
import com.rock.mvplibrary.event.AndroidIOToMain;

import java.util.HashMap;

import rx.Observable;

/**
 * Created by 樊康 on 2017/3/31.
 */

public class PandaStarModel implements PandaActContract.PandaActModel {

    @Override
    public Observable<PandaStarActivityDataBean> returnData() {
/**
 * http://m.api.xingyan.panda.tv/room/list?
 * pageno=1&
 * pagenum=200&
 * status=0&
 * version=3.0.2.3057&
 * plat=android&
 * channel=oppo&
 * banner=1
 */
        HashMap<String,String> map = new HashMap<>();
        map.put("pageno","1");
        map.put("pagenum","200");
        map.put("status","0");
        map.put("version","3.0.2.3057");
        map.put("plat","android");
        map.put("channel","oppo");
        map.put("banner","1");

        return PandaActApi.getApiService().getList(map).compose(new AndroidIOToMain.IOToMainTransformer<PandaStarActivityDataBean>());
    }
}
