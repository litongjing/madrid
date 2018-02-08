package com.domain.DO;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午7:32 2018/2/7
 */
@Data
@Table(name = "coupon")
public class CampnouCouponDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Date gmtCreate;
    private Date gmtModified;
    @Column(name = "couponcode")
    private String couponCode;
    @Column(name = "couponname")
    private String couponName;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "leftamount")
    private BigDecimal leftAmount;
    //@Transient
    private AttributeDO attributes;
}
