package com.newcloud.waf.mail;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;



public class SendMailUtil {

	/**
	 * 发送HTML邮件
	 * 
	 * @param title
	 * @param content
	 * @param address
	 * @return
	 */
	public static boolean sendHtmlMail(String title,String content,String address){
		EmailModel mailModel = new EmailModel(title,content,address);
		SendMail sendMail = new SendMail();
		return sendMail.sendHtmlMail(mailModel);
	}
	
	/**
	 * 发送HTML邮件,带抄送
	 * 
	 * @param title
	 * @param content
	 * @param address
	 * @return
	 */
	public static boolean sendHtmlMail(String title,String content,String address,String copyAddress){
		EmailModel mailModel = new EmailModel(title,content,address,copyAddress);
		SendMail sendMail = new SendMail();
		return sendMail.sendHtmlMail(mailModel);
	}
	
	/**
	 * 发送带重试的邮件
	 * 
	 * @param title
	 * @param content
	 * @param address
	 * @param copyAddress
	 * @return
	 */
	public static boolean sendRetryHtmlMail(String title,String content,String address,String copyAddress){
		EmailModel mailModel = null;
		if(StringUtils.isEmpty(copyAddress)){
			mailModel = new EmailModel(title,content,address);
		}else{
			mailModel = new EmailModel(title,content,address,copyAddress);
		}
		SendMail sendMail = new SendMail();
		String result = sendMail.sendRetryHtmlMail(mailModel);
		if(result.equals("OK")){
			return true;
		}else if(result.equals("ERROR")){
			return false;
		}else{
			Set<String> allAdd = new HashSet<String>();
			for(String add:address.split(",")){
				allAdd.add(add);
			}
			if(!StringUtils.isEmpty(copyAddress)){
				for(String add:copyAddress.split(",")){
					allAdd.add(add);
				}
			}
			for(String eAdd:result.split(",")){
				allAdd.remove(eAdd);
			}
			if(allAdd.size()>0){
				String newAdd = "";
				for(String add:allAdd){
					if(newAdd.length()==0){
						newAdd = add;
					}else{
						newAdd += ","+add;
					}
				}
				return sendHtmlMail(title,content,newAdd);
			}else{
				return false;
			}
		}
	}
}
