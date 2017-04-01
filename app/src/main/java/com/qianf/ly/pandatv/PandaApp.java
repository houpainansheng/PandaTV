package com.qianf.ly.pandatv;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by baisaikele on 2017/3/24.
 */

public class PandaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoad();
    }

    private void initImageLoad() {
        // ImageLoader的配置文件
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                // 配置加载过程中的图片
                .showImageOnLoading(R.mipmap.game_cate_default_icon)
                // 加载错误的图片
                .showImageOnFail(R.mipmap.ic_launcher)
                // 加载地址为null的图片
                .showImageForEmptyUri(R.mipmap.game_cate_default_icon)
                // 打开memory缓存
                .cacheInMemory(true)
                // 打开disk 缓存
                .cacheOnDisk(true)
                // 修改图片加载质量
                .bitmapConfig(Bitmap.Config.RGB_565)
                .displayer(new RoundedBitmapDisplayer(15))
                .build();
        ImageLoaderConfiguration builder = new ImageLoaderConfiguration.Builder(this)
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs()
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(builder);
    }


}
