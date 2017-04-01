package com.qianf.ly.pandatv.ui.splive;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.Gift;
import com.qianf.ly.pandatv.bean.ItemGift;
import com.qianf.ly.pandatv.decideView.LYFramLayout;
import com.qianf.ly.pandatv.decideView.LYRecycleView;
import com.qianf.ly.pandatv.ui.sjLive.adapter.SJLiveGiftAdapter;
import com.qianf.ly.pandatv.ui.sjLive.adapter.SJLiveItemGiftAdapter;
import com.qianf.ly.pandatv.ui.sjLive.bridge.OnClickSJLiveItemGiftBridge;
import com.qianf.ly.pandatv.ui.splive.contrat.SPLiveContrat;
import com.qianf.ly.pandatv.ui.splive.fragment.ChatFragment;
import com.qianf.ly.pandatv.ui.splive.fragment.PaiHangFragment;
import com.qianf.ly.pandatv.ui.splive.fragment.ZhuBoFragment;
import com.qianf.ly.pandatv.ui.splive.model.SPLiveModel;
import com.qianf.ly.pandatv.ui.splive.persenter.SPLivePersenter;
import com.qianf.ly.pandatv.utils.AudioController;
import com.qianf.ly.pandatv.utils.LYBarrageUtil;
import com.qianf.ly.pandatv.utils.LightnessController;
import com.rock.mvplibrary.adapters.BaisCommonFragmentPagerAdapter;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

public class SPLiveActivity extends BaseActivity<SPLivePersenter, SPLiveModel> implements ViewPager.OnPageChangeListener, GestureDetector.OnGestureListener, SPLiveContrat.SPLiveView, OnClickSJLiveItemGiftBridge {

    @BindView(R.id.splive_act_flayout)
    LYFramLayout splive_act_flayout;
    @BindView(R.id.splive_act_incl)
    View splive_act_incl;
    @BindView(R.id.vedio_shuru)
    EditText vedio_shuru;

    @BindView(R.id.splive_act_rv_gift)
    LYRecycleView splive_act_rv_gift;


    @BindView(R.id.splive_act_vv)
    VideoView splive_act_vv;

    @BindView(R.id.splive_act_vp)
    ViewPager splive_act_vp;
    @BindView(R.id.splive_act_iv_dibu)
    ImageView splive_act_iv_dibu;
    @BindView(R.id.vedio_llayout)
    LinearLayout vedio_llayout;

    @BindView(R.id.splive_act_rg)
    RadioGroup splive_act_rg;

    @BindView(R.id.vedio_player)
    CheckBox vedio_player;
    @BindView(R.id.vedio_qiehuang)
    CheckBox vedio_qiehuang;
    @BindView(R.id.vedio_danmu)
    CheckBox vedio_danmu;


    //    礼物
    @BindView(R.id.sp_inclu_gift)
    View sp_inclu_gift;
    @BindView(R.id.sjlive_act_rv_gift_message)
    RecyclerView sjlive_act_rv_gift_message;

    private boolean isLandScape = false;
    private int mVideoHeight;
    private LYBarrageUtil lyBarrageUtil;


    //    手势探测器
    private GestureDetector mGestureDetector;
    private List<Gift> giftDatas;
    private List<ItemGift> itemGiftDatas;

    private SJLiveGiftAdapter giftAdapter;
    private SJLiveItemGiftAdapter itemGiftAdapter;


    private final int CLOSEINCLUDE = 1;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case CLOSEINCLUDE:

                    splive_act_incl.setVisibility(View.GONE);
                    break;
                case 3:
                    lyBarrageUtil.getAnimator("@@@@@@@@@", 0);
                    handler.sendEmptyMessageDelayed(3, 1000);
                    break;

            }
            return false;
        }
    });


    @Override
    public int getLayoutId() {
        return R.layout.activity_splive;
    }

    @Override
    public void initPresenter() {

        mModel = new SPLiveModel(this);
        mPresenter.setVM(this, mModel);

    }

    @Override
    public void initView() {


        splive_act_vp.setOnPageChangeListener(this);
        List<Fragment> datas = new ArrayList<>();
        datas.add(new ChatFragment());
        datas.add(new ZhuBoFragment());
        datas.add(new PaiHangFragment());
        splive_act_vp.setAdapter(new BaisCommonFragmentPagerAdapter(getSupportFragmentManager(), datas));

        lyBarrageUtil = new LYBarrageUtil(this, R.id.activity_splive);
        mGestureDetector = splive_act_flayout.getmGestureDetector(this, this);


        //直播部分
        splive_act_vv.setVideoURI(Uri.parse("http://7rflo2.com2.z0.glb.qiniucdn.com/5714b0b53c958.mp4"));


        splive_act_vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                int width ;
                int height;
                if (isLandScape) {
                    height = getResources().getDisplayMetrics().widthPixels;
                    width=getResources().getDisplayMetrics().heightPixels;
                } else {
                    width = getResources().getDisplayMetrics().widthPixels;
                    height = splive_act_flayout.getLayoutParams().height;
                }
                float aspectRatio = (float) width / height;
                splive_act_vv.setVideoLayout(VideoView.VIDEO_LAYOUT_SCALE, aspectRatio);


            }
        });


        vedio_shuru.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handler.removeMessages(CLOSEINCLUDE);
                return false;
            }
        });


        giftDatas = new ArrayList<>();
        itemGiftDatas = new ArrayList<>();
        giftAdapter = new SJLiveGiftAdapter(giftDatas, this);
        itemGiftAdapter = new SJLiveItemGiftAdapter(itemGiftDatas, this, this);


        splive_act_rv_gift.setAdapter(giftAdapter);
        splive_act_rv_gift.setLayoutManager(new LinearLayoutManager(this));


        sjlive_act_rv_gift_message.setAdapter(itemGiftAdapter);
        sjlive_act_rv_gift_message.setLayoutManager(new GridLayoutManager(this, 3));


        mPresenter.initItemData();


    }


    //-------------------  屏幕旋转时必走的回调  ------------------
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // 屏幕进入横屏状态
            lyBarrageUtil.start();
            isLandScape = true;
            vedio_llayout.setVisibility(View.VISIBLE);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            // 屏幕恢复纵屏状态
            lyBarrageUtil.stop();
            vedio_llayout.setVisibility(View.GONE);
            isLandScape = false;
        }
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        int width = splive_act_iv_dibu.getWidth();
        splive_act_iv_dibu.setTranslationX(width * (position + positionOffset));

    }

    @Override
    public void onPageSelected(int position) {
        splive_act_rg.check(splive_act_rg.getChildAt(position).getId());

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.splive_act_rb_1:
                splive_act_vp.setCurrentItem(0);
                break;
            case R.id.splive_act_rb_2:
                splive_act_vp.setCurrentItem(1);
                break;
            case R.id.splive_act_rb_3:
                splive_act_vp.setCurrentItem(2);
                break;
            case R.id.vedio_back:
                if (isLandScape) {
                    // 变回纵屏
                    vedio_qiehuang.setChecked(false);
                    hengShuQieHuang();
                    break;
                }
                finish();
                break;
            case R.id.vedio_enter:

                lyBarrageUtil.getAnimator(vedio_shuru.getText().toString(), 3);
                vedio_shuru.setText("");
                handler.sendEmptyMessageDelayed(CLOSEINCLUDE, 5000);
                break;


            case R.id.vedio_danmu:
                closeDanmu();
                break;
            case R.id.vedio_player:
                player();
                break;
            case R.id.vedio_qiehuang:
                hengShuQieHuang();
                break;
            case R.id.vedio_setting:
                Toast.makeText(this, "你点了 设置", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sjlive_act_v_gift:
                sp_inclu_gift.setVisibility(View.GONE);
                break;


        }


    }

    public void setVisiItemGift() {
        sp_inclu_gift.setVisibility(View.VISIBLE);

    }


    private void closeDanmu() {

        if (!vedio_danmu.isChecked()) {
            lyBarrageUtil.start();
        } else {
            lyBarrageUtil.stop();
        }


    }

    private void player() {
        if (vedio_player.isChecked()) {
            splive_act_vv.start();
        } else {
            splive_act_vv.pause();

        }


    }


    private void hengShuQieHuang() {
        if (vedio_qiehuang.isChecked()) {
            // 切换全屏播放

            // 添加全屏标记
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            // 请求设置为横屏  port 是纵屏  land 横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            // 记录原View的高度
            mVideoHeight = splive_act_flayout.getLayoutParams().height;
            // 设置高度
            splive_act_flayout.getLayoutParams().height = getResources().getDisplayMetrics().widthPixels;
//                    mVideoContainer.getLayoutParams().height = FrameLayout.LayoutParams.MATCH_PARENT;


            splive_act_rv_gift.setVisibility(View.GONE);
            handler.sendEmptyMessageDelayed(3, 1000);


        } else {
            // 切换为默认播放形式
            // 清除全屏标记
            splive_act_rv_gift.setVisibility(View.VISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            // 请求设置为纵屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            splive_act_flayout.getLayoutParams().height = mVideoHeight;

        }
        ViewGroup.LayoutParams layoutParams = splive_act_vv.getLayoutParams();
        layoutParams.height = splive_act_flayout.getLayoutParams().height;
        layoutParams.width = splive_act_flayout.getLayoutParams().width;

    }

    @Override
    public void onBackPressed() {
        if (isLandScape) {
            // 变回纵屏
            vedio_qiehuang.setChecked(false);
            hengShuQieHuang();
        } else {
            // 纵屏直接响应返回
            super.onBackPressed();
        }
    }


    private int downX, downY;

    //    手势播放器监听
    @Override
    public boolean onDown(MotionEvent e) {


        splive_act_incl.setVisibility(View.VISIBLE);
        handler.removeMessages(CLOSEINCLUDE);
        handler.sendEmptyMessageDelayed(CLOSEINCLUDE, 2000);

        downX = (int) e.getX();
        downY = (int) e.getY();


        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {


        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {


        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        if (e1.getX() < widthPixels / 2 && e2.getX() < widthPixels / 2) {
            if (distanceY > 0)
                LightnessController.turnUp(this, distanceY, heightPixels);
            else
                LightnessController.turnDown(this, distanceY, heightPixels);
        }


        if (e1.getX() > widthPixels / 2 && e2.getX() > widthPixels / 2) {


            if (distanceY > 0)
                AudioController.turnUp(this, distanceY, heightPixels);
            else
                AudioController.turnDown(this, distanceY, heightPixels);
        }


        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


        return false;
    }


//    view 回调

    @Override
    public void returnitemGiftData(List<ItemGift> itemGifts) {
        itemGiftDatas.addAll(itemGifts);
        itemGiftAdapter.notifyDataSetChanged();
    }

    @Override
    public void returngiftData(List<Gift> gifts) {

        Gift gift = null;
        a:
        for (int i = 0; i < gifts.size(); i++) {
            for (int j = 0; j < (giftDatas.size() > 3 ? 3 : giftDatas.size()); j++) {
                if (giftDatas.get(j).equals(gifts.get(i))) {

                    giftDatas.get(j).setNum(giftDatas.get(j).getNum() + gifts.get(i).getNum());
                    gift = giftDatas.get(j);

                    giftDatas.set(j, giftDatas.get(0));
                    giftDatas.set(0, gift);
                    giftAdapter.notifyItemChanged(0);
                    giftAdapter.notifyItemChanged(j);
                    continue a;
                }
            }
            giftDatas.add(0, gifts.get(i));
            giftAdapter.notifyItemInserted(0);
            for (int j = 3; j < giftDatas.size(); j++) {
                giftDatas.remove(j);
                giftAdapter.notifyItemRemoved(j);
            }
        }
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


    //礼物回调
    @Override
    public void onClickItemGift(ItemGift itemGift) {
        List<Gift> gifts = new ArrayList<>();
        gifts.add(new Gift(itemGift, "我", 1));
        returngiftData(gifts);
    }
}
