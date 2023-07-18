package net.gichain.genergy.eam.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {
    // controller.*.*(..)表示controller包下面所有类的所有方法
    private final String POINT_CUT = "execution(public * net.gichain.genergy.eam.admin.controller.*.*(..))";

    @Pointcut(POINT_CUT)
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        log.info("请求IP：" + request.getRemoteAddr());
        log.info("请求地址：" + request.getRequestURL().toString());
        log.info("请求方法：" + request.getMethod());
        log.info("请求类方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "result", pointcut = "logPointCut()")
    public void doAfterReturning(Object result) throws Throwable {
        log.info("响应值 : " + result);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long endTime = System.currentTimeMillis();
        log.info("请求耗时：" + (endTime - beginTime) + "毫秒");
        return result;
    }
}
