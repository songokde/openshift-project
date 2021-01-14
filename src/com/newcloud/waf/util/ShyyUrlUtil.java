package com.newcloud.waf.util;

import java.net.URL;

public class ShyyUrlUtil {
	
	/**
	 * 截取URL
	 * 
	 * @param type
	 * @param url
	 * @return
	 */
	public static String getPath(Short type,String url){
		try{
			int t = url.indexOf("://") + 3;
			String uri = url.substring(t, url.length());
			int tdir = uri.indexOf("/");
			return uri.substring(tdir,uri.length())+(type.intValue()==0?"*":"");
		}catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 获取URI
	 * 
	 * @param httpurl
	 * @return
	 */
	public static String getUri(String httpurl) {
		try {
			URL url = new URL(httpurl);
			return url.getPath();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取日志连接中的日期
	 * 
	 * @param url
	 * @return
	 */
	public static String getUrlDate(String url) {
		
		
		return "";
	}

}
