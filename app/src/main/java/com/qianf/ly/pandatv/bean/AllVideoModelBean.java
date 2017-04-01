package com.qianf.ly.pandatv.bean;

/**
 * Created by 樊康 on 2017/3/29.
 */
public class AllVideoModelBean {

    /**
     * "id":"775493",
     *  "createtime":"2017-02-16 14:14:24",
     "updatetime":"2017-03-29 11:25:26",
     *  "name":"兽王：不打匹配打排位，赛季末不怕跪！",
     *   "hostid":"73330894",
     "person_num":"7965",
     "pictures":Object{...},
     "userinfo":Object{...},
     "duration":"11366"
     */
     private String id;
    private String createtime;
    private String updatetime;
    private String name;
    private String hostid;
    private int person_num;
    private AllVideoPic  pictures;
    private AllVideoUser  userinfo;
    private String duration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHostid() {
        return hostid;
    }

    public void setHostid(String hostid) {
        this.hostid = hostid;
    }

    public int getPerson_num() {
        return person_num;
    }

    public void setPerson_num(int person_num) {
        this.person_num = person_num;
    }

    public AllVideoPic getPictures() {
        return pictures;
    }

    public void setPictures(AllVideoPic pictures) {
        this.pictures = pictures;
    }

    public AllVideoUser getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(AllVideoUser userinfo) {
        this.userinfo = userinfo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
