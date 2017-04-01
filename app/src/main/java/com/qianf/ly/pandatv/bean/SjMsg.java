package com.qianf.ly.pandatv.bean;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SjMsg {
    private String name;
    private String msg;

    public SjMsg(String name, String msg) {
        this.name = name;
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
