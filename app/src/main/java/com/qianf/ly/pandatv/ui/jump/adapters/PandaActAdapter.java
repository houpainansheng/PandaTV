package com.qianf.ly.pandatv.ui.jump.adapters;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.PandaStarActivityItem;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/31.
 */

public class PandaActAdapter extends BaisBaseAdapter<PandaStarActivityItem> {

    public PandaActAdapter(Context context, List<PandaStarActivityItem> data, int layoutResId) {
        super(context, data, layoutResId);
    }

    @Override
    protected void bindData(ViewHolder holder, PandaStarActivityItem item, int position) {

        ImageView imageView = (ImageView) holder.findView(R.id.penda_star_photo);

        ImageLoader.getInstance().displayImage(item.getS_photo(),imageView);

         holder.setText(R.id.penda_star_nickName,item.getNickName());

        holder.setText(R.id.penda_star_personnum,item.getPersonnum());

//        holder.setText(R.id.penda_star_level,item.getLevel());

        holder.setText(R.id.penda_star_name,item.getName());

    }
}
