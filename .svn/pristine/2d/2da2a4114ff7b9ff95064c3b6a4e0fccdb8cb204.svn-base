package com.newcloud.waf.storage.dao.util;

import java.text.DecimalFormat;

public class ShyyDataUtil {
	
	/**
	 * 日志分析TOPurl
	 * 
	 * @param custId
	 * @return
	 */
	public static Long getCustLogRatio(int custId){
		switch (custId) {
			default:
				return 900000L;
		}
	}
	
	/**
	 * 获取客户的带宽系数
	 * 
	 * @param custId
	 * @param rate
	 * @return
	 */
	public static String getBandwidthRate(int custId,long rate){
		switch (custId) {
			default:
				return rate+"";
		}
	}
	
	
	/**
	 * 获取客户的带宽系数(日志对比库)
	 * 
	 * @param custId
	 * @param rate
	 * @return
	 */
	public static String getLogBandwidthRate(int custId,long rate){
		switch (custId) {
			default:
				return rate+"";
		}
	}
	
	
	/**
	 * 获取客户的带宽系数
	 * 
	 * @param custId
	 * @param rate
	 * @return
	 */
	public static String getIdcBandwidthRate(int custId,long rate){
		switch (custId) {
			default:
				return rate+"";
		}
	}
	
	
	/**
	 * 获取客户数据库
	 * @param customerID
	 * @return
	 */
	public static String formatLabID(int labId) {
        DecimalFormat df = new DecimalFormat("waf00000000");
        return df.format(labId);
    }
	
	/**
	 * 获取客户数据库
	 * @param customerID
	 * @return
	 */
	public static String formatCustomerID(int customerID) {
        DecimalFormat df = new DecimalFormat("waf00000000");
        return df.format(customerID);
    }
	
	/**
	 * 获取客户数据库
	 * @param customerID
	 * @return
	 */
	public static String formatCustomerID(String name,int customerID) {
        DecimalFormat df = new DecimalFormat("00000000");
        return name+df.format(customerID);
    }
	
}
