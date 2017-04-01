package com.qianf.ly.pandatv.bean;

/**
 * Created by 樊康 on 2017/3/31.
 */
public class PandaStarActivityBannner {

    /**
     *  "name":"熊猫ⅹ华硕校园主播选拔赛",
     "img":"https://image.xingyan.panda.tv/ec0d09b3c4eb2832c2d795cfe16596f6.jpeg",
     "actiontype":"appurl",
     "actionvalue":"http://m.xingyan.panda.tv/activity/xyzb.html",
     */
    private String name;
    private String img;
    private String actiontype;
    private String actionvalue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getActiontype() {
        return actiontype;
    }

    public void setActiontype(String actiontype) {
        this.actiontype = actiontype;
    }

    public String getActionvalue() {
        return actionvalue;
    }

    public void setActionvalue(String actionvalue) {
        this.actionvalue = actionvalue;
    }
}
