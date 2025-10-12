package org.yunxiangxianlu.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 系统通用错误
    SUCCESS("00000", "成功"),
    SYSTEM_ERROR("10000", "系统错误"),
    PARAM_VALIDATION_ERROR("10001", "参数校验错误"),
    RESOURCE_NOT_FOUND("10002", "资源不存在"),

    // 业务相关错误
    USER_NOT_FOUND("20001", "用户不存在"),
    USER_ALREADY_EXISTS("20002", "用户已存在"),
    PERMISSION_DENIED("20003", "权限不足"),
    USER_NOT_REGISTERED("20004", "用户未注册"),
    USERNAME_OR_PASSWORD_ERROR("20005", "用户名或密码错误"),
    USER_DISABLED("20006", "用户已禁用"),
    INVALID_REFRESH_TOKEN("20007", "无效的刷新令牌"),
    // 请选择要上传的文件
    FILE_NOT_SELECTED("30001", "请选择要上传的文件"),
    // 只支持图片文件上传
    FILE_TYPE_NOT_SUPPORTED("30002", "只支持图片文件上传"),
    // 图片上传失败
    FILE_UPLOAD_FAILED("30003", "图片上传失败"),
    ;

    private final String code;
    private final String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
