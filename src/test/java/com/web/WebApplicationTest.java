package com.web;

import com.controller.DemoController;
import com.example.demo.MadridApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午2:51 2018/4/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MadridApplication.class)
@WebAppConfiguration
public class WebApplicationTest {
   private MockMvc mvc;

    @Before
    public void setUp(){
        mvc= MockMvcBuilders.standaloneSetup(new DemoController()).build();
    }

    @Test
    public void sleep() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hellohello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("haha")));
    }
}
