package org.yunxiangxianlu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yunxiangxianlu.biz.UserBiz;
import org.yunxiangxianlu.common.dto.req.LoginReq;
import org.yunxiangxianlu.common.dto.req.RegisterReq;
import org.yunxiangxianlu.common.dto.res.Result;
import org.yunxiangxianlu.common.exception.BusinessException;
import org.yunxiangxianlu.common.util.JwtUtils;
import org.yunxiangxianlu.dal.entity.UserDO;

import java.util.HashMap;
import java.util.Map;

import static org.yunxiangxianlu.common.exception.ErrorCode.*;

@RequestMapping("/auth")
@RestController
public class AuthController {

    @Autowired
    private UserBiz userBiz;

    @Autowired
    private JwtUtils jwtUtils;

    // 密码加密器
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public Result<String> register(@RequestBody RegisterReq req) {
        // 检查用户名是否已存在
        if (userBiz.existsByUsername(req.getUsername())) {
            throw new BusinessException(USER_ALREADY_EXISTS);
        }
        // 密码加密
        req.setPassword(passwordEncoder.encode(req.getPassword()));
        // 保存用户
        userBiz.save(req.getUsername(), req.getPassword(),req.getPhone(), req.getAvatar());
        return Result.success("注册成功");
    }

    /**
     * 用户登录
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginReq req) {
        String username = req.getUsername();
        String password = req.getPassword();

        // 查找用户
        UserDO user = userBiz.findByUsername(username);
        if (user == null) {
            throw new BusinessException(USER_NOT_REGISTERED);
        }

        // 验证密码
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BusinessException(USERNAME_OR_PASSWORD_ERROR);
        }

        // 检查用户是否启用
        if (user.getStatus() == 1) {
            throw new BusinessException(USER_DISABLED);
        }

        // 生成令牌
        String accessToken = jwtUtils.generateAccessToken(username);
        String refreshToken = jwtUtils.generateRefreshToken(username);

        // 构建返回结果
        Map<String, String> tokens = new HashMap<>();
        tokens.put("accessToken", accessToken);
        tokens.put("refreshToken", refreshToken);
        tokens.put("username", username);
        tokens.put("avatar", user.getAvatar());

        return Result.success(tokens);
    }

    /**
     * 刷新令牌
     */
    @PostMapping("/refresh")
    public Result<?> refreshToken(@RequestBody Map<String, String> refreshData) {
        String refreshToken = refreshData.get("refreshToken");

        if (refreshToken == null || !jwtUtils.validateToken(refreshToken)) {
            throw new BusinessException(INVALID_REFRESH_TOKEN);
        }

        // 从刷新令牌中获取用户名
        String username = jwtUtils.getUsernameFromToken(refreshToken);

        // 生成新的访问令牌
        String newAccessToken = jwtUtils.generateAccessToken(username);

        Map<String, String> result = new HashMap<>();
        result.put("accessToken", newAccessToken);

        return Result.success(result);
    }
}
