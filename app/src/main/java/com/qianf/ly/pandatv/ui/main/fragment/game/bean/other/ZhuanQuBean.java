package com.qianf.ly.pandatv.ui.main.fragment.game.bean.other;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */

public class ZhuanQuBean {
    private String id;
    private String card_type;
    private String card_title;
    private String datanum;
    private List<RoomInfoBean> items;
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_title() {
        return card_title;
    }

    public void setCard_title(String card_title) {
        this.card_title = card_title;
    }

    public String getDatanum() {
        return datanum;
    }

    public void setDatanum(String datanum) {
        this.datanum = datanum;
    }

    public List<RoomInfoBean> getItems() {
        return items;
    }

    public void setItems(List<RoomInfoBean> items) {
        this.items = items;
    }
}
