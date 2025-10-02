package org.yunxiangxianlu.common.dto.res;

import lombok.Data;
import org.yunxiangxianlu.common.exception.ErrorCode;

@Data
public class Result<T> {

    private String code;

    private String message;

    private String traceId;

    private T data;

    private String date;

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setData(null);
        result.setMessage("成功");
        result.setDate(String.valueOf(System.currentTimeMillis()));
        return result;
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode("200");
        result.setData(data);
        result.setMessage("成功");
        result.setDate(String.valueOf(System.currentTimeMillis()));
        return result;
    }

    public static <T> Result<T> error(String code, String message, String traceId) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setDate(String.valueOf(System.currentTimeMillis()));
        result.setTraceId(traceId);
        return result;
    }

    public static <T> Result<T> error(ErrorCode errorCode, String traceId, T data) {
        Result<T> result = new Result<>();
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        result.setDate(String.valueOf(System.currentTimeMillis()));
        result.setTraceId(traceId);
        result.setData(data);
        return result;
    }

    public static <T> Result<T> error(ErrorCode errorCode, String traceId) {
        Result<T> result = new Result<>();
        result.setCode(errorCode.getCode());
        result.setMessage(errorCode.getMessage());
        result.setDate(String.valueOf(System.currentTimeMillis()));
        result.setTraceId(traceId);
        return result;
    }

}
