package com.exception;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:27 2017/12/15
 */
public class MadridException extends RuntimeException{
    public MadridException(String str){
        super(str);
    }
    public MadridException(){
        super();
    }
}
