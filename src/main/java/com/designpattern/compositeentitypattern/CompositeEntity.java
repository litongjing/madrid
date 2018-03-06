package com.designpattern.compositeentitypattern;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:43 2018/2/23
 */
public class CompositeEntity {
    private CoarseGrainedObject cgo = new CoarseGrainedObject();

    public void setData(String data1, String data2) {
        cgo.setData(data1, data2);
    }

    public String[] getData() {
        return cgo.getData();
    }
}
