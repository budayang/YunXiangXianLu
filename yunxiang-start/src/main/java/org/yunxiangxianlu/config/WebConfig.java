package org.yunxiangxianlu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.yunxiangxianlu.interceptor.AuthInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册认证拦截器
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/api/**") // 拦截所有API请求
                .excludePathPatterns( // 排除不需要认证的路径
                        "/api/auth/login",
                        "/api/auth/register",
                        "/api/auth/refresh"
                );
    }
}
