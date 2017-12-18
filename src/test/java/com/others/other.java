package com.others;

import com.domain.DO.CouponDO;
import com.exception.MadridException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午11:49 2017/12/14
 */
public class other {
    @Test
    public void test_optional() {
        CouponDO couponDO = null;
        Optional<CouponDO> op = Optional.ofNullable(couponDO);//of不能为null //ofNullable允许null
        op.ifPresent(e -> {
            System.out.println("is present");
            System.out.println(e);
        });
        //couponDOOptional.orElseThrow(()->new MadridException("is null --"));

        System.out.println(op.orElse(new CouponDO()));

        System.out.println(op.orElseGet(() -> new CouponDO()));

        System.out.println(op.isPresent());

        CouponDO couponDO1 = new CouponDO();
        couponDO1.setAmount("1000");
        Optional<CouponDO> op1 = Optional.ofNullable(couponDO1);
        System.out.println(op1.filter(e -> {
            BigDecimal b = new BigDecimal(e.getAmount());
            return b.compareTo(BigDecimal.TEN) == 1;
        }).orElse(new CouponDO()));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(op1.map(e -> e.getAmount()));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(op1.map(e -> e.getAmount()).get());

        System.out.println("~~~~~~~~~~~");

    }

    @Test
    public void test_stream() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("amount", i);
            list.add(map);
        }
        System.out.println(list);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(list.stream().filter((e) -> {
            BigDecimal b = new BigDecimal(e.get("amount").toString());
            return b.compareTo(BigDecimal.TEN) == 1;
        }).collect(toList()));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        System.out.println(list.stream()
                .filter((e) -> !e.get("amount").equals("1000"))
                .anyMatch((e) -> !e.get("amount").equals("10000")));

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(list.stream().skip(10).collect(toList()));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(list.stream().limit(10).collect(toList()));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(list.stream().map((e) -> e.get("amount")).collect(toList()));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //能够从流中随便选一个元素出来，找到第一个
        list.stream().findAny().get();


    }

    @Test
    public void test_date(){
        LocalDate date = LocalDate.of(2014, 3, 18);
        int year = date.getYear();
        System.out.println(year);
        Month month = date.getMonth();
        System.out.println(month);
        int day = date.getDayOfMonth();
        System.out.println(day);
        //星期几
        DayOfWeek dow = date.getDayOfWeek();
        System.out.println(dow);
        int len = date.lengthOfMonth();
        System.out.println(len);
        boolean leap = date.isLeapYear();
        System.out.println(leap);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        System.out.println(hour);
        int minute = time.getMinute();
        System.out.println(minute);
        int second = time.getSecond();
        System.out.println(second);

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        LocalDate date2 = LocalDate.parse("2014-03-18");
        LocalTime time2 = LocalTime.parse("13:45:20");
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(13, 45, 20);
        LocalDateTime dt4 = date.atTime(time2);
        LocalDateTime dt5 = time.atDate(date2);
    }
}
