package com.newcloud.waf.storage.sessionFactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 项目启动加载内，用于项目启动时加载一些数据到缓存或引用中
 * 
 * @author Fishwen
 *
 */
public class SytemStartLoadProcessor implements BeanPostProcessor{

	/**
	 * 在Bean对象加载后
	 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1)
			throws BeansException {
//		if(arg0 instanceof MonitorGlobalCache){
//			System.out.println("----system start load data----");
//			((MonitorGlobalCache) arg0).findAllCacheData();
//			System.out.println("----system end load data----");
//        } 
		return arg0;
	}

	/**
	 * 在Bean对象加载前
	 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1)
			throws BeansException {
		return arg0;
	}

}
