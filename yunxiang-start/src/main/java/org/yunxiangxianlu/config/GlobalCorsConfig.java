package org.yunxiangxianlu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class GlobalCorsConfig {

    /**
     * 配置全局跨域过滤器
     */
    @Bean
    public CorsFilter corsFilter() {
        // 1. 创建 CORS 配置对象
        CorsConfiguration config = new CorsConfiguration();

        // 允许的源（域名）：不能为 * 当 allowCredentials 为 true 时
        config.setAllowedOrigins(Arrays.asList(
                "http://localhost:8080",  // 前端开发地址
                "http://127.0.0.1:8080",
                "http://47.99.95.14:8080",
                "http://127.0.0.1:5173",
                "http://47.99.95.14:5173",
                "http://localhost:5173",
                "http://47.99.95.14/",
                "http://localhost/",
                "https://your-production-domain.com"  // 生产环境域名
        ));

        // 允许的请求方法（GET/POST 等）
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // 允许的请求头（* 表示允许所有）
        config.setAllowedHeaders(Arrays.asList("*"));

        // 是否允许携带认证信息（如 Cookie、Token）
        config.setAllowCredentials(true);

        // 预检请求的有效期（秒）：避免频繁发送 OPTIONS 请求
        config.setMaxAge(3600L);

        // 2. 配置生效的路径（/** 表示所有接口）
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        // 3. 返回过滤器
        return new CorsFilter(source);
    }

}
