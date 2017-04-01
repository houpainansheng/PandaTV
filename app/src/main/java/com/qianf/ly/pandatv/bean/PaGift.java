package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class PaGift {
    private List<Gift> gifts;

    public PaGift(List<Gift> gifts) {
        this.gifts = gifts;
    }

    public List<Gift> getGifts() {
        return gifts;
    }

    public void setGifts(List<Gift> gifts) {
        this.gifts = gifts;
    }
}
