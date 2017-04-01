package com.qianf.ly.pandatv.ui.sjLive.adapter;

import android.content.Context;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.SjMsg;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SJLiveMsgAdapter extends BaisBaseAdapter<SjMsg> {
    public SJLiveMsgAdapter(Context context, List<SjMsg> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, SjMsg item, int position) {
        holder.setText(R.id.sjlive_act_message_item_tv_name,item.getName()+" : ");
        holder.setText(R.id.sjlive_act_message_item_tv_msg,item.getMsg());
    }
}
