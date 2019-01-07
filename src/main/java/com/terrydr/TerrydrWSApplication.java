package com.terrydr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Copyright (C), 2018-2020, NanJing Terrydr. Co., Ltd.
 *
 * @Package: com.terrydr
 * @Description: Spring Boot 程序入口
 * @author: YanZhengYaun
 * @Date: 2018/4/14 16:11
 * @version: 1.00
 */
@SpringBootApplication
//@EnableTransactionManagement
@EnableAsync //开启servlet、拦截器、filter、listener的异步处理功能，servlet3.0+
public class TerrydrWSApplication{

    /**
    * @Description: 程序入口方法
    * @param args
    * @return
    * @throws
    * @author YanZhengYaun
    * @date 2018/4/14 16:32
    */
    public static void main(String[] args) {
        SpringApplication.run(TerrydrWSApplication.class, args);
    }

}
