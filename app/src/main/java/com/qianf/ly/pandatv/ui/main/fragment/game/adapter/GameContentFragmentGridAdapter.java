package com.qianf.ly.pandatv.ui.main.fragment.game.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.other.RoomInfoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/27.
 */

public class GameContentFragmentGridAdapter extends BaseAdapter {
    private List<RoomInfoBean> data;
    private LayoutInflater inflater;

    public GameContentFragmentGridAdapter(Context context, List<RoomInfoBean> data) {
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }
        inflater= LayoutInflater.from(context);

    }
    public void updateRes(List<RoomInfoBean> data){
        if (data != null) {
            this.data.clear();
            this.data.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return data!=null?data.size():0;
    }

    @Override
    public RoomInfoBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.frag_tuijian_item_gridview,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTitle.setText(getItem(position).getTitle());
        holder.mNickName.setText(getItem(position).getUserinfo().getNickName());

        int num = Integer.parseInt(getItem(position).getPerson_num());
        if (num/10000!=0) {
            holder.mPersonNum.setText(((float) (num / 10000))+"万");
        }else {
            holder.mPersonNum.setText(num+"");
        }

        ImageLoader.getInstance().displayImage(getItem(position).getImg(),holder.mImage);

        return convertView;
    }

    public static class ViewHolder{
        @BindView(R.id.frag_tuijian_item_gridView_img)
        ImageView mImage;
        @BindView(R.id.frag_tuijian_item_gridView_title)
        TextView mTitle;
        @BindView(R.id.frag_tuijian_item_gridView_nickName)
        TextView mNickName;
        @BindView(R.id.frag_tuijian_item_gridView_persn_num)
        TextView mPersonNum;
        public ViewHolder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
}
