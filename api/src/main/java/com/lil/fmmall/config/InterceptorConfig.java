package com.lil.fmmall.config;

import com.lil.fmmall.Interceptor.CheckTokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Lil
 * @date 2022/01/23 16:37
 **/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    CheckTokenInterceptor checkTokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkTokenInterceptor)
                .addPathPatterns("/shopcart/**")
                .addPathPatterns("/order/**")
                .excludePathPatterns("/user/**");
    }
}