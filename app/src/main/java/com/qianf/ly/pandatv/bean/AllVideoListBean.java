package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/29.
 */
public class AllVideoListBean {


     private List<AllVideoModelBean> items;

    private  int total;

    private AllVideoTypeBean  type;

    public List<AllVideoModelBean> getItems() {
        return items;
    }

    public void setItems(List<AllVideoModelBean> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public AllVideoTypeBean getType() {
        return type;
    }

    public void setType(AllVideoTypeBean type) {
        this.type = type;
    }
}
