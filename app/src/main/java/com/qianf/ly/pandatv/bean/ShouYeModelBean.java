package com.qianf.ly.pandatv.bean;

/**
 * Created by 樊康 on 2017/3/27.
 */
public class  ShouYeModelBean {

    private  ShouYePetBean  classification;

    private String  img;
    private int person_num;

    private String roomid;

    private String title;

    private ShouYeUserinfo  userinfo;

    public ShouYePetBean getClassification() {
        return classification;
    }

    public void setClassification(ShouYePetBean classification) {
        this.classification = classification;
    }

    public int getPerson_num() {
        return person_num;
    }

    public void setPerson_num(int person_num) {
        this.person_num = person_num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ShouYeUserinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(ShouYeUserinfo userinfo) {
        this.userinfo = userinfo;
    }
}
