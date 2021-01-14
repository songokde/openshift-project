package com.newcloud.waf.mail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class EmailModel{
	private String mailHostName="smtp.new1cloud.com";         		//发送邮件的主机名
	private String mailPersonName="warning@new1cloud.com";       		//发件邮箱
	private String mailPersonPassword="Z1^ckmy%K{QN";   				//发件密码
	private String fromMailPersonName="NEW_PORTAL";   				//发送邮件显示的名字
	private String fromMailPersonAddress="warning@new1cloud.com";		//回复邮件的地址
	private String mailTitle;            							//邮件标题
	private String mailContent;          							//邮件内容
	private String toMailAddress;          							//收件人的列表
    private String toMailAddressCopy;      							//超送列表

	/**
	 * 普通邮件不抄送
	 * 
	 * @param mailTitle
	 * @param mailContent
	 * @param toMailAddress
	 */
	public EmailModel(String mailTitle, String mailContent,String toMailAddress) {
		this.mailTitle = mailTitle;
		this.mailContent = mailContent;
		this.toMailAddress = toMailAddress;
	}

	/**
	 * 普通邮件带抄送地址的构造函数
	 * 
	 * @param mailTitle
	 * @param mailContent
	 * @param toMailAddress
	 * @param toMailAddressCopy
	 */
	public EmailModel(String mailTitle, String mailContent,String toMailAddress, String toMailAddressCopy) {
		this.mailTitle = mailTitle;
		this.mailContent = mailContent;
		this.toMailAddress = toMailAddress;
		this.toMailAddressCopy = toMailAddressCopy;
	}

	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public String getMailHostName() {
		return mailHostName;
	}

	public String getMailPersonName() {
		return mailPersonName;
	}

	public String getMailPersonPassword() {
		return mailPersonPassword;
	}

	public String getFromMailPersonName() {
		return fromMailPersonName;
	}

	public String getFromMailPersonAddress() {
		return fromMailPersonAddress;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}

	public String getMailContent() {
		return mailContent;
	}

	public void setToMailAddress(String toMailAddress) {
		this.toMailAddress = toMailAddress;
	}

	public void setToMailAddressCopy(String toMailAddressCopy) {
		this.toMailAddressCopy = toMailAddressCopy;
	}

	public List<String> getToMailAddress() {
		if(null != toMailAddress){
			String[] address = toMailAddress.split(",");
			if(null != address && address.length > 0){			
				return Arrays.asList(address);
			}
		}
		List<String> list = new ArrayList<String>();
		return list;

	}
  
	public List<String> getToMailAddressCopy() {
		if(null != toMailAddressCopy){
			String[] addressCopy = toMailAddressCopy.split(",");
			if(null != addressCopy && addressCopy.length > 0){			
				return Arrays.asList(addressCopy);
			}
		}
		List<String> list = new ArrayList<String>();
		return list;
	}
	
}
