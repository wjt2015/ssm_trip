package com.wjt.web;

import com.wjt.model.ContentSaveRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Time 2020/4/6/20:10
 * @Author jintao.wang
 * @Description
 */
@Slf4j
@RestController
public class ContentController {
    @RequestMapping(value = {"/save.json"},
            method = {RequestMethod.POST},
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ApiResult save(@RequestBody ContentSaveRequest contentSaveRequest) {

        log.info("contentSaveRequest={};", contentSaveRequest);

        return new ApiResult(0, ApiResult.SUCCESS, "success");
    }

}
