package com.aspect;

import com.annotation.DataSource;
import com.util.DataSourceHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by wzy on 2017/5/24.
 */
@Aspect
@Order(5)
@Slf4j
@Component
public class DataSourceAspect {

    @Before("execution(* com.manager..*.*(..))")
    public void before(JoinPoint point) {
        Object target = point.getTarget();
        String method = point.getSignature().getName();
        log.info("aop apply to {}", method);
        Class clazz = target.getClass();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())
                .getMethod().getParameterTypes();

        try {
            Method m = clazz.getMethod(method, parameterTypes);
            if (m != null && m.isAnnotationPresent(DataSource.class)) {
                DataSource data = m.getAnnotation(DataSource.class);
                DataSourceHolder.setDataSource(data.value());
                log.info("Current datasource is " + data.value());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
