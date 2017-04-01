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
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.fenlei.JuTiFenLeiBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/27.
 */

public class FenLeiGridAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    private List<JuTiFenLeiBean> data;

    public FenLeiGridAdapter(Context context, List<JuTiFenLeiBean> data) {

        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
        }

        inflater= ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    public void updateRes(List<JuTiFenLeiBean> data){
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
    public JuTiFenLeiBean getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FenLeiGridAdapter.ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.frag_game_fenlei_item_grid,parent,false);
            holder = new FenLeiGridAdapter.ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = ((FenLeiGridAdapter.ViewHolder) convertView.getTag());
        }
        holder.mText.setText(getItem(position).getCname());

        ImageLoader.getInstance().displayImage(getItem(position).getImg(),holder.mImage);
        return convertView;
    }
    public static class ViewHolder{
        @BindView(R.id.fenlei_item_grid_item_img)
        ImageView mImage;

        @BindView(R.id.fenlei_item_grid_item_tv)
        TextView mText;
        public ViewHolder(View itemView){
            ButterKnife.bind(this,itemView);
        }

    }
}
