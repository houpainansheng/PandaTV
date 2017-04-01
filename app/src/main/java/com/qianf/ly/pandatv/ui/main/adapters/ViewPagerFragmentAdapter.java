package com.qianf.ly.pandatv.ui.main.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/25.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment>  data;
    private List<String> titles;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<Fragment>  data, List<String> titles) {
        super(fm);
        this.data = data ;
        this.titles = titles;
    }



    @Override
    public Fragment getItem(int position) {

        return data.get(position);
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
