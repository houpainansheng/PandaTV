package com.rock.mvplibrary.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.rock.mvplibrary.utils.TypeUtil;

import butterknife.ButterKnife;

/**
 * Created by Rock on 2017/3/24.
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {

    public P mPresenter;

    public M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 在设置布局前做操作
        doBeforeLayout();
        // 设置布局
        setContentView(getLayoutId());
        // View注入
        ButterKnife.bind(this);
        // 初始化Presenter
        mPresenter = TypeUtil.getObject(this,0);
        // 初始化Model
        mModel = TypeUtil.getObject(this,1);
        // 初始化View和Model
        if (mPresenter != null){
            initPresenter();
        }
        // 初始化View
        this.initView();
    }

    protected void doBeforeLayout(){

    }

    public abstract int getLayoutId();

    public abstract void initPresenter();

    public abstract void initView();

}
