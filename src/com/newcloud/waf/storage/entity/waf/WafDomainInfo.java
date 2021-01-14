package com.newcloud.waf.storage.entity.waf;

import com.newcloud.waf.storage.entity.BaseEntity;

/**
 * 域名规则表
 * @author song
 *
 */
public class WafDomainInfo extends BaseEntity{
	private static final long serialVersionUID = 2253130519348764636L;
	
	private Integer wdiDniId;            //域名id
	 
	private String wdiDname;             //域名名称
	
	private Integer wdiCusId;            //客户id
	
	private String  wdiExactIds;         //关联的精准防护规则
	 
	private String  wdiCcIds;            //关联的cc防护规则
	
	private String wdiWebShield;         //防护规则策略
	
	private String  wdiIpSegment;        //ip/段
	
	
	public WafDomainInfo() {
		super();
	}

	public Integer getWdiDniId() {
		return wdiDniId;
	}

	public void setWdiDniId(Integer wdiDniId) {
		this.wdiDniId = wdiDniId;
	}

	public Integer getWdiCusId() {
		return wdiCusId;
	}

	public void setWdiCusId(Integer wdiCusId) {
		this.wdiCusId = wdiCusId;
	}

	public String getWdiDname() {
		return wdiDname;
	}

	public void setWdiDname(String wdiDname) {
		this.wdiDname = wdiDname;
	}


	public String getWdiWebShield() {
		return wdiWebShield;
	}

	public void setWdiWebShield(String wdiWebShield) {
		this.wdiWebShield = wdiWebShield;
	}

	public String getWdiIpSegment() {
		return wdiIpSegment;
	}

	public void setWdiIpSegment(String wdiIpSegment) {
		this.wdiIpSegment = wdiIpSegment;
	}

	public String getWdiExactIds() {
		return wdiExactIds;
	}


	public void setWdiExactIds(String wdiExactIds) {
		this.wdiExactIds = wdiExactIds;
	}


	public String getWdiCcIds() {
		return wdiCcIds;
	}


	public void setWdiCcIds(String wdiCcIds) {
		this.wdiCcIds = wdiCcIds;
	}


	
}