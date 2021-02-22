package com.fh.shop_behind.common.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration //声明是配置类
public class InterceptorsConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new TestInterceptors());
        //设置拦截的路径
        registration.addPathPatterns("/**");//所有路径都被拦截
        //设置不拦截的路径
        //registration.excludePathPatterns("/user");


        //注册跨域的拦截器
        InterceptorRegistration kuayu = registry.addInterceptor(new KuaYuInterceptors());
        //设置拦截路径
        kuayu.addPathPatterns("/**");//拦截所有请求

    }

}
