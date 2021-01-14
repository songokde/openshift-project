package com.newcloud.waf.util;

public class ShyyOrderUtil {
	
	/**
	 * 根据支付订单编号获取编号
	 * 
	 * @param payNumber
	 * @return
	 */
	public static Long getPayNumber(String payNumber) {
		try {
			String[] strs = payNumber.split("-");
			if(strs.length==4) {
				return Long.valueOf(strs[3]);
			}
		}catch (Exception e) {
		}
		return 0L;
	}

}
