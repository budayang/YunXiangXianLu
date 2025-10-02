package org.yunxiangxianlu.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yunxiangxianlu.common.dto.res.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * 统一处理系统中的所有异常，返回标准化的错误响应
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result handleBusinessException(BusinessException e) {
        // 记录业务异常日志（级别为warn，因为是预期内的异常）
        logger.warn("业务异常: {}", e.getMessage(), e);

        // 返回包含错误信息和traceId的响应
        String traceId = MDC.get("traceId");
        MDC.remove("traceId");
        return Result.error(e.getErrorCode(), e.getMessage(), traceId);
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result handleValidationException(MethodArgumentNotValidException e) {
        // 收集所有字段验证错误
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        logger.warn("参数校验异常: {}", errors, e);
        String traceId = MDC.get("traceId");
        MDC.remove("traceId");
        return Result.error(ErrorCode.PARAM_VALIDATION_ERROR, traceId, errors);
    }

    /**
     * 处理其他未捕获的异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result handleGenericException(Exception e) {
        // 记录未预期的异常（级别为error）
        logger.error("系统异常: {}", e.getMessage(), e);

        // 生产环境返回友好提示，不暴露具体异常信息
        String message = "系统繁忙，请稍后再试";
        String traceId = MDC.get("traceId");
        MDC.remove("traceId");
        return Result.error(
                ErrorCode.SYSTEM_ERROR,
                message,
                traceId
        );
    }
}
