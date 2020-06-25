package com.wjt.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time 2020/1/31/17:46
 * @Author jintao.wang
 * @Description
 */
@Configuration
@Import(value = {DaoConfig.class})
public class ServiceConfig {
    private static final Logger log = LoggerFactory.getLogger(ServiceConfig.class);

    @Bean
    public Map<String, String> keyMapName() {

        Map<String, String> keyMapName = new HashMap<>();

        keyMapName.put("computer", "macbookpro");
        keyMapName.put("os", "macos");
        log.info("test;keyMapName={};", keyMapName);
        return keyMapName;
    }

}
