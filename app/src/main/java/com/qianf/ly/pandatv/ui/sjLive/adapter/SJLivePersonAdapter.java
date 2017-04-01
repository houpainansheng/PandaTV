package com.qianf.ly.pandatv.ui.sjLive.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SJLivePersonAdapter extends RecyclerView.Adapter<SJLivePersonAdapter.ViewHodle> {

    private List<Person> datas;
    private LayoutInflater inflater;
    private DisplayImageOptions displayImageOptions;

    public SJLivePersonAdapter(List<Person> datas, Context context) {
        if (datas != null) {

            this.datas = datas;
        } else
            this.datas = new ArrayList<>();
        inflater = LayoutInflater.from(context);

        // ImageLoader的配置文件
        this.displayImageOptions = new DisplayImageOptions.Builder()
                // 配置加载过程中的图片
                .showImageOnLoading(R.mipmap.ic_launcher)
                // 加载错误的图片
                .showImageOnFail(R.mipmap.ic_launcher)
                // 加载地址为null的图片
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                // 打开memory缓存
                .cacheInMemory(true)
                // 打开disk 缓存
                .cacheOnDisk(true)
                // 修改图片加载质量
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new CircleBitmapDisplayer())
                .build();
    }

    @Override
    public ViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_sjlive_item_person, parent, false);

        return new ViewHodle(view);
    }

    @Override
    public void onBindViewHolder(ViewHodle holder, int position) {

        ImageLoader.getInstance()
                .displayImage(datas.get(position).getImage(),holder.imageView,displayImageOptions);
    }

    @Override
    public int getItemCount() {
        return datas!=null?datas.size():0;
    }

    public static class ViewHodle extends RecyclerView.ViewHolder{

        private ImageView imageView;
        public ViewHodle(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.sjlive_act_item_person_iv);
        }
    }
}
