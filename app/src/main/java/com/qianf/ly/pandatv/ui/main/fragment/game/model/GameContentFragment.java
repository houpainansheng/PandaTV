package com.qianf.ly.pandatv.ui.main.fragment.game.model;

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
import com.qianf.ly.pandatv.ui.main.activity.AllVideoActivity;
import com.qianf.ly.pandatv.ui.main.fragment.game.adapter.GameContentFragmentAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.game.adapter.GameHeaderAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.other.ZhuanQuListBean;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.LunBoListBean;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.PicBean;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */

public class GameContentFragment extends BaseFragment implements View.OnClickListener,ViewPager.OnPageChangeListener,Handler.Callback, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = GameContentFragment.class.getName();
    private static final int START = 100;
    @BindView(R.id.frag_game_sfl_refresh)
    SwipeRefreshLayout mSwipe;
    @BindView(R.id.game_frag_lv_content)
    ListView mListView;
    private GameContentFragmentAdapter adapter;
    private static final String FENLEI_TITLE = "http://api.m.panda.tv";


    private String cate;
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
    private Handler mHandler = new Handler(this);
    private int position=0;
    private int lunBoNum;
    private List<String> gameName;

    public void getUrl(String cate) {
        this.cate = cate;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.frag_game_content;
    }

    @Override
    public void initView() {

        mSwipe.setColorSchemeResources(R.color.colorDiBu);
        mSwipe.setOnRefreshListener(this);

        if (mListView.getHeaderViewsCount()>0) {
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
        //添加头部局
        mListView.addHeaderView(headView);


        adapter = new GameContentFragmentAdapter(getActivity(), null);
        mListView.setAdapter(adapter);
        initData("slider.cate");
        initData("card.list");


    }

    private void initData(String method) {
        gameName=new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(FENLEI_TITLE)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        HashMap<String, String> map = new HashMap<>();



        map.put("method", method);
        map.put("cate", cate);
        map.put("__version", "3.0.2.3057");
        map.put("__plat", "android");
        map.put("__channel", "guanwang");
        map.put("pt_time", "1490607416");
        map.put("pt_sign", "dd2b2ae0121b6ab26d3cb754866a6e85");
        if (method.equals("card.list")) {
            Call<ZhuanQuListBean> zhuanQuListBean = apiService.getZhuanQuListBean(map);

            zhuanQuListBean.enqueue(new Callback<ZhuanQuListBean>() {


                @Override
                public void onResponse(Call<ZhuanQuListBean> call, Response<ZhuanQuListBean> response) {
                    adapter.updateRes(response.body().getData());
                }

                @Override
                public void onFailure(Call<ZhuanQuListBean> call, Throwable t) {
                }
            });
        } else if (method.equals("slider.cate")) {
            Call<LunBoListBean> lunBoListBean = apiService.getLunBoListBean(map);

            lunBoListBean.enqueue(new Callback<LunBoListBean>() {



                @Override
                public void onResponse(Call<LunBoListBean> call, Response<LunBoListBean> response) {
                    if (response.body().getData().getBanners().size()!= 0) {
                        headerAdapter.addData(response.body().getData().getBanners());
                        mViewPager.setVisibility(View.VISIBLE);
                        lunBoNum=response.body().getData().getBanners().size();
                    }else {
                        mViewPager.setVisibility(View.GONE);
                    }

                    mViewPager.setCurrentItem(1);
                    mHandler.sendEmptyMessage(START);
                    List<PicBean> navs = response.body().getData().getNavs();
                    for (int i = 0; i < 4; i++) {
                        String url = navs.get(i).getUrl();
                        for (int j = 0; j < url.length(); j++) {
                            if (url.charAt(j)=='?') {
                                gameName.add(url.substring(15,j));
                            }
                        }
                    }
                    ImageLoader.getInstance().displayImage(navs.get(0).getImg(),mFirstIcon);
                    ImageLoader.getInstance().displayImage(navs.get(1).getImg(),mSecondIcon);
                    ImageLoader.getInstance().displayImage(navs.get(2).getImg(),mThirdIcon);
                    ImageLoader.getInstance().displayImage(navs.get(3).getImg(),mForthIcon);
                    mFirstName.setText(navs.get(0).getTitle());
                    mSecondName.setText(navs.get(1).getTitle());
                    mThirdName.setText(navs.get(2).getTitle());
                    mForthName.setText(navs.get(3).getTitle());



                }

                @Override
                public void onFailure(Call<LunBoListBean> call, Throwable t) {

                }
            });
        } else {
            return;
        }


    }


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

    @Override
    public void onRefresh() {
        initData("slider.cate");
        initData("card.list");
        mHandler.removeMessages(START);
        position=0;
        mSwipe.setRefreshing(false);

    }

    private Intent intent;


    @Override
    public void onClick(View v) {
        intent = new Intent(getActivity(), AllVideoActivity.class);
        Log.e(TAG, "onClick: 进入点击方法" );
        switch (v.getId()) {

            case R.id.frag_game_iv_first_icon:
            case R.id.frag_game_tv_first_name:
                if (gameName.size()==4){
                    intent.putExtra("gameName",gameName.get(0));
                    intent.putExtra("cname",mFirstName.getText().toString());
                    startActivity(intent);
                }

                break;
            case R.id.frag_game_iv_second_icon:
            case R.id.frag_game_tv_second_name:
                if (gameName.size()==4) {
                    intent.putExtra("gameName", gameName.get(1));
                    intent.putExtra("cname", mSecondName.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.frag_game_iv_third_icon:
            case R.id.frag_game_tv_third_name:
                if (gameName.size()==4) {
                    intent.putExtra("gameName", gameName.get(2));
                    intent.putExtra("cname", mThirdName.getText().toString());
                    startActivity(intent);
                }
                break;
            case R.id.frag_game_iv_forth_icon:
            case R.id.frag_game_tv_forth_name:
                if (gameName.size()==4) {
                    intent.putExtra("gameName", gameName.get(3));
                    intent.putExtra("cname", mForthName.getText().toString());
                    startActivity(intent);
                }
                break;

        }
    }

}
