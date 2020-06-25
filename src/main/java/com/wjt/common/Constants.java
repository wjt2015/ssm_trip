package com.wjt.common;

import com.google.gson.Gson;
import okhttp3.MediaType;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Time 2020/2/12/17:32
 * @Author jintao.wang
 * @Description
 */
public interface Constants {
    MediaType JSON_MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    MediaType FORM_MEDIA_TYPE =
            MediaType.parse("application/x-www-form-urlencoded");
    MediaType PNG_MEDIA_TYPE = MediaType.parse("image/png; charset=utf-8");

    Gson GSON = new Gson();


    Random RANDOM = new Random();

    ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(30, 60, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.DiscardOldestPolicy());

    ScheduledThreadPoolExecutor SCHEDULED_THREAD_POOL_EXECUTOR = new ScheduledThreadPoolExecutor(5, new ThreadPoolExecutor.DiscardOldestPolicy());


    String USER_NAME = "USER_NAME";
    String USER_PASS_WORD = "USER_PASS_WORD";
    String USER_LOGIN_TIMESTAMP = "USER_LOGIN_TIMESTAMP";
    //登录cookie的生命期间,单位是秒;
    int LOGIN_COOKIE_LIFETIME = 100;

}
