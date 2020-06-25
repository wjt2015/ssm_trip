package com.wjt.config;

import com.wjt.web.AdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2020/1/31/17:47
 * @Author jintao.wang
 * @Description web
 */
@Configuration
//@Import(value = {BizConfig.class})
@ComponentScan(basePackageClasses = {AdminController.class})
//@EnableWebMvc
public class WebConfig {
    private static final Logger log = LoggerFactory.getLogger(WebConfig.class);

    @Bean
    public Map<Long, String> idMapName() {
        Map<Long, String> map = new HashMap<>();

        map.put(3L, "A");
        map.put(4L, "B");

        log.info("test;idMapName={};", map);
        return map;
    }

}
