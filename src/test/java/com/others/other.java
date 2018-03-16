package com.others;

import com.alibaba.druid.support.profile.Profiler;
import com.domain.DO.AttributeDO;
import com.domain.DO.CampnouCouponDO;
import com.domain.DO.CouponDO;
import com.domain.DTO.CardDTO;
import com.exception.MadridException;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.util.DateUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.springframework.util.StopWatch;

import javax.swing.text.html.Option;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;

import static com.alibaba.fastjson.JSON.toJSON;
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
        couponDO1.setAmount(BigDecimal.TEN);
        Optional<CouponDO> op1 = Optional.ofNullable(couponDO1);
        System.out.println(op1.filter(e -> {
            BigDecimal b = e.getAmount();
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
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        String[] str = new String[]{"hello", "world"};
        System.out.println(Arrays.stream(str).map(e -> e.split("")).flatMap(Arrays::stream).collect(toList()));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);

        System.out.println(someNumbers.stream()
                .map(x -> x * x)
                .filter(x -> x % 3 == 0).collect(toList()));
        Integer[] integers=new Integer[]{1,2,3,4,5};

        System.out.println(Arrays.stream(integers).reduce(Integer::max).get());

    }

    @Test
    public void test_date() {
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

    @Test
    public void test_reflect() throws NoSuchFieldException, IllegalAccessException {
        CouponDO couponDO = new CouponDO();
//        Class<?>clazz=couponDO.getClass();  //对象
//        Class<?>clazz=CouponDO.class; //类
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.domain.DO.CouponDO");//路径
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        Method[] methods = clazz.getMethods();//method
        Arrays.stream(methods).forEach(e -> {
            System.out.println("方法: " + e.toString());
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
        Field[] fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        Arrays.stream(fields).forEach(e -> {
            System.out.println("属性: " + e.toString());
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        Constructor[] constructors = null;
        constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(e -> {
            System.out.println(e.toString());
        });
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
        CouponDO couponDO1 = null;
        try {
            couponDO1 = (CouponDO) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Field amountField = clazz.getDeclaredField("amount");
        System.out.println(amountField.getType());
        amountField.setAccessible(true);
        amountField.set(couponDO1, BigDecimal.TEN);
        System.out.println(couponDO1.getAmount());
    }

    @Test
    public void test_parallelStream() {
        List<Map<String, Object>> list = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("a", i);
            list.add(map);
        }
        long start = new Date().getTime();
//        list.parallelStream().forEach(e->{
//            try {
//                System.out.println(e.get("a").toString());
//                Thread.sleep(1000);
//            } catch (InterruptedException e1) {
//                e1.printStackTrace();
//            }
//        });
        list.stream().forEach(e -> {
            try {
                System.out.println(e.get("a").toString());
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        System.out.println("~~~~~~~~");
        System.out.println("1");
        list.stream().forEach(System.out::println);
        System.out.println(2);
        System.out.println(new Date().getTime() - start);
    }

    @Test
    public void test12() {
//        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        java.util.Date date = new Date(1515125775*1000);
//        String str = sdf.format(date);
//        System.out.println(str);
        System.out.println(new Date(1515032175000L));
        AttributeDO attributeDO = new AttributeDO();
        attributeDO.setDate(new Date());
        System.out.println(toJSON(attributeDO));
    }

    @Test
    public void test13() {
        int i = 1;
        int a = 0;
        a = i++;
        System.out.println(a);
        int i1 = 1;
        System.out.println(++i1);

        int b1 = 0;
        int b2 = 0;
    }

    @Test
    public void test14() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        CouponDO couponDO = new CouponDO();
        CampnouCouponDO campnouCouponDO = new CampnouCouponDO();
        campnouCouponDO.setId("11");
        couponDO.setAmount(BigDecimal.TEN);
        CardDTO cardDTO = new CardDTO();
        cardDTO.setPrice(BigDecimal.ZERO);
        /**/
        CouponDO couponDO1 = (CouponDO) BeanUtils.cloneBean(couponDO);
        System.out.println(couponDO.hashCode() + "  " + couponDO1.hashCode());
        couponDO1.setAccount("111");
        System.out.println(couponDO.equals(couponDO1));
        System.out.println(couponDO);
        System.out.println(couponDO1);

        CouponDO couponDO2 = new CouponDO();
        /**/
        BeanUtils.copyProperties(cardDTO, campnouCouponDO);
        System.out.println(cardDTO);
        /**/
        System.out.println(BeanUtils.describe(couponDO).get("amount").toString());
        /**/
        System.out.println(BeanUtils.getSimpleProperty(couponDO, "amount"));
        /**/
        BeanUtils.setProperty(couponDO, "couponName", "haha");
        System.out.println(couponDO);
    }
}
