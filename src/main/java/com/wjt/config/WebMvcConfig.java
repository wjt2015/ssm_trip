package com.wjt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.MyDelegatingWebMvcConfiguration;

/**
 * (https://www.bilibili.com/video/av56616279?p=5);
 * @Time 2020/1/31/17:47
 * @Author jintao.wang
 * @Description
 */
@Configuration
@Import(value = {WebConfig.class, MyDelegatingWebMvcConfiguration.class})
public class WebMvcConfig {
}
