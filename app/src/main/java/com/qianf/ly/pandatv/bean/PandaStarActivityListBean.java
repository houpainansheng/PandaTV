package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/31.
 */
public class PandaStarActivityListBean {

    /**
     *  "items":Array[61],
     "total":61,
     "banners":Array[4]
     */

     private List<PandaStarActivityItem> items ;
    private String total;
    private List<PandaStarActivityBannner> banners;

    public List<PandaStarActivityItem> getItems() {
        return items;
    }

    public void setItems(List<PandaStarActivityItem> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<PandaStarActivityBannner> getBanners() {
        return banners;
    }

    public void setBanners(List<PandaStarActivityBannner> banners) {
        this.banners = banners;
    }
}
