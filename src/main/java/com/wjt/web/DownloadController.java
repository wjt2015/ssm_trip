package com.wjt.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Time 2020/4/25/4:08
 * @Author jintao.wang
 * @Description
 */
@Slf4j
@RestController
public class DownloadController {

    private static final String RESOURCE_DIR = "D:\\projs\\data\\";

    @RequestMapping(value = {"/download.json"})
    public ApiResult download(@RequestParam("fileName") String fileName, HttpServletResponse httpServletResponse) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(RESOURCE_DIR + "\\" + fileName));
            httpServletResponse.getOutputStream().write(bytes);
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            log.info("data_size={};", bytes.length);
        } catch (IOException e) {
            log.error("An error occurs while copying data!fileName={};", fileName);
            return new ApiResult(1, fileName + "不可下载");
        }
        ApiResult apiResult = new ApiResult(0, fileName + "可下载");
        return apiResult;
    }

}
