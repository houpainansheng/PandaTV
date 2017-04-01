package com.qianf.ly.pandatv.ui.main.fragment.shouye.adapters;


import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.ShouYeModelBean;
import com.qianf.ly.pandatv.ui.splive.SPLiveActivity;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class TuiJianGridViewAdapter extends BaisBaseAdapter<ShouYeModelBean> implements View.OnClickListener {

 private Context context;
    public TuiJianGridViewAdapter(Context context, List<ShouYeModelBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context = context;
    }

    @Override
    protected void bindData(ViewHolder holder, ShouYeModelBean item, int position) {
//        Logger.e("asdasd");
        //给GridVIew添加布局

        holder.itemView.setOnClickListener(this);

        ImageView img = (ImageView) holder.findView(R.id.frag_tuijian_item_gridView_img);
        ImageLoader.getInstance().displayImage(item.getImg(), img);



        holder.setText(R.id.frag_tuijian_item_gridView_title, item.getTitle());

        holder.setText(R.id.frag_tuijian_item_gridView_nickName, item.getUserinfo().getNickName());


        int num = item.getPerson_num();
        if (num <10000){
            holder.setText(R.id.frag_tuijian_item_gridView_persn_num,String.valueOf(num));

        }else {

//           String.valueOf(num/10000)+"."+String.valueOf((num/1000)%10)+"万"

        holder.setText(R.id.frag_tuijian_item_gridView_persn_num,String.valueOf(num/10000)+"."+String.valueOf((num/1000)%10)+"万");
        }

    }


    @Override
    public void onClick(View v) {
        context.startActivity(new Intent(context,SPLiveActivity.class));

    }
}