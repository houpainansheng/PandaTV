package com.qianf.ly.pandatv.bean;

import android.graphics.Bitmap;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class ItemGift {

    private Bitmap bitmap;
    private int money;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemGift itemGift = (ItemGift) o;

        if (money != itemGift.money) return false;
        return name != null ? name.equals(itemGift.name) : itemGift.name == null;

    }

    @Override
    public int hashCode() {
        int result = money;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public ItemGift(Bitmap bitmap, int money, String name) {
        this.bitmap = bitmap;
        this.money = money;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
