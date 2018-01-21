package com.designpattern.adapter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午1:55 2018/1/19
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file.Name:" + fileName);
    }

    @Override
    public void palyMp4(String fileName) {
        // nothing to do
    }
}
