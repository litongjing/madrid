package com.ibatis;

import com.example.demo.MadridApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午5:38 2018/3/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
//基本的所有配置都会通过入口类去加载，而注解可以引用入口类的配置
@SpringBootTest(classes = MadridApplication.class)
//@WebAppConfiguration
@Slf4j
public class IbatisTest {
    @Autowired
    Dao dao;
    @Autowired
    IbatisService ibatisService;

    @Test
    public void test_1() {
        dao.insert(new Ibatis("2", "new3"));
        Ibatis ibatis3 = dao.getById("2");
        ibatis3.setName("new7");
        dao.update(ibatis3);
//       testDAOImpl.delete("3");
        System.out.println("获得全查询列表");
        List<Ibatis> result = new ArrayList<Ibatis>();
        result = dao.getList();
        ThreadLocal<String> holder = new ThreadLocal<String>();
        System.out.println(holder.get());
        for (Iterator<Ibatis> iter = result.iterator(); iter.hasNext(); ) {
            Ibatis element = (Ibatis) iter.next();
            System.out.println(element.getName());
        }
    }

    @Test
    public void test_2() throws SQLException {
//        ibatisService.insert(new Ibatis("22", "new3"));
//        ibatisService.insert1(new Ibatis("25","new4"));
    }
}
