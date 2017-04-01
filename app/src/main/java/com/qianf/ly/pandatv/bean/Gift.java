package com.qianf.ly.pandatv.bean;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class Gift {
    private  ItemGift gift;
    private String title;
    private int num;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gift gift1 = (Gift) o;

        if (gift != null ? !gift.equals(gift1.gift) : gift1.gift != null) return false;
        return title != null ? title.equals(gift1.title) : gift1.title == null;

    }

    @Override
    public int hashCode() {
        int result = gift != null ? gift.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Gift(ItemGift gift, String title, int num) {
        this.gift = gift;
        this.title = title;
        this.num = num;
    }

    public ItemGift getGift() {
        return gift;
    }

    public void setGift(ItemGift gift) {
        this.gift = gift;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
