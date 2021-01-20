package com.example.demo.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Order(-100)
@Aspect
@Component
@Slf4j
public class DataSourceAspect {
	/**
	 * 切点，根据注解使用的地方
	 */
    @Pointcut("@annotation(com.example.demo.common.DataSource)")
    public void dataSourcePointCut() {

    }
	/**
	 * 注入数据源
	 * @param point
	 * @return
	 * @throws Throwable
	 */
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource ds = method.getAnnotation(DataSource.class);
        if (ds == null) {
            DynamicDataSource.setDataSource(DataSourceName.master);
        } else {
            DynamicDataSource.setDataSource(ds.name());
        }
        log.info("当前使用的数据源："+ds.name());
        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }

}
