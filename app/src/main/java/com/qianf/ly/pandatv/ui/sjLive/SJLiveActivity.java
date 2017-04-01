package com.qianf.ly.pandatv.ui.sjLive;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.Gift;
import com.qianf.ly.pandatv.bean.ItemGift;
import com.qianf.ly.pandatv.bean.Person;
import com.qianf.ly.pandatv.bean.SjMsg;
import com.qianf.ly.pandatv.decideView.LYRecycleView;
import com.qianf.ly.pandatv.ui.sjLive.adapter.SJLiveGiftAdapter;
import com.qianf.ly.pandatv.ui.sjLive.adapter.SJLiveItemGiftAdapter;
import com.qianf.ly.pandatv.ui.sjLive.adapter.SJLiveMsgAdapter;
import com.qianf.ly.pandatv.ui.sjLive.adapter.SJLivePersonAdapter;
import com.qianf.ly.pandatv.ui.sjLive.animator.HeartLayout;
import com.qianf.ly.pandatv.ui.sjLive.bridge.OnClickSJLiveItemGiftBridge;
import com.qianf.ly.pandatv.ui.sjLive.contract.SJLiveContract;
import com.qianf.ly.pandatv.ui.sjLive.model.SJLiveModel;
import com.qianf.ly.pandatv.ui.sjLive.persenter.SJLivePersenter;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.vov.vitamio.widget.VideoView;

public class SJLiveActivity extends BaseActivity<SJLivePersenter,SJLiveModel> implements SJLiveContract.SJLiveView,OnClickSJLiveItemGiftBridge, CompoundButton.OnCheckedChangeListener {


    private static final String TAG = SJLiveActivity.class.getSimpleName();

//    主界面
    @BindView(R.id.sjlive_act_heart_layout)
    HeartLayout heartLayout;
    @BindView(R.id.sjlive_act_vv_)
    VideoView sjlive_act_vv_;

    @BindView(R.id.sjlive_act_iv_zhubotouxiang)
    ImageView sjlive_act_iv_zhubotouxiang;

//
    @BindView(R.id.sjlive_act_cb_guangzhu)
    CheckBox sjlive_act_cb_guangzhu;
    @BindView(R.id.sjlive_act_tv_zhuboname)
    TextView sjlive_act_tv_zhuboname;
    @BindView(R.id.sjlive_act_tv_zhubonum)
    TextView sjlive_act_tv_zhubonum;

//        主界面三大滑动布局
    @BindView(R.id.sjlive_act_lv_chat)
    ListView sjlive_act_lv_chat;
    @BindView(R.id.sjlive_act_rv_gift)
    LYRecycleView sjlive_act_rv_gift;
    @BindView(R.id.sjlive_act_rv_person)
    RecyclerView sjlive_act_rv_person;

//    消息
    @BindView(R.id.sjlive_act_incl_message)
    View sjlive_act_incl_message;
    @BindView(R.id.sjlive_act_et_message)
    EditText sjlive_act_et_message;


//    礼物
    @BindView(R.id.sjlive_act_incl_gift)
    View sjlive_act_incl_gift;
    @BindView(R.id.sjlive_act_rv_gift_message)
    RecyclerView sjlive_act_rv_gift_message;



    private List<Gift> giftDatas;
    private List<ItemGift> itemGiftDatas;
    private List<Person>   perDatas;
    private List<SjMsg>    msgDatas;
    private SJLiveGiftAdapter giftAdapter;
    private SJLiveItemGiftAdapter itemGiftAdapter;
    private SJLivePersonAdapter perAdapter;
    private SJLiveMsgAdapter msgAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_sjlive;
    }

    @Override
    public void initPresenter() {

        mModel=new SJLiveModel(this);
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initView() {
        giftDatas=new ArrayList<>();
        itemGiftDatas=new ArrayList<>();
        perDatas=new ArrayList<>();
        msgDatas=new ArrayList<>();


        giftAdapter = new SJLiveGiftAdapter(giftDatas,this);
        itemGiftAdapter = new SJLiveItemGiftAdapter(itemGiftDatas,this,this);
        perAdapter = new SJLivePersonAdapter(perDatas,this);
        sjlive_act_rv_person.setAdapter(perAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        sjlive_act_rv_person.setLayoutManager(layoutManager);

        sjlive_act_rv_gift_message.setAdapter(itemGiftAdapter);
        sjlive_act_rv_gift_message.setLayoutManager(new GridLayoutManager(this,3));

        sjlive_act_rv_gift.setAdapter(giftAdapter);
        sjlive_act_rv_gift.setLayoutManager(new LinearLayoutManager(this));


        msgAdapter = new SJLiveMsgAdapter(this,msgDatas, R.layout.activity_sjlive_item_message);
        sjlive_act_lv_chat.setAdapter(msgAdapter);

        sjlive_act_cb_guangzhu.setOnCheckedChangeListener(this);



        mPresenter.initItemData();
        float heightPixels = getResources().getDisplayMetrics().heightPixels;
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        float aspectRatio = heightPixels / widthPixels;

        sjlive_act_vv_.setVideoLayout(VideoView.VIDEO_LAYOUT_ZOOM, aspectRatio);
        sjlive_act_vv_.setVideoURI(Uri.parse("http://7rflo2.com2.z0.glb.qiniucdn.com/5714b0b53c958.mp4"));





    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sjlive_act_iv_gift:
                Log.e(TAG, "onClick:   " + "礼物");
                sjlive_act_incl_gift.setVisibility(View.VISIBLE);
                break;

            case R.id.sjlive_act_iv_like:
                Log.e(TAG, "onClick:   " + "点赞");
                heartLayout.addFavor();
                break;

            case R.id.sjlive_act_iv_message:
                Log.e(TAG, "onClick:   " + "消息");
                sjlive_act_incl_message.setVisibility(View.VISIBLE);
                break;

            case R.id.sjlive_act_iv_share:
                Log.e(TAG, "onClick:   " + "分享");
                break;



            case R.id.sjlive_act_rl:
                Log.e(TAG, "onClick:   " + "查看主播信息");
                break;

            case R.id.sjlive_act_iv_back:
                Log.e(TAG, "onClick:   " + "回退");
                finish();
                break;

            case R.id.sjlive_act_iv_enter:
                setMessage();
                Log.e(TAG, "onClick:   " + "信息");
                break;

            case R.id.sjlive_act_v_menssage:
                hideMenssage(view);
                break;
            case R.id.sjlive_act_v_gift:
                sjlive_act_incl_gift.setVisibility(View.GONE);
                break;

        }


    }

    private void hideMenssage(View view) {

        sjlive_act_incl_message.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);//强制隐藏键盘
    }

    private void setMessage() {
        String text = sjlive_act_et_message.getText().toString();
        sjlive_act_et_message.setText("");
        hideMenssage(sjlive_act_et_message);
        msgAdapter.addResOne(new SjMsg("我",text));
        sjlive_act_lv_chat.setSelection(sjlive_act_lv_chat.getBottom());

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
    public void returnitemGiftData(List<ItemGift> itemGifts) {

        for (int i = 0; i < itemGiftDatas.size(); i++) {
            itemGiftDatas.get(i).getBitmap().recycle();

        }

        itemGiftDatas.clear();
        itemGiftDatas.addAll(itemGifts);
        itemGiftAdapter.notifyDataSetChanged();



    }

    @Override
    public void returngiftData(List<Gift> gifts) {

        Gift gift=null;
        a:  for (int i = 0; i < gifts.size(); i++) {
             for (int j = 0; j < (giftDatas.size()>3?3:giftDatas.size()); j++) {
                if (giftDatas.get(j).equals(gifts.get(i))) {

                    giftDatas.get(j).setNum(giftDatas.get(j).getNum()+gifts.get(i).getNum());
                    gift=giftDatas.get(j);

                    giftDatas.set(j,giftDatas.get(0));
                    giftDatas.set(0,gift);
                    giftAdapter.notifyItemChanged(0);
                    giftAdapter.notifyItemChanged(j);
                    continue a;
                }
            }
            giftDatas.add(0,gifts.get(i));
            giftAdapter.notifyItemInserted(0);
            for (int j = 3; j < giftDatas.size(); j++) {
                giftDatas.remove(j);
                giftAdapter.notifyItemRemoved(j);
            }
        }




    }

    @Override
    public void returnMsgData(List<SjMsg> sjMsgs) {
        msgAdapter.updateRes(sjMsgs);

    }

    @Override
    public void returnPerData(List<Person> persons) {

        perDatas.addAll(persons);
        perAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClickItemGift(ItemGift itemGift) {
        List<Gift> gifts=new ArrayList<>();
        gifts.add(new Gift(itemGift,"我",1));
        returngiftData(gifts);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if (isChecked) {
            sjlive_act_cb_guangzhu.setText("取关");
        }else{
            sjlive_act_cb_guangzhu.setText("关注");

        }
    }
}
