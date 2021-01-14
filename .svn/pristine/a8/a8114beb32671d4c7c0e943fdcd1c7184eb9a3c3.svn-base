package com.newcloud.waf.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShyyMd5Util {
	
	/**
     * SHA-1加密
     */
    public static String getSHA(String sha){
    	try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.reset();
			md.update(sha.getBytes());
			byte[] result = md.digest();
			StringBuffer sb = new StringBuffer();
			int LEN = result.length;
			for (int i = 0; i < LEN; i++) {
				int v = result[i] & 0xFF;
				if (v < 16) {
					sb.append("0");
				}
				sb.append(Integer.toString(v, 16).toLowerCase());
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
    }
    
    /**
     * MD5加密
     * 
     * @param sha
     * @return
     */
    public static String getMD5(String md5){
    	try {
	    	MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(md5.getBytes());
			byte[] result = md.digest();
			StringBuffer sb = new StringBuffer();
			int LEN = result.length;
			for (int i = 0; i < LEN; i++) {
				int v = result[i] & 0xFF;
				if (v < 16) {
					sb.append("0");
				}
				sb.append(Integer.toString(v, 16).toLowerCase());
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
    }

}
