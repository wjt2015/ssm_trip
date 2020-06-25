package com.wjt.filter;

import com.wjt.web.MyResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

/**
 * @Time 2020/4/24/16:48
 * @Author jintao.wang
 * @Description
 */
@Slf4j
public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        ApplicationContext rootCtx = (ApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        log.info("rootCtx={};", rootCtx);

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final long start = System.currentTimeMillis();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        //怎么判断有没有session;
        HttpSession session = httpServletRequest.getSession();
        log.info("session={};", session);

        chain.doFilter(httpServletRequest,httpServletResponse);

/*        MyResponseWrapper myResponseWrapper = new MyResponseWrapper(httpServletResponse);
        chain.doFilter(request, myResponseWrapper);
        showHeaderData(httpServletRequest, myResponseWrapper);
        showResponseData(myResponseWrapper);*/

        log.info("request_url={};elapsed={}ms;", httpServletRequest.getRequestURL(), (System.currentTimeMillis() - start));

/*        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies == null) {
            httpServletResponse.getWriter().println("请先登录!");
            return;
        }
        String userName = null, password = null, loginTimestamp = null;
        for (Cookie cookie : cookies) {
            if (Constants.USER_NAME.equals(cookie.getName())) {
                userName = cookie.getValue();
            } else if (Constants.USER_PASS_WORD.equals(cookie.getName())) {
                password = cookie.getValue();
            } else if (Constants.USER_LOGIN_TIMESTAMP.equals(cookie.getName())) {
                loginTimestamp = cookie.getValue();
            }
        }
        log.info("userName={};password={};loginTimestamp={};", userName, password, loginTimestamp);

        //验证通过;
        if (checkAuth(userName, password, loginTimestamp)) {
            chain.doFilter(request, response);
        } else {
            httpServletResponse.getWriter().println("请先登录!");
        }*/
    }

    @Override
    public void destroy() {

    }

    private boolean checkAuth(String userName, String password, String loginTimestamp) {
        if (Strings.isNotEmpty(userName) || Strings.isNotEmpty(password) || Strings.isNotEmpty(loginTimestamp)) {
            return false;
        }
        return true;
    }


    private void showHeaderData(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("httpServletRequest={};httpServletResponse={};", httpServletRequest, httpServletResponse);
        Collection<String> headerNames = httpServletResponse.getHeaderNames();
        log.info("resp_headerNames={};", headerNames);
        if (headerNames != null) {
            headerNames.forEach(headerName -> {
                Collection<String> headerValues = httpServletResponse.getHeaders(headerName);
                log.info("headerName={};headerValues={};", headerName, headerValues);
            });
        }
        log.info("---------resp_headerNames_finish!---------");
    }

    private void showResponseData(MyResponseWrapper myResponseWrapper) {
        byte[] bytes = myResponseWrapper.getBytes();
        String content = new String(bytes);
        log.info("resp_body_bytes.length={};\ncontent={};", bytes.length, content);
    }

}
