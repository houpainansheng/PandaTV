package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class ShouYeDataModel {

     private String errno;

    private List<ShouYeModelListBean> data;

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public List<ShouYeModelListBean> getData() {
        return data;
    }

    public void setData(List<ShouYeModelListBean> data) {
        this.data = data;
    }
}
