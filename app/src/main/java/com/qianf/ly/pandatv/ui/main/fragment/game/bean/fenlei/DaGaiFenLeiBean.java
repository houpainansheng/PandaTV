package com.qianf.ly.pandatv.ui.main.fragment.game.bean.fenlei;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */

public class DaGaiFenLeiBean {
    private String cname;
    private String ename;
    private List<JuTiFenLeiBean> child_data;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public List<JuTiFenLeiBean> getChild_data() {
        return child_data;
    }

    public void setChild_data(List<JuTiFenLeiBean> child_data) {
        this.child_data = child_data;
    }
}
