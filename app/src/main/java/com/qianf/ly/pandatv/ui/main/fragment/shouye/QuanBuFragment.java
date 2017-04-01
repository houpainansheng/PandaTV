package com.qianf.ly.pandatv.ui.main.fragment.shouye;

import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.Toast;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.QuanBuFragListBean;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.adapters.QuanBuAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.contract.QuanBuContract;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.model.QuanBuModel;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.presenter.QuanBuPresenter;
import com.rock.mvplibrary.base.BaseFragment;

import butterknife.BindView;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class QuanBuFragment extends BaseFragment implements QuanBuContract.QuanBuView, SwipeRefreshLayout.OnRefreshListener, AbsListView.OnScrollListener {

     private QuanBuModel mModel;
     private QuanBuPresenter mPresenter;

    @BindView(R.id.frag_quanbu_swipe)
    SwipeRefreshLayout mRefresh;
      @BindView(R.id.frag_quanbu_grid)
     GridView mGrid;
    private QuanBuAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_quanbu;
    }

    @Override
    public void initView() {

         mModel = new QuanBuModel();
        mPresenter = new QuanBuPresenter();
        mPresenter.setVM(this,mModel);

        //Presenter调用自己的方法
        mPresenter.initLoadQuaBuFragData();


        adapter = new QuanBuAdapter(getActivity(),null, R.layout.frag_tuijian_item_gridview);
        mGrid.setAdapter(adapter);

         //设置刷新的监听
        mRefresh.setOnRefreshListener(this);
        //设置刷新球的颜色
        mRefresh.setColorSchemeResources(R.color.colorDiBu);
        //设置刷新球的大小
        mRefresh.setOnRefreshListener(this);

        //GridView滑到底部
        mGrid.setOnScrollListener(this);
    }

    @Override
    public void returnQuanBuFragData(QuanBuFragListBean data) {

         mRefresh.setRefreshing(false);
         adapter.updateRes(data.getItems());
    }

    //在这个方法中进行加载更多数据的操作
    @Override
    public void returnQuanBuFragPageData(QuanBuFragListBean data) {

        Log.e("aa", "returnQuanBuFragPageData: 数据的长度"+data.getItems().size() );
         adapter.addRes(data.getItems());
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

    //刷新方法
    @Override
    public void onRefresh() {

        mPresenter.initLoadQuaBuFragData();
    }

    private boolean isBottom = false;
    private int page = 1;
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

        if (isBottom &&scrollState==SCROLL_STATE_IDLE){
            Toast.makeText(getActivity(), "到底了", Toast.LENGTH_SHORT).show();
            isBottom = false;
            mPresenter.initLoadQuaBuFragPage(++page);

        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

        if (firstVisibleItem+visibleItemCount==totalItemCount){
            isBottom =true;
        }
    }
}
