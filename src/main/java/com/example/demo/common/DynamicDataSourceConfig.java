package com.example.demo.common;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;


@Configuration
public class DynamicDataSourceConfig {
	
	@Bean
	@ConfigurationProperties("spring.datasource.druid.master")
	public DruidDataSource MasterDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
	@ConfigurationProperties("spring.datasource.druid.slave")
	public DruidDataSource SlaveDataSource() {
		return DruidDataSourceBuilder.create().build();
	}
	
	@Bean
    @Primary
    public DynamicDataSource dataSource(DruidDataSource MasterDataSource,DruidDataSource SlaveDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceName.master, MasterDataSource);
        targetDataSources.put(DataSourceName.slave, SlaveDataSource);
        return new DynamicDataSource(MasterDataSource, targetDataSources);
    }
}
