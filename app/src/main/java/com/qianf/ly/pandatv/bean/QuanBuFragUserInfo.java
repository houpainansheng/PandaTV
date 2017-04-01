package com.qianf.ly.pandatv.bean;

/**
 * Created by 樊康 on 2017/3/30.
 */
public class QuanBuFragUserInfo {

    /**
     *  "nickName":"瓦莉拉的小伙伴",
     "rid":"3009998",
     "avatar":"http://i1.pdim.gs/t018f5b32e6e545f11f.jpg",
     "userName":""
     */
     private String nickName;
    private String rid;
    private String avatar;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }
}
