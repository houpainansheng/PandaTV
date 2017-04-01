package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class paSJMsg {

    private List<SjMsg> sjMsgs;

    public paSJMsg(List<SjMsg> sjMsgs) {
        this.sjMsgs = sjMsgs;
    }

    public List<SjMsg> getSjMsgs() {
        return sjMsgs;
    }

    public void setSjMsgs(List<SjMsg> sjMsgs) {
        this.sjMsgs = sjMsgs;
    }
}
