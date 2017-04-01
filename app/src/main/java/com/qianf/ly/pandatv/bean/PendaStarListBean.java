package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/28.
 */

public class PendaStarListBean {

    private List<PendaStarBean>  items;

    private String total ;

    private String ename;
    private String cname;
    private  String icon;

    public List<PendaStarBean> getItems() {
        return items;
    }

    public void setItems(List<PendaStarBean> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
