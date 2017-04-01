package com.qianf.ly.pandatv.decideView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by baisaikele on 2017/3/28.
 */

public class LYFramLayout extends FrameLayout {

    private GestureDetector mGestureDetector;
    public LYFramLayout(Context context) {
        super(context);
    }

    public LYFramLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LYFramLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }

    public GestureDetector getmGestureDetector(Context context , GestureDetector.OnGestureListener listener) {
        mGestureDetector=new GestureDetector(context,listener);
        return mGestureDetector;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 一定记住，使用手势探测器的时候，要主动调用onTouchEvent来进行事件传入（数据源输入）
        return mGestureDetector.onTouchEvent(event) || super.onTouchEvent(event);
    }


}
