package com.newcloud.waf.storage.sessionFactory;

import org.aspectj.lang.ProceedingJoinPoint;

public class DataSourceInterceptor {
	
	public Object changeDB(ProceedingJoinPoint pjp) throws Throwable {  
        String path = pjp.getTarget().getClass().getName();
        if (path.startsWith("com.newcloud.waf.service.impl.")){
        	DatabaseContextHolder.setCustomerType("dataSourceWaf");
        }else if (path.startsWith("com.newcloud.waf.service.info.")){
        	DatabaseContextHolder.setCustomerType("dataSourceInfo");
        }
        return pjp.proceed();  
    }

}
