package org.yunxiangxianlu.common.dto.res;

import lombok.Data;

@Data
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    private String date;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setData(data);
        result.setMessage("成功");
        result.setDate(String.valueOf(System.currentTimeMillis()));
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage(message);
        result.setDate(String.valueOf(System.currentTimeMillis()));
        return result;
    }

    public static <T> Result<T> error(Integer code, String message) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setDate(String.valueOf(System.currentTimeMillis()));
        return result;
    }
}
