package org.yunxiangxianlu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * 日志切面，用于记录接口的入参、出参和执行时间
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    private static final String TRACE_ID = "traceId"; // 定义traceId的键名

    /**
     * 定义切入点：拦截所有Controller层的public方法
     * 可根据实际项目包路径调整表达式
     */
    @Pointcut("execution(public * org.yunxiangxianlu.web.controller..*.*(..))")
    public void logPointCut() {}

    /**
     * 前置通知：生成或获取traceId，打印请求参数
     */
    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        // 生成或获取traceId
        String traceId = generateTraceId();
        MDC.put(TRACE_ID, traceId);

        // 获取请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();

            // 打印请求基本信息（包含traceId）
            logger.info("【请求开始】==========================================");
            logger.info("traceId: {}", traceId);
            logger.info("请求URL: {}", request.getRequestURL().toString());
            logger.info("请求方法: {}", request.getMethod());
            logger.info("请求IP: {}", request.getRemoteAddr());
            logger.info("请求类方法: {}.{}", joinPoint.getSignature().getDeclaringTypeName(),
                    joinPoint.getSignature().getName());

            // 打印请求参数
            logger.info("请求参数: {}", Arrays.toString(joinPoint.getArgs()));
        }
    }

    /**
     * 环绕通知：记录方法执行时间
     */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = proceedingJoinPoint.proceed();

        // 计算执行时间
        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("方法执行时间: {}ms", executionTime);

        return result;
    }

    /**
     * 后置通知：打印返回结果
     */
    @AfterReturning(returning = "result", pointcut = "logPointCut()")
    public void doAfterReturning(Object result) {
        logger.info("返回结果: {}", result);
        logger.info("【请求结束】==========================================\n");
        // 清除MDC中的traceId，避免线程复用导致的问题
        MDC.remove(TRACE_ID);
    }

    /**
     * 异常通知：打印异常信息
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "error")
    public void doAfterThrowing(Throwable error) {
        logger.error("【请求异常】==========================================", error);
        logger.error("异常信息: {}", error.getMessage());
        logger.error("【异常结束】==========================================\n");
        // 清除MDC中的traceId
        MDC.remove(TRACE_ID);
    }

    /**
     * 生成或获取traceId
     * 优先从请求头获取（适用于分布式系统，上游服务传递），否则生成新的
     */
    private String generateTraceId() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            // 从请求头获取traceId（如果有上游服务传递）
            String traceId = request.getHeader(TRACE_ID);
            if (traceId != null && !traceId.isEmpty()) {
                return traceId;
            }
        }
        // 生成新的traceId（UUID去掉横线）
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
