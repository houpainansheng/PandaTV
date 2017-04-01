package com.qianf.ly.pandatv.ui.main.adapters;


import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.AllVideoModelBean;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class AllVideoAdapter extends BaisBaseAdapter<AllVideoModelBean>  {

private Context context;
    public AllVideoAdapter(Context context, List<AllVideoModelBean> data, int layoutResId) {
        super(context, data, layoutResId);
        this.context = context;
    }

    @Override
    protected void bindData(ViewHolder holder, AllVideoModelBean item, int position) {


        ImageView img = (ImageView) holder.findView(R.id.frag_tuijian_item_gridView_img);
        ImageLoader.getInstance().displayImage(item.getPictures().getImg(), img);

        //给图片设置点击监听

        holder.setText(R.id.frag_tuijian_item_gridView_title, item.getName());

        holder.setText(R.id.frag_tuijian_item_gridView_nickName, item.getUserinfo().getNickName());


        int num = item.getPerson_num();

        if (num <10000){
            holder.setText(R.id.frag_tuijian_item_gridView_persn_num,String.valueOf(num));

        }else {

//           String.valueOf(num/10000)+"."+String.valueOf((num/1000)%10)+"万"

            holder.setText(R.id.frag_tuijian_item_gridView_persn_num,String.valueOf(num/10000)+"."+String.valueOf((num/1000)%10)+"万");


        }

    }


}
