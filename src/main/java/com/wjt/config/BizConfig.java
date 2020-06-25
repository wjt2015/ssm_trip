package com.wjt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2020/3/20/12:41
 * @Author jintao.wang
 * @Description
 */
@Configuration
@Import(value = {ServiceConfig.class})
public class BizConfig {
    private static final Logger log = LoggerFactory.getLogger(BizConfig.class);


    @Bean
    public Map<Long, String> map() {

        Map<Long, String> map = new HashMap<>();

        map.put(1L, "A");
        map.put(2L, "B");

        log.info("test;map={};", map);
        return map;
    }


}
