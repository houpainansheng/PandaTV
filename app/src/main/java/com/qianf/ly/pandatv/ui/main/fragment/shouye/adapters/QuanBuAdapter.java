package com.qianf.ly.pandatv.ui.main.fragment.shouye.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.QuanBuFragBean;
import com.qianf.ly.pandatv.ui.splive.SPLiveActivity;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/30.
 */

public class QuanBuAdapter extends BaisBaseAdapter<QuanBuFragBean> implements View.OnClickListener {


    private Context context;

    public QuanBuAdapter(Context context, List<QuanBuFragBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context=context;
    }

    @Override
    protected void bindData(ViewHolder holder, QuanBuFragBean item, int position) {

        holder.itemView.setOnClickListener(this);
        ImageView mImage = (ImageView) holder.findView(R.id.frag_tuijian_item_gridView_img);
        ImageLoader.getInstance().displayImage(item.getPictures().getImg(),mImage);

         holder.setText(R.id.frag_tuijian_item_gridView_title,item.getName());
        Log.e("aa", "bindData: "+item.getName() );
         holder.setText(R.id.frag_tuijian_item_gridView_nickName,item.getUserinfo().getNickName());

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
