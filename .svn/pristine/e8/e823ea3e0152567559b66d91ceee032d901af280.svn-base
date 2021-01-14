package com.newcloud.waf.cache;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

/**
 * SESSION缓存器
 * 
 * @author Administrator
 *
 */
public class HttpSessionCache {
	/**
	 * 当前在线SESSION
	 */
	private static Map<String, HttpSession> ONLINEMAP = new ConcurrentHashMap<String, HttpSession>();
	
	/**
	 * 本系统是SESSION
	 * key		sessionID
	 * value 	session对象
	 */
	private static Map <String, HttpSession> SESSIONMAP = Collections.synchronizedMap(new HashMap<String, HttpSession>());
	
	/**
	 * 子系统对应的子系统SESISON
	 * key		主系统的sessionID
	 * value	本系统的sessionID
	 */
	private static Map <String,String> sessionLink = Collections.synchronizedMap(new HashMap<String, String>());
	
	/**
	 * 判断本系统当前session是否存在
	 * 
	 * @param localSessionId
	 * @return
	 */
	public static boolean getLocalSession(String localSessionId){
		return SESSIONMAP.containsKey(localSessionId);
	}
	
	/**
	 * 缓存本系统是SESSION
	 * 
	 * @param localSessionId
	 * @param localSession
	 */
	public static void setLocalSession(String localSessionId,HttpSession localSession){
		 SESSIONMAP.put(localSessionId, localSession);
	}
	
	/**
	 * 注销或过期时，移除本系统的session
	 * 
	 * @param localSessionId
	 * @return
	 */
	public static HttpSession removeSession(String localSessionId){
		ONLINEMAP.remove(localSessionId);
		return SESSIONMAP.remove(localSessionId);
	}
	
	/**
	 * 根据主系统获取子系统的sessionID
	 * 
	 * @param allSessionId
	 * @return
	 */
	public static String getLocalSessionId(String allSessionId){
		return sessionLink.get(allSessionId);
	}
	
	/**
	 * 添加主系统和子系统的关联
	 * 
	 * @param allSessionId
	 * @param localSessionId
	 */
	public static void setLink(String allSessionId,String localSessionId){
		sessionLink.put(allSessionId, localSessionId);
	}
	
	/**
	 * 系统主动退出移除主系统和子系统关联
	 * 
	 * @param allSessionId
	 * @return
	 */
	public static String removeLink(String allSessionId){
		return sessionLink.remove(allSessionId);
	}
	
	/**
	 * 子系统session过期移除关联
	 * 
	 * @param localSessionId
	 */
	public static void removeLocalLink(String localSessionId) {
		Set<String> set = null;
		for(Map.Entry<String,String> entry:sessionLink.entrySet()) {
			if(entry.getValue().equals(localSessionId)) {
				if(set==null) {
					set = new HashSet<>();
				}
				set.add(entry.getKey());
			}
		}
		if(set!=null) {
			for(String token:set) {
				sessionLink.remove(token);
			}
		}
	}
	
	/**
	 * 放入在线用户
	 * 
	 * @param session
	 */
	public static void putOnlieMap(HttpSession session) {
		ONLINEMAP.put(session.getId(), session);
	}
	
	/**
	 * 在线人数
	 * 
	 * @return
	 */
	public static int getOnlieSize() {
		return ONLINEMAP.size();
	}
}
