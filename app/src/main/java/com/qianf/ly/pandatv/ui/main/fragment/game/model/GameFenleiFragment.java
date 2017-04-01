package com.qianf.ly.pandatv.ui.main.fragment.game.model;

import android.widget.ListView;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.R2;
import com.qianf.ly.pandatv.ui.main.fragment.game.adapter.FenleiAdapter;
import com.qianf.ly.pandatv.ui.main.fragment.game.bean.fenlei.FenLeiList;
import com.rock.mvplibrary.base.BaseFragment;

import java.util.HashMap;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/25.
 */

public class GameFenleiFragment extends BaseFragment {

    private static final String FENLEI_TITLE = "http://api.m.panda.tv";
    private static final String TAG = GameFenleiFragment.class.getName();
    @BindView(R2.id.game_frag_lv_fenlei)
    ListView mListView;
    private FenleiAdapter adapter;



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_game_fenlei;
    }




    @Override
    public void initView() {


        adapter = new FenleiAdapter(getActivity(),null);
        mListView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(FENLEI_TITLE)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        HashMap<String, String> map = new HashMap<>();

        map.put("method","category.gamelist");
        map.put("__version","3.0.1.3028");
        map.put("__plat","android");
        map.put("__channel","guanwang");
        Call<FenLeiList> fenLeiList = apiService.getFenLeiList(map);

        fenLeiList.enqueue(new Callback<FenLeiList>() {

            @Override
            public void onResponse(Call<FenLeiList> call, Response<FenLeiList> response) {
                adapter.updateRes(response.body().getData());
            }

            @Override
            public void onFailure(Call<FenLeiList> call, Throwable t) {

            }
        });

    }


}
