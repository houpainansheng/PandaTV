package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/30.
 */
public class QuanBuFragListBean {


    private List<QuanBuFragBean> items;

    private String total;

    public List<QuanBuFragBean> getItems() {
        return items;
    }

    public void setItems(List<QuanBuFragBean> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
