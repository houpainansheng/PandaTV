package com.qianf.ly.pandatv.utils;

import android.content.Context;
import android.media.AudioManager;

import com.orhanobut.logger.Logger;

/**
 *  声音的控制 也是通过一个服务来进行管理的
 *      Context.getSystemService
 */
public class AudioController {
    /**
     * 调高音量
     *      ① 获取当前音量
     *      ② 计算变化
     *      ③ 设置
     *
     *     yDelta < 0
     *
     */
    public static void turnUp(Context context,float yDelta,int width){
        AudioManager systemService = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取当前音乐音量  媒体音量
        int currentVolume = systemService.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = systemService.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 计算变化值
        int change = (int) (5*maxVolume * yDelta / width);

        int volume = Math.min(maxVolume, currentVolume + change);
        // 设置值
        systemService.setStreamVolume(AudioManager.STREAM_MUSIC,volume,AudioManager.FLAG_SHOW_UI);
    }

    /**
     * 调低音量
     */
    public static void turnDown(Context context,float yDelta,int width){
        AudioManager systemService = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        // 获取当前音乐音量  媒体音量
        int currentVolume = systemService.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = systemService.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        // 计算变化值
        Logger.e(currentVolume+"");
        int change = (int) (5*maxVolume * yDelta / width);

        int volume = Math.max(0, currentVolume + change);
        // 设置值
        systemService.setStreamVolume(AudioManager.STREAM_MUSIC,volume,AudioManager.FLAG_SHOW_UI);

    }


}
