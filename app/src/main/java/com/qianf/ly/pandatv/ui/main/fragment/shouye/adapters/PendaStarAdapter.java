package com.qianf.ly.pandatv.ui.main.fragment.shouye.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.PendaStarBean;
import com.qianf.ly.pandatv.ui.sjLive.SJLiveActivity;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/28.
 */

public class PendaStarAdapter extends BaisBaseAdapter<PendaStarBean> implements View.OnClickListener {

    private Context context ;

    public PendaStarAdapter(Context context, List<PendaStarBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context = context ;
    }

    @Override
    protected void bindData(ViewHolder holder, PendaStarBean item, int position) {
        ImageView view = (ImageView) holder.findView(R.id.penda_star_photo);
        holder.itemView.setOnClickListener(this);
        ImageLoader.getInstance().displayImage(item.getS_photo(), view);

        //  holder.setText(R.id.penda_star_level,item.getLevel());
        holder.setText(R.id.penda_star_name, item.getName());
        holder.setText(R.id.penda_star_nickName, item.getNickName());
        holder.setText(R.id.penda_star_personnum, item.getPersonnum());


    }

    @Override
    public void onClick(View v) {
        context.startActivity(new Intent(context, SJLiveActivity.class));
    }
}
