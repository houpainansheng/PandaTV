package com.qianf.ly.pandatv.ui.main.fragment.yule.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */

public class YuLeFragmentViewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> data;
    private List<String> titles;

    public YuLeFragmentViewpagerAdapter(FragmentManager fm, List<Fragment> data,List<String> titles) {
        super(fm);

        this.data=data;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return data.get(position);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
