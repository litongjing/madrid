package com.designpattern.compositeentitypattern;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:42 2018/2/23
 */
public class CoarseGrainedObject {
    DependentObject1 do1 = new DependentObject1();
    DependentObject2 do2 = new DependentObject2();

    public void setData(String data1, String data2) {
        do1.setData(data1);
        do2.setData(data2);
    }

    public String[] getData() {
        return new String[]{do1.getData(), do2.getData()};
    }
}
