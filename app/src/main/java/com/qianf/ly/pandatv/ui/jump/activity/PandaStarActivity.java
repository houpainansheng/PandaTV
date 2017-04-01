package com.qianf.ly.pandatv.ui.jump.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.PandaStarActivityDataBean;
import com.qianf.ly.pandatv.ui.jump.Contract.PandaActContract;
import com.qianf.ly.pandatv.ui.jump.adapters.PandaActAdapter;
import com.qianf.ly.pandatv.ui.jump.model.PandaStarModel;
import com.qianf.ly.pandatv.ui.jump.presenter.PandaStarPresenter;
import com.qianf.ly.pandatv.ui.sjLive.SJLiveActivity;
import com.rock.mvplibrary.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by 樊康 on 2017/3/31.
 */

public class PandaStarActivity extends BaseActivity<PandaStarPresenter,PandaStarModel> implements PandaActContract.PandaActView, SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {


    private static final String TAG = PandaStarActivity.class.getSimpleName();
    @BindView(R.id.activity_panda_star_swipe)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.activity_panda_star_grid)
    GridView  mGrid;
    private PandaActAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_panda_star;
    }

    @Override
    public void initPresenter() {

         mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

         mPresenter.loadData();

        adapter = new PandaActAdapter(this,null, R.layout.penda_star_gv_item);
        mGrid.setAdapter(adapter);

        mGrid.setOnItemClickListener(this);

        mRefresh.setOnRefreshListener(this);
    }

    @Override
    public void returnData(PandaStarActivityDataBean dataBean) {

       mRefresh.setRefreshing(false);
        Log.e(TAG, "returnData: 熊猫的长度为:"+dataBean.getData().getItems().size() );
        adapter.updateRes(dataBean.getData().getItems());

    }

    @Override
    public void onStartLoad() {

    }

    @Override
    public void onStopLoad() {

    }

    @Override
    public void onError(String errorInfo) {

    }

    @Override
    public void onRefresh() {

        mPresenter.loadData();
    }

    //点击item,跳转到视频直播
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this,SJLiveActivity.class);

        startActivity(intent);
    }
}
