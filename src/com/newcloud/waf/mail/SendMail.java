package com.newcloud.waf.mail;

import java.util.List;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;


public class SendMail {
	
	/**
	 *  群发普通邮件,文本
	 */
	public boolean sendMail(EmailModel mailModel){
		try {
			SimpleEmail emails = new SimpleEmail();			
			emails.setCharset("UTF-8");
			emails.setHostName(mailModel.getMailHostName());
			emails.setAuthentication(mailModel.getMailPersonName(),mailModel.getMailPersonPassword());
			emails.setFrom(mailModel.getFromMailPersonAddress(),mailModel.getFromMailPersonName());
			List<String> list = mailModel.getToMailAddress();
			if( null != list && list.size() > 0){				
				int len = list.size(); 
				for (int i = 0; i < len; i++) {
					emails.addTo((String)list.get(i));				
				}
			}
			List<String> ccs = mailModel.getToMailAddressCopy();
			if( null != ccs && ccs.size() > 0){				
				int lenc = ccs.size();
				for(int i = 0;i < lenc; i++){
					emails.addCc((String)ccs.get(i));
				}
			}
			emails.setSubject(mailModel.getMailTitle());
			emails.setMsg(mailModel.getMailContent());
			emails.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	/**
	 *  群发普通邮件,网页
	 */
	public boolean sendHtmlMail(EmailModel mailModel){
		try {
			HtmlEmail emails = new HtmlEmail();
			emails.setCharset("UTF-8");
			emails.setHostName(mailModel.getMailHostName());
			emails.setAuthentication(mailModel.getMailPersonName(),mailModel.getMailPersonPassword());
			emails.setFrom(mailModel.getFromMailPersonAddress(),mailModel.getFromMailPersonName());
			
			List<String> list = mailModel.getToMailAddress();
			if( null != list && list.size() > 0){				
				int len = list.size(); 
				for (int i = 0; i < len; i++) {
					emails.addTo((String)list.get(i));				
				}
			}
			
			List<String> ccs = mailModel.getToMailAddressCopy();
			if( null != ccs && ccs.size() > 0){				
				int lenc = ccs.size();
				for(int i = 0;i < lenc; i++){
					emails.addCc((String)ccs.get(i));
				}
			}
			emails.setSubject(mailModel.getMailTitle());
			emails.setHtmlMsg(mailModel.getMailContent());
			emails.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	/**
	 *  群发普通邮件,重试网页
	 */
	public String sendRetryHtmlMail(EmailModel mailModel){
		try {
			HtmlEmail emails = new HtmlEmail();
			emails.setCharset("UTF-8");
			emails.setHostName(mailModel.getMailHostName());
			emails.setAuthentication(mailModel.getMailPersonName(),mailModel.getMailPersonPassword());
			emails.setFrom(mailModel.getFromMailPersonAddress(),mailModel.getFromMailPersonName());
			
			List<String> list = mailModel.getToMailAddress();
			if( null != list && list.size() > 0){				
				int len = list.size(); 
				for (int i = 0; i < len; i++) {
					emails.addTo((String)list.get(i));				
				}
			}
			
			List<String> ccs = mailModel.getToMailAddressCopy();
			if( null != ccs && ccs.size() > 0){				
				int lenc = ccs.size();
				for(int i = 0;i < lenc; i++){
					emails.addCc((String)ccs.get(i));
				}
			}
			emails.setSubject(mailModel.getMailTitle());
			emails.setHtmlMsg(mailModel.getMailContent());
			emails.send();
			return "OK";
		} catch (EmailException e) {
			if(e.getCause().getClass().equals(SendFailedException.class)){
				SendFailedException sendException = (SendFailedException)e.getCause();
				if(sendException.getMessage().contains("Invalid Addresses")){
					String errorAdd = "";
					Address[]  address = sendException.getInvalidAddresses();
					for(Address add :address){
						InternetAddress iAdd = (InternetAddress) add;
						if(errorAdd.length()==0){
							errorAdd = iAdd.getAddress();
						}else{
							errorAdd += ","+iAdd.getAddress();
						}
					}
					return errorAdd;
				}
			}
			e.printStackTrace();
		}
		return "ERROR";
	}
}
