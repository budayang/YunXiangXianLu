package org.yunxiangxianlu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
                .addPathPatterns("/**") // 拦截所有API请求
                .excludePathPatterns( // 排除不需要认证的路径
                        "/auth/login",
                        "/auth/register",
                        "/auth/refresh",
                        "/image/images/**"
                );
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                // 配置静态资源路径，使上传的图片可以通过URL访问
                registry.addResourceHandler("/images/**")
                        .addResourceLocations("file:./uploads/");
            }
        };
    }
}
