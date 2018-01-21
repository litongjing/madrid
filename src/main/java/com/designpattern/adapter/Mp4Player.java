package com.designpattern.adapter;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午1:56 2018/1/19
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //nothing
    }

    @Override
    public void palyMp4(String fileName) {
        System.out.println("Playing mp4 file.Name:" + fileName);
    }
}
