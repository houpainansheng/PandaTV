package com.qianf.ly.pandatv.utils;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by baisaikele on 2017/3/27.
 */

public class LYBarrageUtil {


    private static List<TextView> l1, l3;
    private static List<String> s1;
    private Activity activity;
    private int viewID;


    public LYBarrageUtil(Activity activity, int viewID) {
        this.activity = activity;
        this.viewID = viewID;
        l1 = new ArrayList<>();
        l3 = new ArrayList<>();
        s1 = new ArrayList<>();

    }

    public static final int CLEARTEXTVEW = 1;
    public static final int WAITTEXT = 2;

    private Handler handler = new Handler(new Handler.Callback() {


        @Override
        public boolean handleMessage(Message msg) {


            switch (msg.what) {
                case CLEARTEXTVEW:

                    if (l1.size() > 0) {
                        l1.remove(l1.size() - 1);
                        handler.removeMessages(CLEARTEXTVEW);
                        handler.sendEmptyMessageDelayed(10000, CLEARTEXTVEW);
                    }
                    break;
                case WAITTEXT:
                    if (s1.size() > 0) {
                        getAnimator(s1.get(0), 1);

                    }
                    break;


            }
            return false;
        }
    });


    public void getAnimator(String text, int type) {


        if (!isStrat) {
            return;
        }
        final TextView textView;
        if (type!=3) {
             textView= getTextVeiw();

            if (textView == null) {
                if (type != 1)
                    s1.add(text);
                return;
            } else {
                if (type == 1)
                    s1.remove(0);
            }
        }else {
            textView=new TextView(activity);
        }


        textView.setText(text);
        textView.setTextColor(0x00000000);
        textView.setBackgroundColor(0x00000000);
        final RelativeLayout relView = (RelativeLayout) activity.findViewById(viewID);
        relView.addView(textView);

        textView.post(new Runnable() {

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {

                if (!isStrat) {
                    return;
                }
                textView.setVisibility(View.VISIBLE);
                textView.setTextColor(Color.WHITE);
                textView.setBackgroundColor(Color.RED);



                int width = textView.getWidth();
                int height = textView.getHeight();

                int heightPixels = activity.getResources().getDisplayMetrics().heightPixels;
                int widthPixels = activity.getResources().getDisplayMetrics().widthPixels;
                int y = (int) (Math.random() * (heightPixels - height * 2));


//                动画
                ObjectAnimator animators = ObjectAnimator.ofFloat(textView, "TranslationY", 0, y);
                animators.start();
                ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "TranslationX", widthPixels, 0-width);
                animator.setDuration(3000);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                        l3.remove(textView);
                        l1.add(0, textView);
                        relView.removeView(textView);
                        handler.sendEmptyMessage(WAITTEXT);

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
                animator.start();
            }
        });


    }

    private int num = 0;

    public synchronized TextView getTextVeiw() {

        num++;
        TextView textView = null;
        if (l1.size() == 0 && (l1.size() + l3.size() + num) < 3) {
            textView = new TextView(activity);
            l3.add(textView);
//            计时清除l1中的textview
            handler.sendEmptyMessageDelayed(CLEARTEXTVEW, 10000);

        } else if (l1.size() > 0) {
            textView = l1.get(0);
            l1.remove(0);
        }
        num--;
        return textView;
    }

    private boolean isStrat=true;
    public void stop(){

        isStrat=false;
    }

    public void start(){

        isStrat=true;
    }


}
