package com.wjt.web;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Time 2020/3/20/12:54
 * @Author jintao.wang
 * @Description
 */
@Controller
public class AdminController {

    private static final Logger log = LoggerFactory.getLogger(AdminController.class);

    @Resource
    private Map<Long, String> map;

    @RequestMapping(value = {"/admins.json"}, method = {RequestMethod.GET})
    @ResponseBody
    public ApiResult admins() {

        log.info("test;map={};", map);

        ApiResult apiResult = new ApiResult(0, "succ", Lists.newArrayList(1L, 2L, 3L));

        log.info("test;apiResult={};", apiResult);

        return apiResult;
    }



}
