package com.wjt.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Time 2020/1/31/17:46
 * @Author jintao.wang
 * @Description
 */
@Slf4j
@Configuration
@ImportResource(locations = {"classpath:dao/mybatis_spring.xml"})
//@EnableTransactionManagement
public class DaoConfig {

}
