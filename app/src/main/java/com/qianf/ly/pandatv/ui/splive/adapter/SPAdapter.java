package com.qianf.ly.pandatv.ui.splive.adapter;

import android.content.Context;

import com.qianf.ly.pandatv.R;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by baisaikele on 2017/3/30.
 */

public class SPAdapter extends BaisBaseAdapter<String> {
    public SPAdapter(Context context, List<String> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, String item, int position) {

        holder.setText(R.id.item_id,item);

    }
}
