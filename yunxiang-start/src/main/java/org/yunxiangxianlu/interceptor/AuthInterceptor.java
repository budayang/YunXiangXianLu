package org.yunxiangxianlu.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.yunxiangxianlu.common.util.JwtUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 允许跨域请求
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        // 处理OPTIONS请求
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return false;
        }

        // 获取令牌
        String authorizationHeader = request.getHeader("Authorization");

        // 检查令牌是否存在且格式正确
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "未提供有效的令牌");
            return false;
        }

        // 提取令牌
        String token = authorizationHeader.substring(7);

        // 验证令牌
        if (!jwtUtils.validateToken(token)) {
            sendErrorResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "令牌无效或已过期");
            return false;
        }

        return true;
    }

    // 发送错误响应
    private void sendErrorResponse(HttpServletResponse response, int status, String message) throws Exception {
        response.setStatus(status);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write("{\"code\":" + status + ",\"message\":\"" + message + "\"}");
        writer.flush();
        writer.close();
    }
}
