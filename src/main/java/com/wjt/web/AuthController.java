package com.wjt.web;

import com.wjt.common.Constants;
import com.wjt.dao.LoginMapper;
import com.wjt.enums.AvailableType;
import com.wjt.model.LoginEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Time 2020/4/25/1:05
 * @Author jintao.wang
 * @Description
 */
@Slf4j
@RestController
public class AuthController {

    @Resource
    private LoginMapper loginMapper;

    @RequestMapping(value = "/login.json")
    public ApiResult login(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpServletResponse httpServletResponse) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.userName = userName;
        loginEntity.password = password;
        final long loginTs = loginEntity.loginTs = System.currentTimeMillis();
        int ret = loginMapper.insertSelective(loginEntity);
        log.info("ret={};loginEntity={};", ret, loginEntity);
        if (ret == 1) {
            //登录成功;
            Cookie cookie = new Cookie(Constants.USER_NAME, userName);
            cookie.setMaxAge(Constants.LOGIN_COOKIE_LIFETIME);
            httpServletResponse.addCookie(cookie);

            cookie = new Cookie(Constants.USER_PASS_WORD, password);
            cookie.setMaxAge(Constants.LOGIN_COOKIE_LIFETIME);
            httpServletResponse.addCookie(cookie);

            cookie = new Cookie(Constants.USER_LOGIN_TIMESTAMP, String.valueOf(loginTs));
            cookie.setMaxAge(Constants.LOGIN_COOKIE_LIFETIME);
            httpServletResponse.addCookie(cookie);
        }
        ApiResult apiResult = new ApiResult(0, loginEntity.id);
        log.info("loginEntity={};apiResult{};", loginEntity, apiResult);
        return apiResult;
    }

    @RequestMapping(value = "/logout.json")
    public ApiResult logout(@RequestParam("loginId") long loginId) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.id = loginId;
        loginEntity.available = AvailableType.NOT_AVAILABLE;
        int ret = loginMapper.updateByPrimaryKeySelective(loginEntity);
        log.info("ret={};loginEntity={};", ret, loginEntity);
        return new ApiResult(0, loginEntity.id + " logout!");
    }

}
