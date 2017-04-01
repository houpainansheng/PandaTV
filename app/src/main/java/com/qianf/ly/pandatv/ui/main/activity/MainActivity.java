package com.qianf.ly.pandatv.ui.main.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.qianf.ly.pandatv.R;
import com.qianf.ly.pandatv.ui.main.fragment.game.GameFragment;
import com.qianf.ly.pandatv.ui.main.fragment.my.MyFragment;
import com.qianf.ly.pandatv.ui.main.fragment.shouye.ShouYeFragment;
import com.qianf.ly.pandatv.ui.main.fragment.yule.YuLeFragment;
import com.rock.mvplibrary.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends BaseActivity implements View.OnClickListener{


    private Fragment mShowFragment;
    private boolean isExit;
    private RadioGroup mRadioGroup;
    private RadioButton mShouYe;
    private RadioButton mGame;
    private RadioButton mYule;
    private RadioButton mMy;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_radio_group_dibu);
        mShouYe = (RadioButton) findViewById(R.id.main_radio_btn_shouye);
        mGame = (RadioButton) findViewById(R.id.main_radio_btn_game);
        mYule = (RadioButton) findViewById(R.id.main_radio_btn_yule);
        mMy = (RadioButton) findViewById(R.id.main_radio_btn_my);


        mShouYe.performClick();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_radio_btn_shouye:
                switchPage(ShouYeFragment.TAG);
                break;
            case R.id.main_radio_btn_game:
                switchPage(GameFragment.TAG);
                break;
            case R.id.main_radio_btn_yule:
                switchPage(YuLeFragment.TAG);
                break;
            case R.id.main_radio_btn_my:
                switchPage(MyFragment.TAG);
                break;
        }
    }

    private void switchPage(String tag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        // 隐藏当前显示的页面
        if (mShowFragment != null) {
            transaction.hide(mShowFragment);
        }
        // 去缓存中查找
        mShowFragment = fm.findFragmentByTag(tag);
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        }else{
            try {
                mShowFragment = (Fragment) Class.forName(tag).newInstance();
                transaction.add(R.id.main_frame_layout_jiemian,mShowFragment,tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        transaction.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         *  当菜单显示的时候，点击返回，隐藏菜单
         *  点击提示 再按一次退出
         *
         *  ① 监听返回键
         *  ②
         */
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 条件
            if (!isExit){
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                isExit = true;
                // 还原标志位状态
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        // delay之后执行的代码
                        isExit = false;
                    }
                },2 * 1000);
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
