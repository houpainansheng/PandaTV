package com.qianf.ly.pandatv.ui.splive.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;

import com.qianf.ly.pandatv.R;
import com.rock.mvplibrary.adapters.BaisCommonFragmentPagerAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baisaikele on 2017/3/28.
 */

public class PaiHangFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    @Override
    protected int getLayoutId() {
        return R.layout.frag_spl_paihang;
    }

    @BindView(R.id.rb_1)
    RadioButton rb_1;
    @BindView(R.id.rb_2)
    RadioButton rb_2;
    @BindView(R.id.paihan_vp)
    ViewPager paihan_vp;



    @Override
    public void initView() {
        ButterKnife.bind(getActivity());
        List<Fragment> data=new ArrayList<>();
        data.add(new PaiHangLvFragment());
        data.add(new PaiHangLvFragment());

        paihan_vp.setAdapter(new BaisCommonFragmentPagerAdapter(getChildFragmentManager(),data));
        rb_1.setOnClickListener(this);
        rb_2.setOnClickListener(this);
        paihan_vp.setOnPageChangeListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_1:
                if (rb_1.isChecked()){
                    paihan_vp.setCurrentItem(0);
                }
                break;
            case R.id.rb_2:

                if (rb_2.isChecked()){
                    paihan_vp.setCurrentItem(1);
                }
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position==0) {
            rb_1.setChecked(true);
        }else {
            rb_2.setChecked(true);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}