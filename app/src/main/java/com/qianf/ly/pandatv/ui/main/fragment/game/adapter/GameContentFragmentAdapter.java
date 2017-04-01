package com.qianf.ly.pandatv.ui.main.fragment.game.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.main.activity.AllVideoActivity;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.other.ZhuanQuBean;
import com.qianf.ly.pandatv.ui.splive.SPLiveActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */

public class GameContentFragmentAdapter extends BaseAdapter implements View.OnClickListener, AdapterView.OnItemClickListener {
    private List<ZhuanQuBean> data;
    private LayoutInflater inflater;
    private Context context;

    public GameContentFragmentAdapter(Context context, List<ZhuanQuBean> data) {
        if (data != null) {
            this.data = data;
        }else {
            this.data = new ArrayList<>();
            this.context = context;
        }

        inflater= ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));
    }

    public void updateRes(List<ZhuanQuBean> data){
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
    public ZhuanQuBean getItem(int position) {
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
            convertView = inflater.inflate(R.layout.frag_tuijian_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
           holder= (ViewHolder) convertView.getTag();
        }

        holder.mTitle.setText(getItem(position).getCard_title());

        if (getItem(position).getTotal()!=null) {
            holder.mButton.setVisibility(View.VISIBLE);
            holder.mButton.setText("全部"+getItem(position).getTotal()+"个直播");
        }else {
            holder.mButton.setVisibility(View.GONE);
        }
        holder.mGrid.setAdapter(new GameContentFragmentGridAdapter(context,getItem(position).getItems()));
        holder.mButton.setTag(position);
        holder.mButton.setOnClickListener(this);
        holder.mGrid.setOnItemClickListener(this);

        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.frag_tuijian_item_more:
                int position = ((int) v.getTag());
                Intent intent = new Intent(context, AllVideoActivity.class);
                intent.putExtra("gameName",getItem(position).getItems().get(0).getClassification().getEname());
                intent.putExtra("cname",getItem(position).getItems().get(0).getClassification().getCname());

                context.startActivity(intent);

                break;
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(context, SPLiveActivity.class);
        context.startActivity(intent);
    }

    public static class ViewHolder{
        @BindView(R.id.frag_tuijian_item_title)
        TextView mTitle;
        @BindView(R.id.frag_tuijian_item_more)
        Button mButton;
        @BindView(R.id.frag_tuijian_gridView)
        GridView mGrid;



        public ViewHolder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }

}
