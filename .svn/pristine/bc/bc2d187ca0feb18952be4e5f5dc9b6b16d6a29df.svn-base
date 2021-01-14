package com.newcloud.waf.web.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.newcloud.waf.storage.entity.info.InfoOperator;


public class SessionTimeoutInterceptor implements HandlerInterceptor {
	public String[] allowUrls;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		return true;
//		String requestUrl = arg0.getRequestURI().replace(arg0.getContextPath(), "");   
//        if(null != allowUrls && allowUrls.length>=1) {
//	        for(String url : allowUrls) {
//	        	if(requestUrl.equals(url)) {
//	        		return true;
//	        	}
//	        	if(url.endsWith("/") && requestUrl.startsWith(url)) {
//	        		return true;
//	        	}
//	        }
//        }
//        InfoOperator user = (InfoOperator) arg0.getSession().getAttribute("SESSION_USER");
//	    if(user != null) {
//	    	if(requestUrl.startsWith("/main;jsessionid=")) {
//	    		return true;
//	    	}
//			Set<String> events = (Set<String>) arg0.getSession().getAttribute("SESSION_EVENT");
//			if(requestUrl.indexOf(".")==-1 && !events.contains(requestUrl)) {
//				System.out.println(requestUrl);
//				if(arg0.getHeader("x-requested-with") != null && arg0.getHeader("x-requested-with").equals("XMLHttpRequest")){
//					arg1.setStatus(998);
//					return false;
//				}else{
//					throw new NotAuthorityException("当前无权操作,请重新申请!"); 
//				}
//			}
//			return true;
//        }else{
//			if(arg0.getHeader("x-requested-with") != null && arg0.getHeader("x-requested-with").equals("XMLHttpRequest")){
//				arg1.setStatus(999);
//				return false;
//			}else{
//				throw new SessionTimeoutException("当前登陆超时,请重新登陆!"); 
//			}
//        }
	}

	
	//-------------------- get and set ---------------------------
	
	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}
}
