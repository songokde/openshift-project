package com.newcloud.waf.storage.sessionFactory;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
* 动态数据源（需要继承AbstractRoutingDataSource）
* 作用：使用DatabaseContextHolder获取当前线程的DatabaseType
*/
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		 return DatabaseContextHolder.getCustomerType();  
	}

}
