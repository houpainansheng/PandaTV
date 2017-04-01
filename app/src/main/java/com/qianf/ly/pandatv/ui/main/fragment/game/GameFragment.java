package com.qianf.ly.pandatv.ui.main.fragment.game;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.main.adapters.ViewPagerFragmentAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.game.model.GameContentFragment;
import com.qianf.ly.pandatv.ui.main.fragment.game.model.GameFenleiFragment;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baisaikele on 2017/3/24.
 */

public class GameFragment extends BaseFragment {

    public static final String TAG = GameFragment.class.getName();
    private TabLayout mTab;
    private ViewPager mViewPager;
    private ViewPagerFragmentAdapter mViewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_game;
    }

    @Override
    public void initView() {
        mTab = (TabLayout) layout.findViewById(R.id.game_frag_tab_top);
        mViewPager = (ViewPager) layout.findViewById(R.id.game_frag_view_content);
        //创建适配器
        mViewAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(), getFragment(), getTitles());
        //设置适配器
        mViewPager.setAdapter(mViewAdapter);
        //tabLayout与viewPager联动
        mTab.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(1);
    }

    private List<Fragment> getFragment() {
        List<Fragment> data = new ArrayList<>();
        data.add(new GameFenleiFragment());
        //
        GameContentFragment contentFragment = new GameContentFragment();
        contentFragment.getUrl("game_hot");
        data.add(contentFragment);
        //
        GameContentFragment contentFragment1 = new GameContentFragment();
        contentFragment1.getUrl("jingji");
        data.add(contentFragment1);
        //
        GameContentFragment contentFragment2 = new GameContentFragment();
        contentFragment2.getUrl("zjdj");
        data.add(contentFragment2);
        //
        GameContentFragment contentFragment3 = new GameContentFragment();
        contentFragment3.getUrl("wangyou");
        data.add(contentFragment3);
        //
        GameContentFragment contentFragment4 = new GameContentFragment();
        contentFragment4.getUrl("shouyou");
        data.add(contentFragment4);

        return data;
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        titles.add("分类");
        titles.add("热门");
        titles.add("热门竞技");
        titles.add("主机单机");
        titles.add("网游专区");
        titles.add("手游专区");


        return titles;
    }
}
