package com.dozer;

import com.alibaba.fastjson.JSONObject;
import com.domain.dozerDO.DzDestinationDO;
import com.domain.dozerDO.DzSourceDO;
import com.example.demo.MadridApplication;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.util.Date;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 上午10:59 2018/3/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
public class DozerTest {
    @Autowired
    Mapper mapper;
    @Test
    public void test_1() {
//        Mapper mapper = new DozerBeanMapper();
        DzSourceDO dzSourceDO=new DzSourceDO();
        dzSourceDO.setId(1L);
        dzSourceDO.setName("name");
        dzSourceDO.setDate(new Date());
        DzDestinationDO dzDestinationDO=mapper.map(dzSourceDO,DzDestinationDO.class);
        System.out.println(dzDestinationDO.getDate());
    }
    @Test
    public void test_2(){
        DzSourceDO dzSourceDO=new DzSourceDO();
        dzSourceDO.setId(1L);
        dzSourceDO.setName("name");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("attr","attr");
        dzSourceDO.setAttributes(jsonObject.toJSONString());
        StopWatch stopWatch=new StopWatch();
        stopWatch.start("task");
        DzDestinationDO dzDestinationDO=mapper.map(dzSourceDO,DzDestinationDO.class);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(dzDestinationDO);
    }

    @Test
    public void test_3(){
        Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();
        DzSourceDO dzSourceDO=new DzSourceDO();
        dzSourceDO.setId(1L);
        dzSourceDO.setName("name");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("attr","attr");
        dzSourceDO.setAttributes(jsonObject.toJSONString());
        DzDestinationDO dzDestinationDO = mapper.map(dzSourceDO,DzDestinationDO.class);
        System.out.println(dzDestinationDO);
    }
}
