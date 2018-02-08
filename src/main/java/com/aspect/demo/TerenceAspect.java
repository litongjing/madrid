//package com.aspect.demo;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
///**
// * @Author:LiTongjing
// * @Description:
// * @Date:Create by 下午6:21 2018/1/21
// */
//@Component
//@Aspect
//public class TerenceAspect {
//    /**
//     * @Pointcut("execution(* com.terence.aop.aspectjbiz.*Biz.**(..))")
//     * 表示包com.terence.aop.aspectjbiz下任何以Biz结尾的方法都将被执行。
//     */
//    @Pointcut("execution(*com.controller.demoController.*sleep.**(..))")
//    public void pointcut() {
//    }
//
//    ;
//
//    /**
//     * @Pointcut("within(com.terence.aop.aspectj.biz.*)") 表示当前com.terence.aop.aspectj.biz
//     * 包下的任何类都会匹配给这个方法。
//     */
//    @Pointcut("within(com.controller.*)")
//    public void bizPointcut() {
//    }
//
//    /**
//     * 上述tradingOperation（）的组合表达式，
//     * 表示同时执行@Pointcut("execution(public * (..))")
//     * 和@Pointcut("within(com.xyz.someapp.trading..)")。
//     */
//    @Pointcut("pointcut()&& bizPointcut()")
//    private void tradingOperation() {
//    }
//
//
//    //@Before("executuion(*com.terence.aop.aspectj.biz.*Biz.*(..))")
//    @Before("pointcut()")
//    public void before() {
//        System.out.println("Before");
//    }
//
//    @AfterReturning(pointcut = "bizPointcut()", returning = "returnValue")
//    public void afterReturning(Object returnValue) {
//        System.out.println("AfterReturning:" + returnValue);
//    }
//
//    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
//    public void afterThrowing(RuntimeException e) {
//        System.out.println("AfterThrowing:" + e.getMessage());
//        System.out.println("AfterThrowing:" + e);
//    }
//
//    @After("pointcut()")
//    public void after() {
//        System.out.println("After");
//    }
//
//    @Around("pointcut()")
//    public Object around(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("Around 1");
//        Object obj = pjp.proceed();
//        System.out.println("Around 2");
//        return obj;
//    }
//
//    @Before("pointcut()&&args(arg)")
//    public void beforeWithParam(String arg) {
//        System.out.println("Before Param:" + arg);
//    }
//
////    @Before("pointcut()&&@annotation(terenceMethod)")
////    public void beforeWithAnnotation(TerenceMethodterenceMethod)
////    {System.out.println("beforeWithAnnotation:"+terenceMethod.value()); }
//}
