package com.newcloud.waf.util;

/**
 * 加密解密类
 * 
 */

public class ShyyPasswordUtil {
	
	/**
	 * 后台账号密码加密
	 * 
	 */
	public static String encrypt(String str, String key) {
		String md5String = ShyyMd5Util.getSHA(str);
		md5String = ShyyMd5Util.getMD5(md5String);
		String md5KeyString = ShyyMd5Util.getMD5(key);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < md5String.length(); i++) {
			if (i % 2 == 0)
				builder.append(md5String.charAt(i)).append(md5KeyString.charAt(i));
			else {
				builder.append(md5KeyString.charAt(i)).append(md5String.charAt(i));
			}
		}
		String newStr = builder.toString();
		return ShyyMd5Util.getMD5(newStr);
	}
	

}