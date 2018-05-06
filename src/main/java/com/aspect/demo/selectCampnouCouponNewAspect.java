package com.aspect.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Author:LiTongjing
 * @Description:
 * @Date:Create by 下午9:37 2018/5/6
 */
@Component
@Aspect
public class selectCampnouCouponNewAspect {
    @Pointcut(value = "execution(* com.manager.CouponManager.selectCampnouCouponNew(*))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before() {
        System.out.println("^^^^^^^^^^^^^^^^before");
    }

    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public void afterReturning(Object returnValue) {
        System.out.println("^^^^^^^^^^^^^^^^afterReturning:" + returnValue);
    }

    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowing(RuntimeException e) {
        System.out.println("^^^^^^^^^^^^^^^^AfterThrowing:" + e.getMessage());
        System.out.println("^^^^^^^^^^^^^^^^AfterThrowing:" + e);
    }

    @After("pointcut()")
    public void after() {
        System.out.println("^^^^^^^^^^^^^^^^After");
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("^^^^^^^^^^^^^^^^around");
        System.out.println("Around 1");
        Object obj = pjp.proceed();
        System.out.println("Around 2");
        System.out.println("^^^^^^^^^^^^^^^^around");
        return obj;

    }
}
