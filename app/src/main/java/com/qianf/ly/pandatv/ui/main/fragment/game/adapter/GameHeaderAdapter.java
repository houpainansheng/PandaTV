package com.qianf.ly.pandatv.ui.main.fragment.game.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.viewpager.ZhiBoBean;
import com.qianf.ly.pandatv.ui.splive.SPLiveActivity;

import java.util.ArrayList;
import java.util.List;


/**
 *
 */

public class GameHeaderAdapter extends PagerAdapter implements View.OnClickListener {

    private List<ZhiBoBean> data;
    private Context context;

    public GameHeaderAdapter(List<ZhiBoBean> data, Context context) {
        if (data == null) {
            this.data = new ArrayList<>();
        }else {
            this.data.add(data.get(data.size()-1));
            this.data.addAll(data);
            this.data.add(data.get(0));
        }


        this.context = context;
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
    public void addData(List<ZhiBoBean> data){
        if (data!=null) {
            this.data.clear();
            this.data.add(data.get(data.size() - 1));
            this.data.addAll(data);
            this.data.add(data.get(0));

            notifyDataSetChanged();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.mipmap.ic_launcher);
        ImageLoader.getInstance().displayImage(data.get(position).getImg(),imageView);
        container.addView(imageView);
        imageView.setOnClickListener(this);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, SPLiveActivity.class);
        context.startActivity(intent);
    }
}
