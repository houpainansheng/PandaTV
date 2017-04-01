package com.qianf.ly.pandatv.ui.sjLive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.Gift;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SJLiveGiftAdapter extends RecyclerView.Adapter<SJLiveGiftAdapter.ViewHodle> {

    private List<Gift> datas;
    private LayoutInflater inflater;



    public SJLiveGiftAdapter(List<Gift> datas, Context context) {
        if (datas != null) {

            this.datas = datas;
        } else
            this.datas = new ArrayList<>();
        inflater = LayoutInflater.from(context);

    }

    @Override
    public ViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_sjlive_item_gift, parent, false);

        return new ViewHodle(view);
    }

    @Override
    public void onBindViewHolder(ViewHodle holder, int position) {

        holder.setText(R.id.sjlive_act_item_gift_tv_title,datas.get(position).getTitle()+"送 "+datas.get(position).getGift().getName());
        holder.setText(R.id.sjlive_act_item_gift_tv_num,datas.get(position).getNum()+"");
        ImageView imageView = (ImageView) holder.findID(R.id.sjlive_act_item_gift_iv);
        imageView.setImageBitmap(datas.get(position).getGift().getBitmap());
    }

    @Override
    public int getItemCount() {
        return datas!=null?datas.size():0;
    }

    public static class ViewHodle extends RecyclerView.ViewHolder{

        public ViewHodle(View itemView) {
            super(itemView);
        }
        public View findID(int id) {
            View view = itemView.findViewById(id);

            return view;
        }

        public void setText(int id, String text) {
            TextView textView = (TextView) findID(id);

            textView.setText(text);

        }
    }
}
