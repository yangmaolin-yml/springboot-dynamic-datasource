package com.example.demo.common;

import java.util.Map;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import com.alibaba.druid.pool.DruidDataSource;



public class DynamicDataSource extends AbstractRoutingDataSource {
	/**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，
     * 所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
     */
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();
    /**
     * 设置默认数据源和其他数据源
     * @param defaultTargetDataSource
     * @param targetDataSources
     */
    public DynamicDataSource(DruidDataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
    /**
     * 设置数据源的变量
     */
    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }
    /**
     * 获得数据源的变量
     */
    public static String getDataSource() {
        return contextHolder.get();
    }
    /**
     * 清空数据源变量
     */
    public static void clearDataSource() {
        contextHolder.remove();
    }
}

