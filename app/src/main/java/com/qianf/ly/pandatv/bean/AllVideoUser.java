package com.qianf.ly.pandatv.bean;

/**
 * Created by 樊康 on 2017/3/29.
 */
public class AllVideoUser {

    /**
     *  "userinfo":{
     "nickName":"兽王哥哥",
     "rid":73330894,
     "avatar":"http://i9.pdim.gs/15b1bd93bae4cbfabad5cc08603cdaae.jpg",
     "userName":""
     },
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

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
