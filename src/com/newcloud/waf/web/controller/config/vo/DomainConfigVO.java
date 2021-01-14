package com.newcloud.waf.web.controller.config.vo;

/**
 * 域名配置vo
 * @author song
 *
 */
public class DomainConfigVO {
	
	private Integer domainId;                //域名id
	
	private String domainName;               //域名
	
	private String webStatus;                //web防护状态 是否开启  Y  N
	
	private String ccStatus;                 //cc防护开启状态  Y N
	
	private String ccRuleIds;                //规则ids
	
	private String ccRuleNames;              //规则名称
	
	private String exactStatus;              //精准防护状态  Y N 
	
	private String exactRuleIds;             //规则ids
	
	private String exactRuleNames;           //规则名
	
	private String ipStatus;                 //封禁ip状态
	
	private String ipSegment;                //封禁的ip或ip段

	public Integer getDomainId() {
		return domainId;
	}

	public void setDomainId(Integer domainId) {
		this.domainId = domainId;
	}

	
	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getWebStatus() {
		return webStatus;
	}

	public void setWebStatus(String webStatus) {
		this.webStatus = webStatus;
	}

	public String getCcStatus() {
		return ccStatus;
	}

	public void setCcStatus(String ccStatus) {
		this.ccStatus = ccStatus;
	}

	public String getCcRuleIds() {
		return ccRuleIds;
	}

	public void setCcRuleIds(String ccRuleIds) {
		this.ccRuleIds = ccRuleIds;
	}

	public String getCcRuleNames() {
		return ccRuleNames;
	}

	public void setCcRuleNames(String ccRuleNames) {
		this.ccRuleNames = ccRuleNames;
	}

	public String getExactStatus() {
		return exactStatus;
	}

	public void setExactStatus(String exactStatus) {
		this.exactStatus = exactStatus;
	}

	public String getExactRuleIds() {
		return exactRuleIds;
	}

	public void setExactRuleIds(String exactRuleIds) {
		this.exactRuleIds = exactRuleIds;
	}

	public String getExactRuleNames() {
		return exactRuleNames;
	}

	public void setExactRuleNames(String exactRuleNames) {
		this.exactRuleNames = exactRuleNames;
	}

	public String getIpStatus() {
		return ipStatus;
	}

	public void setIpStatus(String ipStatus) {
		this.ipStatus = ipStatus;
	}

	public String getIpSegment() {
		return ipSegment;
	}

	public void setIpSegment(String ipSegment) {
		this.ipSegment = ipSegment;
	}


}
