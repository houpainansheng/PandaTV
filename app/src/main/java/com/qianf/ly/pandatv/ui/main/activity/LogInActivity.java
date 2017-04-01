package com.qianf.ly.pandatv.ui.main.activity;

import android.view.View;
import android.widget.ImageView;

import com.qianf.ly.pandatv.R;
import com.rock.mvplibrary.base.BaseActivity;

public class LogInActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mImage;

    @Override
    public int getLayoutId() {
        return R.layout.activity_log_in;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mImage = (ImageView) findViewById(R.id.activity_login_iv_back);
        mImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_login_iv_back:
            this.finish();
            break;
        }
    }
}
