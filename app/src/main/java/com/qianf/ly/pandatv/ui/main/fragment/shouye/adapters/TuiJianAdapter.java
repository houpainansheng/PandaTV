


package com.qianf.ly.pandatv.ui.main.fragment.shouye.adapters;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.bean.PendaStarDataBean;
import com.qianf.ly.pandatv.bean.ShouYeModelListBean;
import com.qianf.ly.pandatv.bean.ShouYePetBean;
import com.qianf.ly.pandatv.ui.main.activity.AllVideoActivity;
import com.qianf.ly.pandatv.ui.main.fragment.game.model.GridViewForListView;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.callback.PendaCallBack;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.presenter.TuiJianPresenter;
import com.qianf.ly.pandatv.ui.jump.activity.PandaStarActivity;
import com.rock.mvplibrary.adapters.BaisBaseAdapter;

import java.util.List;

/**
 * Created by 樊康 on 2017/3/27.
 */

public class TuiJianAdapter extends BaisBaseAdapter<ShouYeModelListBean> implements View.OnClickListener,PendaCallBack{

    private static final String TAG = TuiJianAdapter.class.getSimpleName();
    private Context context;
    private TuiJianGridViewAdapter adapter;
    private PendaStarAdapter adapter1;
    private TuiJianPresenter mPresenter;
    private String ename;
    private String cname;
    private Button v1;
    private TextView mText;

    public TuiJianAdapter(Context context, List<ShouYeModelListBean> data, int layoutResId,TuiJianPresenter mPresenter) {
        super(context, data, layoutResId);
        this.context = context ;
        this.mPresenter=mPresenter;


    }

    @Override
    protected void bindData(ViewHolder holder, ShouYeModelListBean item, int position) {

        //给推荐页面添加数据
        mText = ((TextView) holder.findView(R.id.frag_tuijian_item_title));
        holder.setText(R.id.frag_tuijian_item_title,item.getCard_title());

        //这个按钮需要设置点击事件
        Button button = (Button) holder.findView(R.id.frag_tuijian_item_more);

        //声明出 GridView
        GridViewForListView gridView = (GridViewForListView) holder.findView(R.id.frag_tuijian_gridView);
        button.setVisibility(View.VISIBLE);



        if (item.getCard_title().equals("热门")){

            button.setVisibility(View.GONE);
            //为GridView设置适配器\

        }


        if (item.getCard_title().equals("熊猫星颜")){

            //为GridiView设置适配器o
            adapter1 = new PendaStarAdapter(context,null, R.layout.penda_star_gv_item);
            gridView.setAdapter(adapter1);
            mPresenter.initLoadStarData(this);


            holder.setText(R.id.frag_tuijian_item_more,"加载更多");

        }else {
            holder.setText(R.id.frag_tuijian_item_more,"全部"+String.valueOf(item.getTotal())+"个直播>");
            adapter = new TuiJianGridViewAdapter(context,item.getItems(), R.layout.frag_tuijian_item_gridview);
            //获取不同的与游戏名

            Log.e(TAG, "bindData: 游戏名:"+ename );
            gridView.setAdapter(adapter);

        }

        button.setTag(position);
        button.setOnClickListener(this);

            //这里的熊猫星颜是传不了 Ename , Cname 的



    }

    @Override
    public void onClick(View v) {

        v1 = (Button) v;
        switch (v.getId()) {

            case R.id.frag_tuijian_item_more:

               if (v1.getText().equals("加载更多")){

                //   Toast.makeText(context, "能点击", Toast.LENGTH_SHORT).show();

                   Intent intent = new Intent(context, PandaStarActivity.class);

                    context.startActivity(intent);
                   
               }else{
                   //将游戏的英文名传给Activity.
                   Intent intent = new Intent(context.getApplicationContext(), AllVideoActivity.class);

                   int position = (int) v.getTag();


                   ShouYePetBean classification = getItem(position).getItems().get(0).getClassification();
                   //将tag传过去
                   intent.putExtra("gameName",classification.getEname());
                   intent.putExtra("cname",classification.getCname());
                   Log.e(TAG, "onClick: 需要传的值"+ename );
                   context.startActivity(intent);
               }

                break;


        }
    }


    @Override
    public void retuenData(PendaStarDataBean data) {

        Log.e(TAG, "retuenData: "+data );
        adapter1.updateRes(data.getData().getItems());
    }



}
