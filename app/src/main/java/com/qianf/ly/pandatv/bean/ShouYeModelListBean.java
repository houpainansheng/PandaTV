package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/27.
 */
public class ShouYeModelListBean {

    private String card_title;

    private List<ShouYeModelBean> items;

    private String total; //视频总数


    public String getCard_title() {
        return card_title;
    }

    public void setCard_title(String card_title) {
        this.card_title = card_title;
    }

    public List<ShouYeModelBean> getItems() {
        return items;
    }

    public void setItems(List<ShouYeModelBean> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
