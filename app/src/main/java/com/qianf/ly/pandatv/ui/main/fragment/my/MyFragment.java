package com.qianf.ly.pandatv.ui.main.fragment.my;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.main.activity.LogInActivity;
import com.qianf.ly.pandatv.ui.main.fragment.my.adapter.MyFragmentAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/3/30.
 */

public class MyFragment extends BaseFragment implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static final String TAG = MyFragment.class.getName();

    @BindView(R.id.frag_my_lv)
    ListView mListView;

    @Override
    protected int getLayoutId() {
        return R.layout.my_fragment;
    }

    @Override
    public void initView() {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.frag_my_header, null, false);
        mListView.addHeaderView(headView);
        mListView.setAdapter(new MyFragmentAdapter(getActivity(),getTexts(),R.layout.frag_my_item));
        mListView.setOnItemClickListener(this);
        headView.setOnClickListener(this);
    }

    private List<String> getTexts() {
        List<String> texts = new ArrayList<>();
        texts.add("我要当主播");
        texts.add("我的订阅");
        texts.add("我的星颜");
        texts.add("观看历史");
        texts.add("私信");
        texts.add("活动中心");
        texts.add("开播提醒");
        texts.add("消费记录");
        texts.add("设置");
        return texts;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position<9) {
            Intent intent = new Intent(getActivity(), LogInActivity.class);

            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), LogInActivity.class);

        startActivity(intent);
    }
}
