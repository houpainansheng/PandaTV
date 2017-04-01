package com.qianf.ly.pandatv.ui.main.fragment.my.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.qianf.ly.pandatv.R;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */

public class MyFragmentAdapter extends BaisBaseAdapter<String> {
    private List<String> data;

    private List<Integer> resid;

    public MyFragmentAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {
        holder.setText(R.id.frag_my_item_tv,getItem(position));
        initResid();
        ImageView imageView = (ImageView) holder.findView(R.id.frag_my_item_iv_icon);
        imageView.setImageResource(resid.get(position));
    }

    private void initResid() {
        resid = new ArrayList<>();
        resid.add(R.mipmap.ic_profile_apply_host);
        resid.add(R.mipmap.ic_profile_follow);
        resid.add(R.mipmap.ic_profile_xingyan_follow);
        resid.add(R.mipmap.ic_profile_history);
        resid.add(R.mipmap.chatmessage_xinxi_icon_lishi);
        resid.add(R.mipmap.ic_profile_activity);
        resid.add(R.mipmap.ic_profile_remind);
        resid.add(R.mipmap.ic_profile_consume);
        resid.add(R.mipmap.ic_profile_feedback);

    }
}
