package com.wjt.common;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @Time 2020/2/25/17:16
 * @Author jintao.wang
 * @Description
 */
@Slf4j
public class AuxUtils {

    void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.error("The thread has been interrupted!",e);
        }
    }

}
