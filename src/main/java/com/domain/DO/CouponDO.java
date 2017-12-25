package com.domain.DO;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:33 2017/12/11
 */
@Data
public class CouponDO  implements Serializable{
    private static final long serialVersionUID = -2904125898146512045L;
    private String actionNo;
    private String extRule;
    private String payRule;
    private String couponCode;
    private String couponName;
    private String couponDesc;
    private String amount;
    private String leftAmount;
    private String counts;
    private String passWord;
    private String msgCode;
    private String account;
    private String cardNo;
    private String storeNo;
    private String status;
    private String isPrint;
    private Date startDate;
    private Date endDate;
    private String posSeq;
    private Date createDate;
    private String channel;
    private String reserved1;
    private String reserved2;
    private String reserved3;
    private String reserved4;

    public CouponDO(){

    }

    public CouponDO(String couponCode){
        this.couponCode=couponCode;
    }
}
