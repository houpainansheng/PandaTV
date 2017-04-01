package com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager;

import java.util.List;

/**
 * Created by Administrator on 2017/3/28.
 */

public class LunBoBean {

    private List<ZhiBoBean> banners;
    private List<PicBean> navs;

    public List<ZhiBoBean> getBanners() {
        return banners;
    }

    public void setBanners(List<ZhiBoBean> banners) {
        this.banners = banners;
    }

    public List<PicBean> getNavs() {
        return navs;
    }

    public void setNavs(List<PicBean> navs) {
        this.navs = navs;
    }
}
