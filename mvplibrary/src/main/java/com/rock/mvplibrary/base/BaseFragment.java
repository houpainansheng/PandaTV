package com.rock.mvplibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Rock on 2017/3/24.
 */

public abstract class BaseFragment extends Fragment {

    protected View layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 初始化布局
        if (layout == null){
            layout = inflater.inflate(getLayoutId(),container,false);
        }
        // View注入
        ButterKnife.bind(this,layout);
        // 初始化Presenter

        // 初始化View
        this.initView();
        return layout;
    }

    protected abstract int getLayoutId();


    public abstract void initView();

}
