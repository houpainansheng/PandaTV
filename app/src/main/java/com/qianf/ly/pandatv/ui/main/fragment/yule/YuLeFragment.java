package com.qianf.ly.pandatv.ui.main.fragment.yule;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.R2;
import com.qianf.ly.pandatv.ui.main.fragment.yule.adapter.YuLeFragmentViewpagerAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/31.
 */

public class YuLeFragment extends BaseFragment {
    public static final String TAG = YuLeFragment.class.getName();

    @BindView(R2.id.frag_yule_tab_title)
    TabLayout mTab;
    @BindView(R2.id.frag_yule_vp_content)
    ViewPager mViewPager;
    @Override
    protected int getLayoutId() {
        return R.layout.frag_yule;
    }

    @Override
    public void initView() {
        mViewPager.setAdapter(new YuLeFragmentViewpagerAdapter(getChildFragmentManager(),getData(),null));
    }



    private List<Fragment> getData() {
        List<Fragment> data = new ArrayList<>();
        return data;
    }
}
