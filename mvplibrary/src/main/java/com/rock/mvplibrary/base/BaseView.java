package com.rock.mvplibrary.base;

/**
 * Created by Rock on 2017/3/24.
 */

public interface BaseView {

    void onStartLoad();

    void onStopLoad();

    void onError(String errorInfo);

}
