package com.interceptor;

//import lombok.extern.slf4j.Slf4j;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * Created by wzy on 2017/7/11.
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
                RowBounds.class, ResultHandler.class }) })
@Slf4j
public class SQLTimeInterceptor implements Interceptor {

//    private Logger log = Logger.getLogger(SQLTimeInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        Object result = null;
        if (target instanceof Executor) {
            long start = System.currentTimeMillis();
            Method method = invocation.getMethod();
            /**执行方法*/
            result = invocation.proceed();
            long end = System.currentTimeMillis();
            log.info("[SQLTimeInterceptor] execute [" + method.getName() + "] cost [" + (end - start) + "] ms");
        }
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
