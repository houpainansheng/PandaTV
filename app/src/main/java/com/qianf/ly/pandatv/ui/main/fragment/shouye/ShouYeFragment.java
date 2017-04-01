package com.qianf.ly.pandatv.ui.main.fragment.shouye;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.R2;
import com.qianf.ly.pandatv.ui.main.adapters.ViewPagerFragmentAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by 樊康 on 2017/3/25.
 */

public class ShouYeFragment extends BaseFragment {

    public static final String TAG = ShouYeFragment.class.getName();

    @BindView(R2.id.shouye_frag_viewPager)
    ViewPager mViewPager;
    @BindView(R.id.shouye_frag_tab)
    TabLayout mTabLayout;
    @BindView(R.id.shouye_frag_image_search)
    ImageView mImage;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shouye;
    }

    @Override
    public void initView() {


        mViewPager.setAdapter(new ViewPagerFragmentAdapter(getChildFragmentManager(), getData(), getTitles()));
        mTabLayout.setupWithViewPager(mViewPager);

        mViewPager.setCurrentItem(1);
    }


    public List<Fragment> getData() {

        List<Fragment> data = new ArrayList<>();
        data.add(new DingYueFragment());
        data.add(new TuiJianFragment());
        data.add(new QuanBuFragment());
        return data;
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();

        titles.add("订阅");
        titles.add("推荐");
        titles.add("全部");

        return titles;
    }
}
