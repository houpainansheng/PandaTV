package com.qianf.ly.pandatv.bean;

import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class PaItemGift {
    private List<ItemGift> itemGifts;

    public List<ItemGift> getItemGifts() {
        return itemGifts;
    }

    public void setItemGifts(List<ItemGift> itemGifts) {
        this.itemGifts = itemGifts;
    }

    public PaItemGift(List<ItemGift> itemGifts) {
        this.itemGifts = itemGifts;
    }
}
