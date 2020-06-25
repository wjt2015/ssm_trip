package com.wjt.main;

import com.wjt.config.BizConfig;
import com.wjt.config.WebMvcConfig;
import com.wjt.filter.AuthFilter;
import com.wjt.filter.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.MyContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @Time 2020/1/31/16:59
 * @Author jintao.wang
 * @Description
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    private static final Logger log = LoggerFactory.getLogger(MyWebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("test;start to initialize!");
        long start = System.currentTimeMillis();

        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.register(WebMvcConfig.class);

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(BizConfig.class);
        //webContext.setParent(rootContext);

        MyContextLoaderListener contextLoaderListener = new MyContextLoaderListener(rootContext);
        servletContext.addListener(contextLoaderListener);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("utf-8", true);
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);

        FilterRegistration.Dynamic crossOriginFilter = servletContext.addFilter("crossOriginFilter", new CrossOriginFilter());
        crossOriginFilter.addMappingForUrlPatterns(null, false, "/*");

        FilterRegistration.Dynamic authFilter = servletContext.addFilter("authFilter", new AuthFilter());
        authFilter.addMappingForUrlPatterns(null, false, "/*");


        //MyDispatcherServlet dispatcherServlet = new MyDispatcherServlet(webContext);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(webContext);
        ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcherServlet", dispatcherServlet);
        servletRegistration.addMapping("/*");
        servletRegistration.setLoadOnStartup(1);


        long elapsed = System.currentTimeMillis() - start;
        log.info("test;initialization finish!elapsed={}ms;", elapsed);
    }
}
