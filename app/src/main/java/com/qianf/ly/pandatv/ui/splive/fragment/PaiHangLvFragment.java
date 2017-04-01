package com.qianf.ly.pandatv.ui.splive.fragment;

import android.widget.ListView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.splive.adapter.SPAdapter;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by baisaikele on 2017/3/30.
 */

public class PaiHangLvFragment extends BaseFragment {
    @BindView(R.id.lv)
    ListView lv;
    @Override
    protected int getLayoutId() {
        return R.layout.frag_paih_lv;
    }

    @Override
    public void initView() {

        List<String> data=new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            data.add("刘洋"+i);
        }

        lv.setAdapter(new SPAdapter(getContext(),data, R.layout.item));

    }
}
