package com.unicorn.configuration;

import com.unicorn.interceptor.LoginRequiredInterceptor;
import com.unicorn.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class ProWebConfiguration implements WebMvcConfigurer{

    @Autowired
    PassportInterceptor passportInterceptor;

    @Autowired
    LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(passportInterceptor);
     //   registry.addInterceptor(loginRequiredInterceptor).addPathPatterns("/test*");

    }
}
