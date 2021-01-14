package com.newcloud.waf.storage.sessionFactory;


/**
* 作用：
* 1、保存一个线程安全的DatabaseType容器
* 作用：构建一个DatabaseType容器，并提供了向其中设置和获取DatabaseType的方法
 */

public class DatabaseContextHolder {
	
	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();  
	  
    public static void setCustomerType(String customerType) {  
        contextHolder.set(customerType);  
    }  
  
    public static String getCustomerType() {  
        return contextHolder.get();  
    }  
  
    public static void clearCustomerType() {  
        contextHolder.remove();  
    }  

}
