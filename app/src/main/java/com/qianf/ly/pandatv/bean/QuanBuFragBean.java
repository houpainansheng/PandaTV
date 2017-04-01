package com.qianf.ly.pandatv.bean;

/**
 * Created by 樊康 on 2017/3/30.
 */
public class QuanBuFragBean {

    /**
     * "id":"10027",
     * "name":"瓦莉拉：蓝龙贼的最后荣光？",
     * "hostid":"3009998",
     * "person_num":"223601",
     * "classification":"hearthstone",
     * "pictures":{
     * "img":"http://i6.pdim.gs/90/cc9971b86da41e470c335150534d999b/w338/h190.jpg"
     * },
     * "createtime":"2015-09-20 22:46:03",
     * "start_time":"1490862731",
     * "level":"9",
     * "userinfo":Object{...},
     * "duration":"11211"
     */

    private String id;
    private String name;
    private String hostid;
    private int person_num;
    private String classification;
    private QuanBuFragPic pictures;
    private String createtime;
    private String start_time;
    private QuanBuFragUserInfo userinfo;
    private String duration;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public QuanBuFragPic getPictures() {
        return pictures;
    }

    public void setPictures(QuanBuFragPic pictures) {
        this.pictures = pictures;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public QuanBuFragUserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(QuanBuFragUserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
