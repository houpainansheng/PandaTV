package com.qianf.ly.pandatv.ui.main.fragment.shouye;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.ShouYeModelListBean;
import com.qianf.ly.pandatv.constants.ShouYeHttpParams;
import com.qianf.ly.pandatv.ui.main.activity.AllVideoActivity;
import com.qianf.ly.pandatv.ui.main.fragment.game.adapter.GameHeaderAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.LunBoListBean;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.PicBean;
import com.qianf.ly.pandatv.ui.main.fragment.game.model.ApiService;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.adapters.TuiJianAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.contract.ShouYeContract;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.model.TuiJianModel;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.presenter.TuiJianPresenter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 樊康 on 2017/3/25.
 */

public class TuiJianFragment extends BaseFragment implements ShouYeContract.ShouYeView, SwipeRefreshLayout.OnRefreshListener, View.OnClickListener, ViewPager.OnPageChangeListener,Handler.Callback {

    private static final String TAG = TuiJianFragment.class.getSimpleName();
    public static final int START = 100;
    private String path = ShouYeHttpParams.LIST_URL;
    private TuiJianPresenter mPresenter;
    private TuiJianModel mModel;

    private List<String> gameName = new ArrayList<>();
    private GameHeaderAdapter headerAdapter;
    private ViewPager mViewPager;
    private ImageView mFirstIcon;
    private ImageView mSecondIcon;
    private ImageView mThirdIcon;
    private ImageView mForthIcon;
    private TextView mForthName;
    private TextView mThirdName;
    private TextView mSecondName;
    private TextView mFirstName;
    private int lunBoNum;
    private Handler mHandler = new Handler(this);
    private int position=0;


    @BindView(R.id.tuijian_frag_swipe) //声明原生的刷新器
      SwipeRefreshLayout mRefresh;
    @BindView(R.id.tuijian_frag_list)
    ListView mListView;
    private TuiJianAdapter adapter;
    private Intent intent;

    @Override
    protected int getLayoutId() {

        ButterKnife.bind(getActivity());
        return R.layout.fragment_tuijian;
    }

    @Override
    public void initView() {

        //这三句代码必须设置
        mPresenter = new TuiJianPresenter();
        mModel = new TuiJianModel();
        mPresenter.setVM(this, mModel);


        //为头布局设置数据的方法
        initLunBo();


        //设置适配器
        adapter = new TuiJianAdapter(getActivity(), null, R.layout.frag_tuijian_item, mPresenter);
        mListView.setAdapter(adapter);
        mPresenter.initLoadData();

        //设置刷新
        initRefresh();

        initData();

    }

    //加载 头布局的方法
    private void initData() {


        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ShouYeHttpParams.HOST_URL)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        HashMap<String, String> map = new HashMap<>();

//  http://api.m.panda.tv/?method=slider.cate&cate=index
// &__version=3.0.2.3057&__plat=android&__channel=oppo

        map.put("method", "slider.cate");
        map.put("cate", "index");
        map.put("__version", "3.0.2.3057");
        map.put("__plat", "android");
        map.put("__channel", "oppo");

        Call<LunBoListBean> lunBoListBean = apiService.getLunBoListBean(map);

        lunBoListBean.enqueue(new Callback<LunBoListBean>() {


            @Override
            public void onResponse(Call<LunBoListBean> call, Response<LunBoListBean> response) {
                if (response.body().getData().getBanners().size() != 0) {
                    mRefresh.setRefreshing(false);
                    headerAdapter.addData(response.body().getData().getBanners());
                    mViewPager.setVisibility(View.VISIBLE);
                    lunBoNum = response.body().getData().getBanners().size();
                } else {
                    mViewPager.setVisibility(View.GONE);
                }

                mViewPager.setCurrentItem(1);
                mHandler.sendEmptyMessage(START);
                List<PicBean> navs = response.body().getData().getNavs();
                for (int i = 0; i < 4; i++) {
                    String url = navs.get(i).getUrl();
                    for (int j = 0; j < url.length(); j++) {
                        if (url.charAt(j) == '?') {
                            gameName.add(url.substring(15, j));
                        }
                    }
                }
                ImageLoader.getInstance().displayImage(navs.get(0).getImg(), mFirstIcon);
                ImageLoader.getInstance().displayImage(navs.get(1).getImg(), mSecondIcon);
                ImageLoader.getInstance().displayImage(navs.get(2).getImg(), mThirdIcon);
                ImageLoader.getInstance().displayImage(navs.get(3).getImg(), mForthIcon);
                mFirstName.setText(navs.get(0).getTitle());
                mSecondName.setText(navs.get(1).getTitle());
                mThirdName.setText(navs.get(2).getTitle());
                mForthName.setText(navs.get(3).getTitle());


            }

            @Override
            public void onFailure(Call<LunBoListBean> call, Throwable t) {

            }
        });
    }


    //设置头布局的方法
    private void initLunBo() {

        if (mListView.getHeaderViewsCount() > 0) {
            return;
        }
        //定义头部局
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.frag_game_view_header, null, false);
        //设置头部局
        headerAdapter = new GameHeaderAdapter(null, getActivity());
        mFirstIcon = ((ImageView) headView.findViewById(R.id.frag_game_iv_first_icon));
        mFirstIcon.setOnClickListener(this);
        mSecondIcon = ((ImageView) headView.findViewById(R.id.frag_game_iv_second_icon));
        mSecondIcon.setOnClickListener(this);
        mThirdIcon = ((ImageView) headView.findViewById(R.id.frag_game_iv_third_icon));
        mThirdIcon.setOnClickListener(this);
        mForthIcon = ((ImageView) headView.findViewById(R.id.frag_game_iv_forth_icon));
        mForthIcon.setOnClickListener(this);
        mForthName = ((TextView) headView.findViewById(R.id.frag_game_tv_forth_name));
        mForthName.setOnClickListener(this);
        mThirdName = ((TextView) headView.findViewById(R.id.frag_game_tv_third_name));
        mThirdName.setOnClickListener(this);
        mSecondName = ((TextView) headView.findViewById(R.id.frag_game_tv_second_name));
        mSecondName.setOnClickListener(this);
        mFirstName = ((TextView) headView.findViewById(R.id.frag_game_tv_first_name));
        mFirstName.setOnClickListener(this);
        //
        mViewPager = (ViewPager) headView.findViewById(R.id.frag_game_vp_lunbo);

        mViewPager.setAdapter(headerAdapter);
        mViewPager.addOnPageChangeListener(this);
        //添加头部据
        mListView.addHeaderView(headView);
    }

    //刷新方法
    private void initRefresh() {
        mRefresh.setOnRefreshListener(this);
        //设置刷新球的颜色
        mRefresh.setColorSchemeResources(R.color.colorDiBu);
        //设置刷新球的大小
        // mRefresh.setSize(SwipeRefreshLayout.LARGE);
    }


    @Override
    public void returnTuijianData(List<ShouYeModelListBean> data) {

//        Logger.e(data.toString());

         mRefresh.setRefreshing(false);
         adapter.updateRes(data);

    }


    @Override
    public void onStartLoad() {

        Log.e(TAG, "onStartLoad: 正在加载");
    }

    @Override
    public void onStopLoad() {

        Log.e(TAG, "onStopLoad: 加载完毕 ");
    }

    @Override
    public void onError(String errorInfo) {

        Log.e(TAG, "onError: 出错了");
    }

    //在这里应该设置viewPager的刷新,但现在还没写
    @Override
    public void onRefresh() {
        Log.e(TAG, "onRefresh: ");

         position = 0 ;

        initLunBo();
        mPresenter.initLoadData();

    }

    @Override
    public void onClick(View v) {
        intent = new Intent(getActivity(), AllVideoActivity.class);
        Log.e(TAG, "onClick: 进入点击方法");
        switch (v.getId()) {

            case R.id.frag_game_iv_first_icon:
            case R.id.frag_game_tv_first_name:
                if (gameName.size() == 4) {
                    intent.putExtra("gameName", gameName.get(0));
                    intent.putExtra("cname", mFirstName.getText().toString());
                    startActivity(intent);
                }

                break;
            case R.id.frag_game_iv_second_icon:
            case R.id.frag_game_tv_second_name:
                if (gameName.size() == 4) {
                    intent.putExtra("gameName", gameName.get(1));
                    intent.putExtra("cname", mSecondName.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.frag_game_iv_third_icon:
            case R.id.frag_game_tv_third_name:
                if (gameName.size() == 4) {
                    intent.putExtra("gameName", gameName.get(2));
                    intent.putExtra("cname", mThirdName.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.frag_game_iv_forth_icon:
            case R.id.frag_game_tv_forth_name:
                if (gameName.size() == 4) {
                    intent.putExtra("gameName", gameName.get(3));
                    intent.putExtra("cname", mForthName.getText().toString());
                    startActivity(intent);
                }
                break;

        }


    }

    //ViewPager 的滚动监听
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what){
            case START:
                if (mViewPager.getVisibility()==View.VISIBLE){

                    mViewPager.setCurrentItem(++position%lunBoNum);
                    mHandler.sendEmptyMessageDelayed(START,3000);
                }
                break;
        }
        return true;
    }
}
