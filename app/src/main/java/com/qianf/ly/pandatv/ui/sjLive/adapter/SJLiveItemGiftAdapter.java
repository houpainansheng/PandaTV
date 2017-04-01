package com.qianf.ly.pandatv.ui.sjLive.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.ItemGift;
import com.qianf.ly.pandatv.ui.sjLive.bridge.OnClickSJLiveItemGiftBridge;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baisaikele on 2017/3/25.
 */

public class SJLiveItemGiftAdapter extends RecyclerView.Adapter<SJLiveItemGiftAdapter.ViewHodle> implements View.OnClickListener {

    private List<ItemGift> datas;
    private LayoutInflater inflater;
    private OnClickSJLiveItemGiftBridge bridge;

    public SJLiveItemGiftAdapter(List<ItemGift> datas, Context context,OnClickSJLiveItemGiftBridge bridge) {
        if (datas != null) {

            this.datas = datas;
        } else
            this.datas = new ArrayList<>();
        inflater = LayoutInflater.from(context);
        this.bridge=bridge;
    }

    @Override
    public void onClick(View v) {
        int i = (int) v.getTag();
        bridge.onClickItemGift(datas.get(i));


    }

    public static class ViewHodle extends RecyclerView.ViewHolder {

        public ViewHodle(View itemView) {
            super(itemView);
        }


        public View findID(int id) {
            return itemView.findViewById(id);
        }

        public void setText(int id, String text) {
            TextView textView = (TextView) findID(id);
            textView.setText(text);

        }

    }


    @Override
    public ViewHodle onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.activity_sjlive_gift_item, parent, false);


        return new ViewHodle(view);
    }

    @Override
    public void onBindViewHolder(ViewHodle holder, int position) {

        holder.setText(R.id.sjlive_act_gift_item_tv,datas.get(position).getMoney()+" 竹子");
        ImageView imageView = (ImageView) holder.findID(R.id.sjlive_act_gift_item_iv);
        imageView.setTag(position);
        imageView.setOnClickListener(this);
        imageView.setImageBitmap(datas.get(position).getBitmap());

    }


    @Override
    public int getItemCount() {
        return datas!=null?datas.size():0;
    }
}
