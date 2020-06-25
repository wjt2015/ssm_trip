package com.wjt.web;

/**
 * @Time 2020/4/6/20:14
 * @Author jintao.wang
 * @Description
 */
public class ApiResult {
    public final int code;
    public final String errMsg;
    public final Object data;

    public ApiResult(int code, String errMsg, Object data) {
        this.code = code;
        this.errMsg = errMsg;
        this.data = data;
    }

    public ApiResult(int code, Object data) {
        this.code = code;
        this.errMsg = (code == 0 ? SUCCESS : FAIL);
        this.data = data;
    }


    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
}