package com.others;

import com.domain.DO.CouponDO;
import com.exception.MadridException;
import org.junit.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.Optional;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:49 2017/12/14
 */
public class other {
    @Test
    public void test_optional(){
        CouponDO couponDO=null;
        Optional<CouponDO> op=Optional.ofNullable(couponDO);//of不能为null //ofNullable允许null
        op.ifPresent(e->{
            System.out.println("is present");
            System.out.println(e);
        });
        //couponDOOptional.orElseThrow(()->new MadridException("is null --"));

        System.out.println(op.orElse(new CouponDO()));

        System.out.println(op.orElseGet(() -> new CouponDO()));

        System.out.println(op.isPresent());

        CouponDO couponDO1=new CouponDO();
        couponDO1.setAmount("1000");
        Optional<CouponDO>op1=Optional.ofNullable(couponDO1);
        System.out.println(op1.filter(e -> {
            BigDecimal b = new BigDecimal(e.getAmount());
            return b.compareTo(BigDecimal.TEN) == 1;
        }).orElse(new CouponDO()));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(op1.map(e->e.getAmount()));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(op1.map(e -> e.getAmount()).get());

        System.out.println("~~~~~~~~~~~");

    }
}
