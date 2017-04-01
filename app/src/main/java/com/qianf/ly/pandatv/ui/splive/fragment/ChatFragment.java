package com.qianf.ly.pandatv.ui.splive.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.splive.SPLiveActivity;
import com.qianf.ly.pandatv.ui.splive.adapter.SPAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by baisaikele on 2017/3/28.
 */

public class ChatFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.frag_chat_et)
    EditText frag_chat_et;
    @BindView(R.id.frag_chat_iv_shuru)
    ImageView frag_chat_iv_shuru;
    @BindView(R.id.frag_chat_iv_gift)
    ImageView frag_chat_iv_gift;
    @BindView(R.id.frag_chat_iv_baioqing)
    ImageView frag_chat_iv_baioqing;
    @BindView(R.id.frag_chat_lv)
    ListView frag_chat_lv;

    private List<String> data;
    private SPAdapter adapter;


    @Override
    protected int getLayoutId() {
        return R.layout.frag_spl_chat;
    }

    @Override
    public void initView() {

        ButterKnife.bind(getActivity());

        frag_chat_iv_shuru.setOnClickListener(this);
        frag_chat_iv_baioqing.setOnClickListener(this);
        frag_chat_iv_gift.setOnClickListener(this);

        data=new ArrayList<>();
        for (int i = 0; i < 0; i++) {
            data.add("刘洋  说："+"大王要我来巡山咧"+i);
        }
        adapter = new SPAdapter(getContext(),data, R.layout.item);
        frag_chat_lv.setAdapter(adapter);
        frag_chat_lv.setSelection(data.size()-1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frag_chat_iv_baioqing:
                Toast.makeText(getActivity(), "biaoqing", Toast.LENGTH_SHORT).show();
                break;
            case R.id.frag_chat_iv_gift:
                ((SPLiveActivity) getActivity()).setVisiItemGift();
                break;
            case R.id.frag_chat_iv_shuru:
                String string = frag_chat_et.getText().toString();
                data.add("我说  ："+string);
                adapter.notifyDataSetChanged();
                frag_chat_et.setText("");
                frag_chat_lv.setSelection(data.size()-1);
                break;
        }

    }
}
