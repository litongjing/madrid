package com.example.demo;

import com.util.EnvProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ImportResource(locations = "classpath:config/madrid-config.xml")
@SpringBootApplication
@Slf4j
//多数据源时（多个DataSource.class）排除DataSourceAutoConfiguration.class
//或datasource bean 设置primary @Primary注解的实例优先于其他实例被注入
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
//
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DevToolsDataSourceAutoConfiguration.class})
public class MadridApplication {
    //日志声明式
    //	private final static Logger log = LoggerFactory.getLogger(MadridApplication.class);
    @Autowired
    EnvProperties envProperties;


    @RequestMapping("/status")
    public String status() {
        //当前环境
        log.info("###### current environment is {} ###########", envProperties.getEnv());
        return envProperties.getEnv();
    }

    public static void main(String[] args) {
        SpringApplication.run(MadridApplication.class, args);
        log.info("log4g & @Slf4j :{}", "success");
    }
}
