package com.qianf.ly.pandatv.ui.main.fragment.game.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.R2;
import com.qianf.ly.pandatv.ui.main.activity.AllVideoActivity;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.fenlei.DaGaiFenLeiBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 *
 */

public class FenleiAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private List<DaGaiFenLeiBean> title;

    private LayoutInflater inflater;

    private Context context;


    public FenleiAdapter(Context context, List<DaGaiFenLeiBean> title) {

        if (title != null) {
            this.title = title;
        }else {
            this.title = new ArrayList<>();
        }

        inflater= ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE));

        this.context = context;
    }

    public void updateRes(List<DaGaiFenLeiBean> data){

        if (data != null) {
            this.title.clear();
            this.title.addAll(data);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return title!=null?title.size():0;
    }

    @Override
    public DaGaiFenLeiBean getItem(int position) {
        return title.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.fenlei_frag_item,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = ((ViewHolder) convertView.getTag());
        }
        holder.mTitle.setText(getItem(position).getCname());

        holder.mGridView.setAdapter(new FenLeiGridAdapter(context,getItem(position).getChild_data()));
        holder.mGridView.setOnItemClickListener(this);
        holder.mGridView.setTag(position);

        return convertView;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int gridPosition, long id) {
        int position = (int) parent.getTag();
        Intent intent = new Intent(context, AllVideoActivity.class);
        intent.putExtra("gameName",getItem(position).getChild_data().get(gridPosition).getEname());
        intent.putExtra("cname",getItem(position).getChild_data().get(gridPosition).getCname());

        context.startActivity(intent);
    }

    public static class ViewHolder {

        @BindView(R2.id.fenlei_item_tv_title)
        TextView mTitle;

        @BindView(R2.id.fenlei_item_gv_content)
        GridView mGridView;

        public ViewHolder(View itemView){
            ButterKnife.bind(this,itemView);
        }
    }
}
