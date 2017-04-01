package com.qianf.ly.pandatv.ui.main.fragment.game.bean.other;

/**
 * Created by Administrator on 2017/3/27.
 */

public class RoomInfoBean {
    private ClassificationBean classification;
    private String display_type;
    private String img;
    private String person_num;
    private String roomid;
    private String style_type;
    private String tag;
    private String tag_switch;
    private String title;
    private UserInfoBean userinfo;
    private String recommend;


    public ClassificationBean getClassification() {
        return classification;
    }

    public void setClassification(ClassificationBean classification) {
        this.classification = classification;
    }

    public UserInfoBean getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfoBean userinfo) {
        this.userinfo = userinfo;
    }

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPerson_num() {
        return person_num;
    }

    public void setPerson_num(String person_num) {
        this.person_num = person_num;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getStyle_type() {
        return style_type;
    }

    public void setStyle_type(String style_type) {
        this.style_type = style_type;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTag_switch() {
        return tag_switch;
    }

    public void setTag_switch(String tag_switch) {
        this.tag_switch = tag_switch;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
}
