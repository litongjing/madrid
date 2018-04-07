package com.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.domain.DO.CouponDO;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.junit.Test;
import org.springframework.util.StopWatch;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.PrivateKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:50 2018/2/26
 */
public class Util {

    @Test
    public void test_1() {
        String access_token_url = "https://oapi.dingtalk.com/gettoken?corpid=CorpID&corpsecret=SECRET";
        String requestUrl = access_token_url
                .replace("CorpID", "ding10dfcbc0c7dabea235c2f4657eb6378f").replace("SECRET", "gpcpE2w46l9dmofWcUYcWtQsUKjCmgptjW05Q5IDIJMmFWq-12ef3NmAcjA0Nnh_");
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("getToken");
        JSONObject jsonObject = request(requestUrl, "GET", null);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(jsonObject);
    }

    @Test
    public void test_2() {
        //9f8c477337053066a481feb4f3cbae9f
        String access_token_url = "https://oapi.dingtalk.com/user/get?access_token=ACCESS_TOKEN&userid=zhangsan";
        String requestUrl = access_token_url
                .replace("ACCESS_TOKEN", "9f8c477337053066a481feb4f3cbae9f").replace("zhangsan", "10143988");
        System.out.println(requestUrl);
        JSONObject jsonObject = request(requestUrl, "GET", null);
        System.out.println(jsonObject);
    }

    private JSONObject request(String request, String RequestMethod, String output) {
        System.out.println("请求参数：" + output);
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            // 建立连接
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(RequestMethod);
            connection.setRequestProperty("Content-Type", "application/json");
            if (output != null) {
                OutputStream out = connection.getOutputStream();
                out.write(output.getBytes("UTF-8"));
                out.close();
            }
            // 流处理
            InputStream input = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input, "UTF-8");
            BufferedReader reader = new BufferedReader(inputReader);
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            // 关闭连接、释放资源
            reader.close();
            inputReader.close();
            input.close();
            input = null;
            connection.disconnect();
            jsonObject = JSONObject.parseObject(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Test
    public void test_other() throws ParseException {
        Double db = 10.00;
        System.out.println(new BigDecimal(db));
        System.out.println(new Date().getTime());
        JSONObject jsonObject = null;
        System.out.println(jsonObject == null ? null : jsonObject.toString());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
        Date date = sf.parse("2018-03-01");
        System.out.println(date.getTime());
        System.out.println(JSON.parseObject(null));
        //sdfk
    }

    @Test
    public void test_other1() {
        List<String> list = Lists.newArrayList();
        for (int i = 0; i < 10001; i++) {
            list.add(i + "");
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        List<String> list1 = list.stream().map(e -> {
            System.out.println(e);
            return e;
        }).collect(toList());
        System.out.println(list1.size());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void test_other2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(new Date()));
        System.out.println(sdf.parse("2018-03-12 10:12:13").getTime());
        System.out.println(sdf.parse("2018-03-12 10:12:15").getTime());
        Long as = 123L;
        Optional.ofNullable(as).ifPresent(
                e -> {
                    System.out.println(e);
                }
        );
    }

    @Test
    public void test_other3() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("a", "b");
        System.out.println(JSON.toJSONString(jsonObject, true));
    }

    @Test
    public void test_other4() {
        new Thread(new Runnable() {
            ThreadLocal<String> tl = new ThreadLocal<String>();

            @Override
            public void run() {
                tl.set("oh my god!");
                String s = tl.get();
                System.out.println(s);
            }
        }).start();
    }

    @Test
    public void test_other5() {
        final ThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("I love China");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(local.get());
            }
        }).start();
    }

    @Test
    public void test_test() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("desc", "desc");
        byte[] b = jsonObject.toString().getBytes();
        System.out.println(new String(b));
        List<Integer> list = Lists.newArrayList();
//        for(int i=0;i<10;i++){
//            list.add(i);
//        }
        Optional<Integer> any = list.stream().filter(e -> !Strings.isNullOrEmpty(e.toString())).findFirst();
        System.out.println(any.isPresent());
        any.ifPresent(e -> {
            System.out.println(1234);
        });
        //any.ifPresent();
        JSONObject jsonObject1 = new JSONObject();
        System.out.println(jsonObject == null);
    }

    @Test
    public void test_12() {
        long UA = 'u';
        Random RANDOM = new Random();
        short seqid = (short) RANDOM.nextInt();
        long time = System.currentTimeMillis() / 1000;
        Long a = (UA << 56) | ((time << 16) & 0xFFFFFFFF) | seqid & 0xFFFF;
        long a1 = UA << 56;
        System.out.println(a);


        long a2 = ((time << 16) & 0xFFFFFFFF);
        System.out.println(a2);
        long a3 = a1 | a2;
        System.out.println(a3);
        System.out.println(a1 + a2);
        System.out.println(UUID.randomUUID());

        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());


    }

    @Test
    public void test_13() {
        int count = 4;
        while (count > 0) {
            System.out.println(count);
            count--;
        }
    }

    @Test
    public void test_14() {
        CouponDO couponDO = new CouponDO();
    }

    @Test
    public void test_15() throws ParseException {
        CouponDO couponDO = new CouponDO();
        couponDO.setEndDate(DateUtils.parse("2018-01-01 12:12:12"));
        CouponDO couponDO1 = new CouponDO();
        couponDO1.setEndDate(DateUtils.parse("2018-01-01 12:12:12"));
        List<CouponDO> list = Lists.newArrayList(couponDO, couponDO1);
        list=null;
        System.out.println(list.size());
        CouponDO couponDO2 = list.stream().max((k, v) -> {
            return k.getEndDate().compareTo(v.getEndDate());
        }).get();
        //
        System.out.println(DateUtils.format(couponDO2.getEndDate()));
    }

    @Test
    public void test_16() throws ParseException {
        Date date1=DateUtils.parse("2018-01-01 01:12:12");
        Date date2=DateUtils.parse("2018-01-01 12:12:10");
        System.out.println(DateUtils.dayDiff(date2,date1));
        System.out.println(DateUtils.dayDiff(date1,date2));
        System.out.println(DateUtils.getStartOfDay(date1));
        System.out.println(DateUtils.plusDay(date1,12));
        System.out.println(DateUtils.subDay(date2, 1));
    }
    @Test
    public void test_17(){
        CouponDO couponDO=new CouponDO();
        couponDO.setAmount(BigDecimal.TEN);
        List<CouponDO>couponDOS=Lists.newArrayList();
        List<CouponDO> couponDOS1=couponDOS.stream().filter(e->{
            return e.getAmount().compareTo(new BigDecimal(1))==1;
        }).collect(toList());

        Optional<CouponDO> couponDOS2=couponDOS.stream().filter(e->{
            return e.getAmount().compareTo(new BigDecimal(1))==1;
        }).findFirst();
        System.out.println(couponDOS2);
        System.out.println(couponDOS1);
    }

    @Test
    public void test_18(){
        Integer i=null;
        Integer j=1;
        System.out.println(i.equals(j));
    }
}
