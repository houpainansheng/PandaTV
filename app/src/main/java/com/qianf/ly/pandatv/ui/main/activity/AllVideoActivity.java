package com.qianf.ly.pandatv.ui.main.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.AllVideoModelBean;
import com.qianf.ly.pandatv.ui.main.adapters.AllVideoAdapter;
import com.qianf.ly.pandatv.ui.main.contract.MainContract;
import com.qianf.ly.pandatv.ui.main.model.MainModel;
import com.qianf.ly.pandatv.ui.main.presenter.MainPresenter;
import com.qianf.ly.pandatv.ui.splive.SPLiveActivity;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.List;

import butterknife.BindView;


public class AllVideoActivity extends BaseActivity<MainPresenter,MainModel> implements MainContract.MainView, View.OnClickListener, AbsListView.OnScrollListener, SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    private static final String TAG = AllVideoActivity.class.getSimpleName();

    @BindView(R.id.activity_all_video_swipe)
    SwipeRefreshLayout mRefresh;
    @BindView(R.id.activity_all_video_list)
    GridView mGrid;
    private AllVideoAdapter adapter;
    @BindView(R.id.activity_all_video_title)
    TextView mText;
    @BindView(R.id.activity_all_video_image)
    Button mImage;
    private String gameName;


    @Override
    public int getLayoutId() {
        return R.layout.activity_all_video;
    }

    @Override
    public void initPresenter() {

        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {

        adapter = new AllVideoAdapter(this,null, R.layout.frag_tuijian_item_gridview);
        mGrid.setAdapter(adapter);

        //在这里获取加载更多按钮发过来的数据
        Intent intent = getIntent();
        gameName = intent.getStringExtra("gameName");

       mPresenter.initData(gameName);
        Log.e("tag", "initView: " );
        Log.e("tag", "initView: 获得到的游戏名"+gameName );



        String cname = intent.getStringExtra("cname");



        mText.setText(cname);

        //设置点击事件,点击放回上一个界面
        mImage.setOnClickListener(this);

        //GridView设置滑动事件
        mGrid.setOnScrollListener(this);
        mGrid.setOnItemClickListener(this);

        //刷新器设置刷新
      initRefresh();




    }

    private void initRefresh() {
        mRefresh.setOnRefreshListener(this);

        //设置刷新球的颜色
        mRefresh.setColorSchemeResources(R.color.colorDiBu);
    }



    @Override
    public void getAllVideoData(List<AllVideoModelBean> data) {
        mRefresh.setRefreshing(false);
        adapter.updateRes(data);

    }

    @Override
    public void getAllVideoPageData(List<AllVideoModelBean> data) {

        Log.e(TAG, "getAllVideoPageData: 上拉加载更多" );
        Toast.makeText(this, "加载了数据", Toast.LENGTH_SHORT).show();

        adapter.addRes(data);


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

    //点击返回上一个界面
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.activity_all_video_image:
                finish();
                break;
        }
    }

    //listView的滚动监听

    private boolean isBottom = false;
    private int i =1;
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        //scrollState == SCROLL_STATE_IDLE停止滑动的状态
        if (isBottom &&scrollState == SCROLL_STATE_IDLE){

            isBottom=false;
            Log.e(TAG, "onScrollStateChanged: 哈哈"+gameName+"页数:"+i );
             mPresenter.initPageData(++i);

        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (firstVisibleItem + visibleItemCount == totalItemCount){

            isBottom = true;
        }
    }

    @Override
    public void onRefresh() {
        mPresenter.initData(gameName);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, SPLiveActivity.class);
        startActivity(intent);

    }
}
