package com.qianf.ly.pandatv.ui.splive.fragment;

import com.qianf.ly.pandatv.R;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.ButterKnife;

/**
 * Created by baisaikele on 2017/3/28.
 */

public class ZhuBoFragment extends BaseFragment {
    @Override
    protected int getLayoutId() {
        return R.layout.frag_spl_zhubo;
    }

    @Override
    public void initView() {
        ButterKnife.bind(getActivity());

    }
}